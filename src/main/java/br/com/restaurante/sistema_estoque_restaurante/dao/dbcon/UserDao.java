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
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dbcon.AcessoSQLie;
import model.User;
import model.Enum.TipoCadastro;

public class UserDao {

  /* Como economizamos espaço no db, optei por fazer um função que traduz do DB --> model */
  private User formatarUser(ResultSet saida) throws SQLException {
    User userAux = new User();
    
    userAux.setId(saida.getInt("id"));
    userAux.setNome(saida.getString("nome"));
    userAux.setSenha(saida.getString("senha"));
    userAux.setTipoCadastro(TipoCadastro.tipoCadastroInt(saida.getInt("tipoCadastro")));

    return userAux;
  }

  /* 
   * Func precisa: nome (usuário) e senha para bater retorna TRUE se sucesso e FALSE se contrário.
   *  FALTA MUDAR
   */
  public boolean fazerLoginNome(String nome, String senha, User resultado) {
    String sql = "SELECT * FROM cliente " +
                " WHERE (email = ?);";
    Connection con = null;
    PreparedStatement cmd = null;
    ResultSet saida = null;

    try {
      con = AcessoPSQL.conectar();
      if (con == null) {
        return false;
      }
      con.setAutoCommit(false);

      cmd = con.prepareStatement(sql);
      cmd.setString(1, email);

      saida = cmd.executeQuery();

      /* 1 - Existe conta com tal email? */
      if (saida.next()) {
        /* Existe!
         * Agora a senha bate? */
        if(senha.equals(saida.getString("senhaHash"))) {
          /* Sim! */
          Cliente aux = this.formatarCliente(saida);
          resultado.setCadastro(aux.getCadastro());
          resultado.setCpf(aux.getCpf());
          resultado.setTelefone(aux.getTelefone());
          resultado.setNomeCompleto(aux.getNomeCompleto());
          resultado.setId(aux.getId());
          return true;
        }
      }
      
      return false;
    } catch (SQLException deuRuim) {
      System.out.println("ERRO" + deuRuim.getMessage());
      return false;
    } finally {
      AcessoPSQL.desconectar(con);
    }
  }
}
