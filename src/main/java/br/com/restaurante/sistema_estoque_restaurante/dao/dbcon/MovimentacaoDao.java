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
);
*/
package br.com.restaurante.sistema_estoque_restaurante.dao.dbcon;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.restaurante.sistema_estoque_restaurante.model.MovimentacaoEstoqueDeProduto;
import br.com.restaurante.sistema_estoque_restaurante.model.Produto;
import br.com.restaurante.sistema_estoque_restaurante.model.User;


public class MovimentacaoDao {
    
    private void formatarMovimentacao(MovimentacaoEstoqueDeProduto resultado, ResultSet saida) throws SQLException {
        resultado.setId(Long.valueOf(saida.getInt("id")));
        resultado.setIdProduto(saida.getInt("id_p"));
        resultado.setIdUsuario(saida.getInt("id_u"));
        resultado.setTipoMovimentacao(tipoMovimentacao.tipoMovimentacaoInt(saida.getInt("tipoMovimentacao")));
        resultado.setDataMovimentacao(saida.getString("dataMovimentacao"));
        resultado.setQuantidade(saida.getBigDecimal("quantidade"));
        resultado.setPrecoUnitario(saida.getBigDecimal("precoUnitario"));
        resultado.setDataValidade(saida.getString("dataValidade"));
        resultado.setObservacao(saida.getString("observacao"));
    }
}
