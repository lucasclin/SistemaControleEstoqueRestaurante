/**
 * CREATE TABLE receita(
 * id INTEGER,
 * preco NUMERIC,
 * nome TEXT,
 * cardapio INTEGER,
 * PRIMARY KEY(id)
 * );
 */
package br.com.restaurante.sistema_estoque_restaurante.dao.dbcon;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.restaurante.sistema_estoque_restaurante.model.Cardapio;
import br.com.restaurante.sistema_estoque_restaurante.model.Receita;


public class ReceitaDao {

  /* Como economizamos espaço no db, optei por fazer um função que traduz do DB --> model */
  private void formatarReceita(ResultSet saida, Receita resultado) throws SQLException {

    resultado.setId(Long.valueOf(saida.getInt("id")));
    resultado.setPreco(saida.getBigDecimal("preco"));
    resultado.setNome(saida.getString("nome"));
    resultado.setCardapio(Cardapio.tipoCardapioInt(saida.getInt("cardapio")));
  }

  /* 
   * Func precisa: id para buscar a receita e retorna TRUE se sucesso e FALSE se contrário.
   */
  public boolean retornar(int id, Receita resultado) {
    String sql = "SELECT * FROM receita " +
                " WHERE (id = ?);";
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
      cmd.setLong(1, id);

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

  public boolean inserir(Receita receita) {
    String sql = "INSERT INTO receita (preco, nome, cardapio) VALUES (?, ?, ?);";
    Connection con = null;
    PreparedStatement cmd;

    try {
      con = AcessoSQLite.conectar();
      if (con == null) {
        return false;
      }
      con.setAutoCommit(false);

      cmd = con.prepareStatement(sql);
      cmd.setBigDecimal(1, receita.getPreco());
      cmd.setString(2, receita.getNome());
      cmd.setInt(3, receita.getCardapio().ordinal());

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
