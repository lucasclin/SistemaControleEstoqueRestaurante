import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class WindowBuilder extends Application {
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("My Awesome Window");

        Pane pane = new Pane();
        pane.setPrefSize(899, 450);
        pane.setStyle("-fx-background-color: #eeeeee;");

        Button UsuariosButton = new Button("Cadastrar Usuários");
        UsuariosButton.setLayoutX(57.00);
        UsuariosButton.setLayoutY(53.00);
        UsuariosButton.setPrefWidth(164.00);
        UsuariosButton.setPrefHeight(47.00);
        UsuariosButton.setDisable(false);
        UsuariosButton.setFont(Font.loadFont(getClass().getResourceAsStream("/resources/fonts/Lexend.ttf"), 14.00));
        UsuariosButton.setStyle("-fx-background-color: #ffffff; -fx-text-fill: #1b1b1b; -fx-border-color: #626262; -fx-border-radius: 4px; -fx-background-radius: 4px; -fx-border-width: 1px;");
        UsuariosButton.addEventFilter(MouseEvent.MOUSE_PRESSED, e -> { UsuariosButton.setBackground(new Background(new BackgroundFill(Color.web("#c2c2c2"), new CornerRadii(4.00), null))); });
        UsuariosButton.addEventFilter(MouseEvent.MOUSE_RELEASED, e -> { UsuariosButton.setBackground(new Background(new BackgroundFill(Color.web("#ffffff"), new CornerRadii(4.00), null))); });
        pane.getChildren().add(UsuariosButton);

        Button ProdutosButton = new Button("Cadastrar Produtos");
        ProdutosButton.setLayoutX(57.00);
        ProdutosButton.setLayoutY(112.00);
        ProdutosButton.setPrefWidth(164.00);
        ProdutosButton.setPrefHeight(47.00);
        ProdutosButton.setDisable(false);
        ProdutosButton.setFont(Font.loadFont(getClass().getResourceAsStream("/resources/fonts/Lexend.ttf"), 14.00));
        ProdutosButton.setStyle("-fx-background-color: #ffffff; -fx-text-fill: #1b1b1b; -fx-border-color: #626262; -fx-border-radius: 4px; -fx-background-radius: 4px; -fx-border-width: 1px;");
        ProdutosButton.addEventFilter(MouseEvent.MOUSE_PRESSED, e -> { ProdutosButton.setBackground(new Background(new BackgroundFill(Color.web("#c2c2c2"), new CornerRadii(4.00), null))); });
        ProdutosButton.addEventFilter(MouseEvent.MOUSE_RELEASED, e -> { ProdutosButton.setBackground(new Background(new BackgroundFill(Color.web("#ffffff"), new CornerRadii(4.00), null))); });
        pane.getChildren().add(ProdutosButton);

        Button UnidadesButton = new Button("Cadastrar Unidades");
        UnidadesButton.setLayoutX(57.00);
        UnidadesButton.setLayoutY(167.00);
        UnidadesButton.setPrefWidth(164.00);
        UnidadesButton.setPrefHeight(47.00);
        UnidadesButton.setDisable(false);
        UnidadesButton.setFont(Font.loadFont(getClass().getResourceAsStream("/resources/fonts/Lexend.ttf"), 14.00));
        UnidadesButton.setStyle("-fx-background-color: #ffffff; -fx-text-fill: #1b1b1b; -fx-border-color: #626262; -fx-border-radius: 4px; -fx-background-radius: 4px; -fx-border-width: 1px;");
        UnidadesButton.addEventFilter(MouseEvent.MOUSE_PRESSED, e -> { UnidadesButton.setBackground(new Background(new BackgroundFill(Color.web("#c2c2c2"), new CornerRadii(4.00), null))); });
        UnidadesButton.addEventFilter(MouseEvent.MOUSE_RELEASED, e -> { UnidadesButton.setBackground(new Background(new BackgroundFill(Color.web("#ffffff"), new CornerRadii(4.00), null))); });
        pane.getChildren().add(UnidadesButton);

        Button ReceitasButton = new Button("Cadastrar Receitas");
        ReceitasButton.setLayoutX(57.00);
        ReceitasButton.setLayoutY(223.00);
        ReceitasButton.setPrefWidth(164.00);
        ReceitasButton.setPrefHeight(47.00);
        ReceitasButton.setDisable(false);
        ReceitasButton.setFont(Font.loadFont(getClass().getResourceAsStream("/resources/fonts/Lexend.ttf"), 14.00));
        ReceitasButton.setStyle("-fx-background-color: #ffffff; -fx-text-fill: #1b1b1b; -fx-border-color: #626262; -fx-border-radius: 4px; -fx-background-radius: 4px; -fx-border-width: 1px;");
        ReceitasButton.addEventFilter(MouseEvent.MOUSE_PRESSED, e -> { ReceitasButton.setBackground(new Background(new BackgroundFill(Color.web("#c2c2c2"), new CornerRadii(4.00), null))); });
        ReceitasButton.addEventFilter(MouseEvent.MOUSE_RELEASED, e -> { ReceitasButton.setBackground(new Background(new BackgroundFill(Color.web("#ffffff"), new CornerRadii(4.00), null))); });
        pane.getChildren().add(ReceitasButton);

        TextField element5 = new TextField("");
        element5.setLayoutX(283.00);
        element5.setLayoutY(59.00);
        element5.setPrefWidth(105.81);
        element5.setPrefHeight(24.00);
        element5.setPromptText("Your Input!");
        element5.setFont(Font.loadFont(getClass().getResourceAsStream("/resources/fonts/Lexend.ttf"), 14.00));
        element5.setStyle("-fx-background-color: #ffffff; -fx-text-fill: #1b1b1b; -fx-border-color: #626262; -fx-border-width: 1px; -fx-border-radius: 2px; -fx-prompt-text-fill: #737674;");
        pane.getChildren().add(element5);

        Button CadastrarButton = new Button("Cadastrar");
        CadastrarButton.setLayoutX(763.19);
        CadastrarButton.setLayoutY(383.00);
        CadastrarButton.setPrefWidth(105.81);
        CadastrarButton.setPrefHeight(30.00);
        CadastrarButton.setDisable(true);
        CadastrarButton.setFont(Font.loadFont(getClass().getResourceAsStream("/resources/fonts/Lexend.ttf"), 14.00));
        CadastrarButton.setStyle("-fx-background-color: #ffffff; -fx-text-fill: #1b1b1b; -fx-border-color: #626262; -fx-border-radius: 4px; -fx-background-radius: 4px; -fx-border-width: 1px;");
        CadastrarButton.addEventFilter(MouseEvent.MOUSE_PRESSED, e -> { CadastrarButton.setBackground(new Background(new BackgroundFill(Color.web("#c2c2c2"), new CornerRadii(4.00), null))); });
        CadastrarButton.addEventFilter(MouseEvent.MOUSE_RELEASED, e -> { CadastrarButton.setBackground(new Background(new BackgroundFill(Color.web("#ffffff"), new CornerRadii(4.00), null))); });
        pane.getChildren().add(CadastrarButton);

        Button RemoverButton = new Button("Remover");
        RemoverButton.setLayoutX(648.00);
        RemoverButton.setLayoutY(382.00);
        RemoverButton.setPrefWidth(105.81);
        RemoverButton.setPrefHeight(30.00);
        RemoverButton.setDisable(true);
        RemoverButton.setFont(Font.loadFont(getClass().getResourceAsStream("/resources/fonts/Lexend.ttf"), 14.00));
        RemoverButton.setStyle("-fx-background-color: #ffffff; -fx-text-fill: #1b1b1b; -fx-border-color: #626262; -fx-border-radius: 4px; -fx-background-radius: 4px; -fx-border-width: 1px;");
        RemoverButton.addEventFilter(MouseEvent.MOUSE_PRESSED, e -> { RemoverButton.setBackground(new Background(new BackgroundFill(Color.web("#c2c2c2"), new CornerRadii(4.00), null))); });
        RemoverButton.addEventFilter(MouseEvent.MOUSE_RELEASED, e -> { RemoverButton.setBackground(new Background(new BackgroundFill(Color.web("#ffffff"), new CornerRadii(4.00), null))); });
        pane.getChildren().add(RemoverButton);

        Scene scene = new Scene(pane, 899, 450);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}