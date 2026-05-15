package br.com.restaurante.sistema_estoque_restaurante;

import javafx.application.*;
import javafx.fxml.*;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.stage.Stage;
import java.io.IOException;

public class App extends Application {
	
	@Override
	public void start(Stage stage) throws IOException {
		//tenta carregar a view vazia
		Parent root = FXMLLoader.load(getClass().getResource("/br/com/restaurante/sistema_estoque_restaurante/view/MainView.fxml"));
		Scene scene = new Scene(root, 800, 600);
		stage.setTitle("Sistema de Estoque - Restaurante");
        stage.setScene(scene);
        stage.show();
	}
	
	public static void main(String[] args) {
		launch();
	}

}
