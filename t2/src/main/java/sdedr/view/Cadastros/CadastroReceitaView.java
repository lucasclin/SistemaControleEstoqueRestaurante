package sdedr.view.Cadastros;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class CadastroReceitaView extends Application {
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("My Awesome Window");

        Pane pane = new Pane();
        pane.setPrefSize(899, 450);
        pane.setStyle("-fx-background-color: #eeeeee;");

        Label CadastrarReceitaTXT = new Label("Cadastro de Receita");
        CadastrarReceitaTXT.setLayoutX(24.5625);
        CadastrarReceitaTXT.setLayoutY(19.359375);
        CadastrarReceitaTXT.setPrefWidth(150);
        CadastrarReceitaTXT.setPrefHeight(19);
        CadastrarReceitaTXT.setFont(Font.loadFont(getClass().getResourceAsStream("/resources/fonts/Lexend.ttf"), 14.00));
        CadastrarReceitaTXT.setStyle("-fx-text-fill: #1b1b1b;");
        pane.getChildren().add(CadastrarReceitaTXT);

        TextField nomeInput = new TextField("");
        nomeInput.setLayoutX(78.00);
        nomeInput.setLayoutY(96.00);
        nomeInput.setPrefWidth(224.00);
        nomeInput.setPrefHeight(24.00);
        nomeInput.setPromptText("Nome da receita");
        nomeInput.setFont(Font.loadFont(getClass().getResourceAsStream("/resources/fonts/Lexend.ttf"), 14.00));
        nomeInput.setStyle("-fx-background-color: #ffffff; -fx-text-fill: #1b1b1b; -fx-border-color: #626262; -fx-border-width: 1px; -fx-border-radius: 2px; -fx-prompt-text-fill: #737674;");
        pane.getChildren().add(nomeInput);

        Label element6 = new Label("Insira as informações do cadastro");
        element6.setLayoutX(56);
        element6.setLayoutY(55);
        element6.setPrefWidth(235);
        element6.setPrefHeight(17);
        element6.setFont(Font.loadFont(getClass().getResourceAsStream("/resources/fonts/Lexend.ttf"), 14.00));
        element6.setStyle("-fx-text-fill: #1b1b1b;");
        pane.getChildren().add(element6);

        Button ConfirmarButton = new Button("Confirmar Cadastro");
        ConfirmarButton.setLayoutX(775.00);
        ConfirmarButton.setLayoutY(365.61);
        ConfirmarButton.setPrefWidth(106.00);
        ConfirmarButton.setPrefHeight(69.00);
        ConfirmarButton.setDisable(false);
        ConfirmarButton.setFont(Font.loadFont(getClass().getResourceAsStream("/resources/fonts/Lexend.ttf"), 14.00));
        ConfirmarButton.setStyle("-fx-background-color: #ffffff; -fx-text-fill: #1b1b1b; -fx-border-color: #626262; -fx-border-radius: 4px; -fx-background-radius: 4px; -fx-border-width: 1px;");
        ConfirmarButton.addEventFilter(MouseEvent.MOUSE_PRESSED, e -> { ConfirmarButton.setBackground(new Background(new BackgroundFill(Color.web("#c2c2c2"), new CornerRadii(4.00), null))); });
        ConfirmarButton.addEventFilter(MouseEvent.MOUSE_RELEASED, e -> { ConfirmarButton.setBackground(new Background(new BackgroundFill(Color.web("#ffffff"), new CornerRadii(4.00), null))); });
        pane.getChildren().add(ConfirmarButton);

        TextField element9 = new TextField("");
        element9.setLayoutX(77.56);
        element9.setLayoutY(131.11);
        element9.setPrefWidth(224.00);
        element9.setPrefHeight(24.00);
        element9.setPromptText("Preço da receita");
        element9.setFont(Font.loadFont(getClass().getResourceAsStream("/resources/fonts/Lexend.ttf"), 14.00));
        element9.setStyle("-fx-background-color: #ffffff; -fx-text-fill: #1b1b1b; -fx-border-color: #626262; -fx-border-width: 1px; -fx-border-radius: 2px; -fx-prompt-text-fill: #737674;");
        pane.getChildren().add(element9);

        Label cardapioTXT = new Label("A qual cardápio essa receita vai pertencer?");
        cardapioTXT.setLayoutX(55);
        cardapioTXT.setLayoutY(189);
        cardapioTXT.setPrefWidth(300);
        cardapioTXT.setPrefHeight(19);
        cardapioTXT.setFont(Font.loadFont(getClass().getResourceAsStream("/resources/fonts/Lexend.ttf"), 14.00));
        cardapioTXT.setStyle("-fx-text-fill: #1b1b1b;");
        pane.getChildren().add(cardapioTXT);

        TextField trocar por caixas de selecao = new TextField("");
        trocar por caixas de selecao.setLayoutX(80.00);
        trocar por caixas de selecao.setLayoutY(219.00);
        trocar por caixas de selecao.setPrefWidth(149.00);
        trocar por caixas de selecao.setPrefHeight(24.00);
        trocar por caixas de selecao.setPromptText("trocar por selecao");
        trocar por caixas de selecao.setFont(Font.loadFont(getClass().getResourceAsStream("/resources/fonts/Lexend.ttf"), 14.00));
        trocar por caixas de selecao.setStyle("-fx-background-color: #ffffff; -fx-text-fill: #1b1b1b; -fx-border-color: #626262; -fx-border-width: 1px; -fx-border-radius: 2px; -fx-prompt-text-fill: #737674;");
        pane.getChildren().add(trocar por caixas de selecao);

        Scene scene = new Scene(pane, 899, 450);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}