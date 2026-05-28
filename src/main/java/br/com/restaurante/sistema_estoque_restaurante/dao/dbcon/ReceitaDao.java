/**
 * CREATE TABLE receita(
 * id INTEGER,
 * preco NUMERIC,
 * nome TEXT,
 * cardapio INTEGER,
 * PRIMARY KEY(id)
 * );
 */
package br.com.restaurante.sistema_estoque_restaurante.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dbcon.AcessoSQLie;
import model.Receita;

import model.Enum.TipoCadastro;

public class UserDao {

  /* Como economizamos espaço no db, optei por fazer um função que traduz do DB --> model */
  private void formatarReceita(ResultSet saida, Receita resultado) throws SQLException {
    
    resultado.setId(saida.getInt("id"));
    resultado.setPreco(saida.getBigDecimal("preco"));
    resultado.setNome(saida.getString("nome"));
    resultado.setCardapio(Cardapio.tipoCardapioInt(saida.getInt("cardapio")));
  }

  /* 
   *
   */
  public boolean receitaDebug(Receita resultado, int id) {
    String sql = "SELECT * FROM receita " +
                " WHERE (id = ?);";
    Connection con = null;
    PreparedStatement cmd = null;
    ResultSet saida = null;

    try {
      con = AcessoSQLite.conectar();
      if (con == null) {
        return false;
      }
      con.setAutoCommit(false);

      cmd = con.prepareStatement(sql);
      cmd.setString(1, id);

      saida = cmd.executeQuery();

      /* 1 - Existe conta com tal email? */
      if (saida.next()) {
		formatarReceita(saida, resultado);
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
