package br.com.restaurante.sistema_estoque_restaurante.dao.dbcon;
/* 
 * Isso copiei e adaptei do exemplo de ling. prog. 1.
 *
 * Precisa testar no computador do ifsp, se a conexão funciona.
 * */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AcessoSQLite {
  private static final String DATABASE = "SistemaControleEstoqueRestaurante/Database/estoque";
  private static final String URL = "jdbc:sqlite:"+ DATABASE +".db";
  
  public static Connection conectar() {
    try {
      //Class.forName(DRIVER);                        
      return DriverManager.getConnection(URL);
      //ClassNotFoundException |
    } catch ( SQLException e) {
      System.err.println("ERRO" + e.getMessage());
      return null;
    }
  }

  public static void desconectar(Connection con) {
    try {
      if (con != null) {
        con.close();
      }
    } catch (SQLException e) {
      System.err.println("ERRO");
    }
  }
}
