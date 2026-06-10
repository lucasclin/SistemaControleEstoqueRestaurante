package sdedr.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import sdedr.dao.dbcon.AcessoSQLite;

import sdedr.model.Produto;
import sdedr.model.MovimentacaoEstoqueDeProduto;
import sdedr.model.Enum.TipoMovimentacao;
import sdedr.model.User;

public class MovimentacaoDao {

  /* Como economizamos espaço no db, optei por fazer um função que traduz do DB --> model */
  private void formatarMovimentacao(MovimentacaoEstoqueDeProduto resultado, ResultSet saida) throws SQLException {
    resultado.setId(Long.valueOf(saida.getInt("id")));

    ProdutoDao produtoDao = new ProdutoDao();
    Produto produto = new Produto();
    produtoDao.retornar(saida.getInt("id_p"), produto);
    resultado.setProduto(produto);

    UserDao userDao = new UserDao();
    User user = new User();
    userDao.retornar(saida.getInt("id_u"), user);
    resultado.setUser(user);

    resultado.setTipoMovimentacao(TipoMovimentacao.tipoMovimentacaoInt(saida.getInt("tipoMovimentacao")));

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    resultado.setDataHora(LocalDateTime.parse(saida.getString("dataMovimentacao"), formatter));

    resultado.setQuantidade(saida.getBigDecimal("quantidade"));
    resultado.setPrecoUnitario(saida.getBigDecimal("precoUnitario"));
    resultado.setValidadeLote(LocalDate.parse(saida.getString("dataValidade")));
    resultado.setObservacao(saida.getString("observacao"));
  }
        /*
        CREATE TABLE movimentacao(
        id INTEGER,
        id_p INTEGER,
        id_u INTEGER,
        tipoMovimentacao INTEGER,
        dataMovimentacao TEXT,
        quantidade NUMERIC,
        precoUnitario NUMERIC,
        dataValidade TEXT,
        observacao TEXT,
        FOREIGN KEY (id_p) REFERENCES produto(id),
        FOREIGN KEY (id_u) REFERENCES user(id),
        PRIMARY KEY(id)
);*/
  public boolean retornar(int id, MovimentacaoEstoqueDeProduto resultado) {
    String sql = "SELECT * FROM movimentacao WHERE id = ?";
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
        formatarMovimentacao(resultado, saida);
        
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

  public boolean inserir(MovimentacaoEstoqueDeProduto movimentacao) {
    String sql = "INSERT INTO movimentacao (id_p, id_u, tipoMovimentacao, dataMovimentacao, quantidade, precoUnitario, dataValidade, observacao) VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
    Connection con = null;
    PreparedStatement cmd;

    try {
      con = AcessoSQLite.conectar();
      if (con == null) {
        return false;
      }
      con.setAutoCommit(false);

      cmd = con.prepareStatement(sql);
      cmd.setInt(1, movimentacao.getProduto().getId().intValue());
      cmd.setInt(2, movimentacao.getUser().getId().intValue());
      cmd.setInt(3, movimentacao.getTipoMovimentacao().ordinal());
      cmd.setString(4, movimentacao.getDataHora().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
      cmd.setBigDecimal(5, movimentacao.getQuantidade());
      cmd.setBigDecimal(6, movimentacao.getPrecoUnitario());
      cmd.setString(7, movimentacao.getValidadeLote().toString());
      cmd.setString(8, movimentacao.getObservacao());

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
