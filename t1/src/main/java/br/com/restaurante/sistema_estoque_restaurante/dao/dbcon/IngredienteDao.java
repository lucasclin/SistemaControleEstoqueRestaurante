package br.com.restaurante.sistema_estoque_restaurante.dao.dbcon;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.restaurante.sistema_estoque_restaurante.model.Ingrediente;
import br.com.restaurante.sistema_estoque_restaurante.model.Produto;
import br.com.restaurante.sistema_estoque_restaurante.model.Receita;

public class IngredienteDao {

  /* Como economizamos espaço no db, optei por fazer um função que traduz do DB --> model */
  private void formatarIngrediente(Ingrediente resultado, ResultSet saida) throws SQLException {
    ProdutoDao produtoDao = new ProdutoDao();
    Produto produto = new Produto();
    produtoDao.retornar(saida.getInt("id_p"), produto);

    ReceitaDao receitaDao = new ReceitaDao();
    Receita receita = new Receita();
    receitaDao.retornar(saida.getInt("id_r"), receita);

    resultado.setReceita(receita);
    resultado.setProduto(produto);
    resultado.setQuantidadeProduto(saida.getBigDecimal("quantidade"));
  }

  /*  CREATE TABLE ingrediente(
	id_p INTEGER,
	id_r INTEGER,
	quantidade NUMERIC,
	FOREIGN KEY (id_p) REFERENCES produto(id),
	FOREIGN KEY (id_r) REFERENCES receita(id),
	PRIMARY KEY(id_p, id_r)
);   */
  
  public boolean retornar(int id, Ingrediente resultado) {
    String sql = "SELECT * FROM ingrediente";
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
        formatarIngrediente(resultado, saida);
        
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

  public boolean inserir(Ingrediente ingrediente) {
    String sql = "INSERT INTO ingrediente (id_p, id_r, quantidade) VALUES (?, ?, ?)";
    Connection con = null;
    PreparedStatement cmd;

    try {
      con = AcessoSQLite.conectar();
      if (con == null) {
        return false;
      }
      con.setAutoCommit(false);

      cmd = con.prepareStatement(sql);
      cmd.setInt(1, Math.toIntExact(ingrediente.getProduto().getId()));
      cmd.setInt(2, Math.toIntExact(ingrediente.getReceita().getId()));
      cmd.setBigDecimal(3, ingrediente.getQuantidadeProduto());

      int linhasAfetadas = cmd.executeUpdate();
      con.commit();

      return linhasAfetadas > 0;
    } catch (SQLException deuRuim) {
      System.out.println("ERRO" + deuRuim.getMessage());
      return false;
    } finally {
      AcessoSQLite.desconectar(con);
    }
  }
}
