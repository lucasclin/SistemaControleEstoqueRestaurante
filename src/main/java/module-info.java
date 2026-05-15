module br.com.restaurante.sistema_estoque_restaurante {
    requires javafx.controls;
    requires javafx.fxml;

    // Permite que o JavaFX acesse o subpacote controller que criaremos depois
    opens br.com.restaurante.sistema_estoque_restaurante.controller to javafx.fxml;
    
    // Exporta o pacote principal
    exports br.com.restaurante.sistema_estoque_restaurante;
}