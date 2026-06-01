/*
 * CREATE TABLE receita(
 * id INTEGER,
 * preco NUMERIC,
 * nome TEXT,
 * cardapio INTEGER,
 * PRIMARY KEY(id)
 * );
 */
package sdedr.dao;

import java.util.ArrayList;
import java.util.List;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import sdedr.model.Enum.Cardapio;
import sdedr.model.Receita;
import sdedr.dao.dbcon.AcessoSQLite;

public class ReceitaDao {

  /* Como economizamos espaço no db, optei por fazer um função que traduz do DB --> model */
  private void formatarReceita(ResultSet saida, Receita resultado) throws SQLException {
    resultado.setId(Long.valueOf(saida.getInt("id")));
    resultado.setPreco(saida.getBigDecimal("preco"));
    resultado.setNome(saida.getString("nome"));
    resultado.setCardapio(Cardapio.tipoCardapioInt(saida.getInt("cardapio")));
  }

  /* Func alocar ArrayList<Receita> : TRUE deu certo e FALSE ruim */
  public boolean retornarTudo(ArrayList<Receita> resultado) {
    String sql = "SELECT * FROM receita";
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
        Receita novoAux = new Receita();
		    formatarReceita(saida, novoAux);
        resultado.add(novoAux);
      }

      return resultado.isEmpty() ? false : true;
    } catch (SQLException deuRuim) {
      System.out.println("ERRO [retornarTudo]: " + deuRuim.getMessage());
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
