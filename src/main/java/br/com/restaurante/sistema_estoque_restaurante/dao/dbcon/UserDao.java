/*
 * CREATE TABLE user(
 * id INTEGER,
 * nome TEXT,
 * senha TEXT,
 * tipoCadastro INTEGER,
 * PRIMARY KEY(id)
 * );
 */
package br.com.restaurante.sistema_estoque_restaurante.dao.dbcon;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.restaurante.sistema_estoque_restaurante.model.TipoCadastro;
import br.com.restaurante.sistema_estoque_restaurante.model.User;

public class UserDao {

  /* Como economizamos espaço no db, optei por fazer um função que traduz do DB --> model */
  private void formatarUser(User resultado, ResultSet saida) throws SQLException {
    resultado.setId(Long.valueOf(saida.getInt("id")));
    resultado.setNome(saida.getString("nome"));
    resultado.setSenha(saida.getString("senha"));
    resultado.setTipoCadastro(TipoCadastro.tipoCadastroInt(saida.getInt("tipoCadastro")));
  }

  

  /* 
   * Func precisa: nome (usuário) e senha para bater retorna TRUE se sucesso e FALSE se contrário.
   *  FALTA MUDAR
   */
  public boolean retornar(int id, User resultado) {
    String sql = "SELECT * FROM user";
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
      saida = cmd.executeQuery();

      /* 1 - Existe conta com tal email? */
      if (saida.next()) {
        formatarUser(resultado, saida);
        
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
