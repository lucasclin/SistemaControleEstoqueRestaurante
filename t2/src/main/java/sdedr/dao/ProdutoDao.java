package sdedr.dao;

import java.util.ArrayList;
import java.util.List;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import sdedr.model.Produto;
import sdedr.model.Unidade;
import sdedr.dao.dbcon.AcessoSQLite;

/* CREATE TABLE produto(
 * id INTEGER,
 * nome TEXT,
 * precoAtual NUMERIC,
 * quantidadeEstoque NUMERIC,
 * estoqueMinimo NUMERIC,
 * permiteFracionamento INTEGER,
 * ativo INTEGER, 
 * PRIMARY KEY(id)
 * ); */

public class ProdutoDao {

  /* Como economizamos espaço no db, optei por fazer um função que traduz do DB --> model */
  private void formatarProduto(Produto resultado, ResultSet saida) throws SQLException {
    resultado.setId(Long.valueOf(saida.getInt("id")));
    resultado.setNome(saida.getString("nome"));
    resultado.setPrecoAtual(saida.getBigDecimal("precoAtual"));
    resultado.setQuantidadeEstoque(saida.getBigDecimal("quantidadeEstoque"));
    resultado.setEstoqueMinimo(saida.getBigDecimal("estoqueMinimo"));

    if(saida.getInt("permiteFracionamento") == 1) {
      resultado.setPermiteFracionamento(true);
    } else {
      resultado.setPermiteFracionamento(false);
    }

    if (saida.getInt("ativo") == 1) {
      resultado.setAtivo(true);
    } else {
      resultado.setAtivo(false);
    }
  }

  /* Func alocar ArrayList<Produto> : TRUE deu certo e FALSE ruim */
  public boolean retornarTudo(ArrayList<Produto> resultado) {
    /* colocamos os NOMES DAS COLUNAS IGUAIS!!! AGORA TEMOS QUE IMPROVISAR: */
    String sql = "SELECT p.*, u.id AS u_id, u.nome AS u_nome, u.descricao AS u_desc "
               + "FROM produto AS p LEFT JOIN tipoUnidade AS t ON (p.id = t.id_p) "
                                 + "LEFT JOIN unidade AS u ON (t.id_u = u.id)";
    Connection con = null;
    PreparedStatement cmd;
    ResultSet saida;
    try {
      con = AcessoSQLite.conectar();
      if (con == null) {
        return false;
      }

      cmd = con.prepareStatement(sql);
      saida = cmd.executeQuery();

      while (saida.next()) {
        Produto novoAux = new Produto();
        formatarProduto(novoAux, saida);

        if(saida.getString("u_nome") != null) {
          Unidade unidadeTmp = new Unidade();
          unidadeTmp.setId(Long.valueOf(saida.getInt("u_id")));
          unidadeTmp.setNome(saida.getString("u_nome"));
          unidadeTmp.setDescricao(saida.getString("u_descricao"));
          novoAux.setUnidade(unidadeTmp);
        }

        resultado.add(novoAux);
      }
      
      return resultado.isEmpty() ? false : true;
    } catch (SQLException deuRuim) {
      System.out.println("ERRO [retornarTudo]:" + deuRuim.getMessage());
      return false;
    } finally {
      AcessoSQLite.desconectar(con);
    }
  }

  public boolean retornar(int id, Produto resultado) {
    String sql = "SELECT * FROM produto WHERE id = ?";
    Connection con = null;
    PreparedStatement cmd;
    ResultSet saida;
    try {
      con = AcessoSQLite.conectar();
      if (con == null) {
        return false;
      }
      con.setAutoCommit(false);

      cmd = con.prepareStatement(sql);
      cmd.setInt(1, id);
      saida = cmd.executeQuery();

      /* 1 - Existe conta com tal email? */
      if (saida.next()) {
        formatarProduto(resultado, saida);
        
        return true;
      }
      
      return false;
    } catch (SQLException deuRuim) {
      System.out.println("ERRO" + deuRuim.getMessage());
      return false;
    } finally {
      AcessoSQLite.desconectar(con);
    }
  }

  public boolean inserir(Produto produto) {
    String sql = "INSERT INTO produto (nome, precoAtual, quantidadeEstoque, estoqueMinimo, permiteFracionamento, ativo) VALUES (?, ?, ?, ?, ?, ?);";
    Connection con = null;
    PreparedStatement cmd;

    try {
      con = AcessoSQLite.conectar();
      if (con == null) {
        return false;
      }
      con.setAutoCommit(false);

      cmd = con.prepareStatement(sql);
      cmd.setString(1, produto.getNome());
      cmd.setBigDecimal(2, produto.getPrecoAtual());
      cmd.setBigDecimal(3, produto.getQuantidadeEstoque());
      cmd.setBigDecimal(4, produto.getEstoqueMinimo());
      cmd.setInt(5, produto.isPermiteFracionamento() ? 1 : 0);
      cmd.setInt(6, produto.isAtivo() ? 1 : 0);

      cmd.executeUpdate();
      con.commit();
      
      return true;
    } catch (SQLException deuRuim) {
      System.out.println("ERRO" + deuRuim.getMessage());
      return false;
    } finally {
      AcessoSQLite.desconectar(con);
    }
  }
}
