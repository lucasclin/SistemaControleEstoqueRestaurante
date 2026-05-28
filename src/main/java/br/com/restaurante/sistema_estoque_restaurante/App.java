package br.com.restaurante.sistema_estoque_restaurante;

import java.time.LocalDate;
import java.time.LocalDateTime;

import br.com.restaurante.sistema_estoque_restaurante.dao.dbcon.IngredienteDao;
import br.com.restaurante.sistema_estoque_restaurante.dao.dbcon.MovimentacaoDao;
import br.com.restaurante.sistema_estoque_restaurante.dao.dbcon.ProdutoDao;
import br.com.restaurante.sistema_estoque_restaurante.dao.dbcon.ReceitaDao;
import br.com.restaurante.sistema_estoque_restaurante.dao.dbcon.UserDao;
import br.com.restaurante.sistema_estoque_restaurante.model.Cardapio;
import br.com.restaurante.sistema_estoque_restaurante.model.Ingrediente;
import br.com.restaurante.sistema_estoque_restaurante.model.MovimentacaoEstoqueDeProduto;
import br.com.restaurante.sistema_estoque_restaurante.model.Produto;
import br.com.restaurante.sistema_estoque_restaurante.model.Receita;
import br.com.restaurante.sistema_estoque_restaurante.model.TipoCadastro;
import br.com.restaurante.sistema_estoque_restaurante.model.TipoMovimentacao;
import br.com.restaurante.sistema_estoque_restaurante.model.User;

public class App /*extends Application*/ {
	/*
	@Override
	public void start(Stage stage) throws IOException {
		//tenta carregar a view vazia
		Parent root = FXMLLoader.load(getClass().getResource("/br/com/restaurante/sistema_estoque_restaurante/view/MainView.fxml"));
		Scene scene = new Scene(root, 800, 600);
		stage.setTitle("Sistema de Estoque - Restaurante");
        stage.setScene(scene);
        stage.show();
	} */
	
	public static void main(String[] args) {
		/*
		User user = new User();
		UserDao userDao = new UserDao();

		if(userDao.retornar(2, user)){
			System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
			System.out.println("ID: " + user.getId());
			System.out.println("Nome: " + user.getNome());
			System.out.println("Senha: " + user.getSenha());
			System.out.println("Tipo Cadastro: " + user.getTipoCadastro());
			System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
		} else {
			System.out.println("Usuário não encontrado.");
		}

		Produto produto = new Produto();
		ProdutoDao produtoDao = new ProdutoDao();

		if(produtoDao.retornar(2, produto)){
			System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
			System.out.println("ID: " + produto.getId());
			System.out.println("Nome: " + produto.getNome());
			System.out.println("Preço Atual: " + produto.getPrecoAtual());
			System.out.println("Quantidade Estoque: " + produto.getQuantidadeEstoque());
			System.out.println("Estoque Mínimo: " + produto.getEstoqueMinimo());
			System.out.println("Permite Fracionamento: " + produto.isPermiteFracionamento());
			System.out.println("Ativo: " + produto.isAtivo());
			System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
		} else {
			System.out.println("Produto não encontrado.");
		}

		IngredienteDao ingredienteDao = new IngredienteDao();
		Ingrediente ingrediente = new Ingrediente();

		if (ingredienteDao.retornar(1, ingrediente)){
			System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
			System.out.println("Produto: " + ingrediente.getProduto().getNome());
			System.out.println("Receita: " + ingrediente.getReceita().getNome());
			System.out.println("Quantidade Produto: " + ingrediente.getQuantidadeProduto());
			System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
		} else {
			System.out.println("Ingrediente não encontrado.");
		}

		ReceitaDao receitaDao = new ReceitaDao();
		Receita receita = new Receita();

		if (receitaDao.retornar(1, receita)){
			System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
			System.out.println("ID: " + receita.getId());
			System.out.println("Nome: " + receita.getNome());
			System.out.println("Preço: " + receita.getPreco());
			System.out.println("Cardápio: " + receita.getCardapio());
			System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
		} else {
			System.out.println("Receita não encontrada.");
		}

		MovimentacaoDao movimentacaoDao = new MovimentacaoDao();
		MovimentacaoEstoqueDeProduto movimentacao = new MovimentacaoEstoqueDeProduto();
		
		if (movimentacaoDao.retornar(1, movimentacao)){
			System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
			System.out.println("ID: " + movimentacao.getId());
			System.out.println("Produto: " + movimentacao.getProduto().getNome());
			System.out.println("Usuário: " + movimentacao.getUser().getNome());
			System.out.println("Tipo Movimentação: " + movimentacao.getTipoMovimentacao());
			System.out.println("Data/Hora: " + movimentacao.getDataHora());
			System.out.println("Quantidade: " + movimentacao.getQuantidade());
			System.out.println("Preço Unitário: " + movimentacao.getPrecoUnitario());
			System.out.println("Validade Lote: " + movimentacao.getValidadeLote());
			System.out.println("Observação: " + movimentacao.getObservacao());
			System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
		} else {
			System.out.println("Movimentação não encontrada.");
		}*/

		/*
		ProdutoDao produtoDao = new ProdutoDao();
		Produto produto = new Produto(Long.valueOf(4), "Coca-Cola", new java.math.BigDecimal("5.00"), new java.math.BigDecimal("100.00"), new java.math.BigDecimal("10.00"), true, false);
		produtoDao.inserir(produto);

		ReceitaDao receitaDao = new ReceitaDao();
		Receita receita = new Receita(Long.valueOf(4), "Coca-Cola Gelada", new java.math.BigDecimal("7.00"), Cardapio.FIXO);
		receitaDao.inserir(receita);

		IngredienteDao ingredienteDao = new IngredienteDao();
		Ingrediente ingrediente = new Ingrediente(new java.math.BigDecimal("2.00"), produto, receita);
		ingredienteDao.inserir(ingrediente);

		UserDao userDao = new UserDao();
		User user = new User();
		userDao.retornar(2, user);

		MovimentacaoDao movimentacaoDao = new MovimentacaoDao();
		MovimentacaoEstoqueDeProduto movimentacao = new MovimentacaoEstoqueDeProduto(Long.valueOf(2), LocalDateTime.now(), new java.math.BigDecimal("2.0"), new java.math.BigDecimal("5.0"), LocalDate.now().plusMonths(1), "Entrada teste", TipoMovimentacao.ENTRADA, produto, user);
		movimentacaoDao.inserir(movimentacao); */
	}
}
