package sdedr.dao.dbcon;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AcessoSQLite {
  /* Retorna o dir principal C:/User/Aluno...
   * ou melhor no linux home/Aluno...
   */
  /* Se colocar dentro de Downloads ou Documents, ou gGit.
   */
  private static final String DATABASE = "Database/estoque";
  private static final String URL = "jdbc:sqlite:"+ DATABASE +".db";
  
  public static Connection conectar() {
    try {
      return DriverManager.getConnection(URL);
    } catch ( SQLException erro) {
      System.err.println("ERRO" + erro.getMessage());
      return null;
    }
  }

  public static void desconectar(Connection con) {
    try {
      if (con != null) {
        con.close();
      }
    } catch (SQLException erro) {
      System.err.println("ERRO" + erro.getMessage());
    }
  }
}
