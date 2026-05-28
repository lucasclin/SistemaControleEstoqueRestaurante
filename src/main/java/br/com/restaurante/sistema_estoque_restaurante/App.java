package br.com.restaurante.sistema_estoque_restaurante;

import br.com.restaurante.sistema_estoque_restaurante.dao.dbcon.IngredienteDao;
import br.com.restaurante.sistema_estoque_restaurante.dao.dbcon.ProdutoDao;
import br.com.restaurante.sistema_estoque_restaurante.dao.dbcon.UserDao;
import br.com.restaurante.sistema_estoque_restaurante.model.Ingrediente;
import br.com.restaurante.sistema_estoque_restaurante.model.Produto;
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
		/*launch();*/
		User user = new User();
		UserDao userDao = new UserDao();

		if(userDao.retornar(1, user)){
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

		if(ingredienteDao.retornar(1, ingrediente)){
			System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
			System.out.println("ID: " + ingrediente.getId());
			System.out.println("Quantidade Produto: " + ingrediente.getQuantidadeProduto());
			System.out.println("Produto: " + ingrediente.getProduto().getNome());
			System.out.println("Receita: " + ingrediente.getReceita().getNome());
			System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
		} else {
			System.out.println("Ingrediente não encontrado.");
		}
	}

}
