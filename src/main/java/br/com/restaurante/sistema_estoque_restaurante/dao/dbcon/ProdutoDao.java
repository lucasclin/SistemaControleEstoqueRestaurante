package br.com.restaurante.sistema_estoque_restaurante.dao.dbcon;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.restaurante.sistema_estoque_restaurante.model.Produto;

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
        /*
        CREATE TABLE produto(
            id INTEGER,
            nome TEXT,
            precoAtual NUMERIC,
            quantidadeEstoque NUMERIC,
            estoqueMinimo NUMERIC,
            permiteFracionamento INTEGER,
            ativo INTEGER, 
            PRIMARY KEY(id)
        ); */
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
}
