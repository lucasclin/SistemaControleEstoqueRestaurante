module sdedr {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires spring.security.crypto;
    requires javafx.graphics;

    // Permite que o JavaFX acesse o subpacote controller que criaremos depois
    /*opens br.com.restaurante.sistema_estoque_restaurante.controller to javafx.fxml;*/
    opens sdedr.model to javafx.base;
    // Exporta o pacote principal
    exports sdedr;
}
