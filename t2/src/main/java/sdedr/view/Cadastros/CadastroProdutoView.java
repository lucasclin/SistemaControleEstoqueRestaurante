package sdedr.view.Cadastros;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class CadastroProdutoView extends Application {
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("My Awesome Window");

        Pane pane = new Pane();
        pane.setPrefSize(899, 450);
        pane.setStyle("-fx-background-color: #eeeeee;");

        Label CadastrarProdutoTXT = new Label("Cadastro de Produto");
        CadastrarProdutoTXT.setLayoutX(24.5625);
        CadastrarProdutoTXT.setLayoutY(19.359375);
        CadastrarProdutoTXT.setPrefWidth(150);
        CadastrarProdutoTXT.setPrefHeight(19);
        CadastrarProdutoTXT.setFont(Font.loadFont(getClass().getResourceAsStream("/resources/fonts/Lexend.ttf"), 14.00));
        CadastrarProdutoTXT.setStyle("-fx-text-fill: #1b1b1b;");
        pane.getChildren().add(CadastrarProdutoTXT);

        TextField nomeInput = new TextField("");
        nomeInput.setLayoutX(78.00);
        nomeInput.setLayoutY(96.00);
        nomeInput.setPrefWidth(224.00);
        nomeInput.setPrefHeight(24.00);
        nomeInput.setPromptText("Nome do novo produto");
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
        element9.setPromptText("Preço Atual do novo produto");
        element9.setFont(Font.loadFont(getClass().getResourceAsStream("/resources/fonts/Lexend.ttf"), 14.00));
        element9.setStyle("-fx-background-color: #ffffff; -fx-text-fill: #1b1b1b; -fx-border-color: #626262; -fx-border-width: 1px; -fx-border-radius: 2px; -fx-prompt-text-fill: #737674;");
        pane.getChildren().add(element9);

        TextField element10 = new TextField("");
        element10.setLayoutX(77.56);
        element10.setLayoutY(162.11);
        element10.setPrefWidth(224.00);
        element10.setPrefHeight(24.00);
        element10.setPromptText("Estoque mínimo do produto");
        element10.setFont(Font.loadFont(getClass().getResourceAsStream("/resources/fonts/Lexend.ttf"), 14.00));
        element10.setStyle("-fx-background-color: #ffffff; -fx-text-fill: #1b1b1b; -fx-border-color: #626262; -fx-border-width: 1px; -fx-border-radius: 2px; -fx-prompt-text-fill: #737674;");
        pane.getChildren().add(element10);

        Label permiteFracTXT = new Label("Permite fracionamento?");
        permiteFracTXT.setLayoutX(58);
        permiteFracTXT.setLayoutY(203.359375);
        permiteFracTXT.setPrefWidth(187);
        permiteFracTXT.setPrefHeight(21);
        permiteFracTXT.setFont(Font.loadFont(getClass().getResourceAsStream("/resources/fonts/Lexend.ttf"), 14.00));
        permiteFracTXT.setStyle("-fx-text-fill: #1b1b1b;");
        pane.getChildren().add(permiteFracTXT);

        TextField trocarporcombobox1 = new TextField("");
        trocarporcombobox1.setLayoutX(80.00);
        trocarporcombobox1.setLayoutY(226.00);
        trocarporcombobox1.setPrefWidth(149.00);
        trocarporcombobox1.setPrefHeight(24.00);
        trocarporcombobox1.setPromptText("trocar por comboBox");
        trocarporcombobox1.setFont(Font.loadFont(getClass().getResourceAsStream("/resources/fonts/Lexend.ttf"), 14.00));
        trocarporcombobox1.setStyle("-fx-background-color: #ffffff; -fx-text-fill: #1b1b1b; -fx-border-color: #626262; -fx-border-width: 1px; -fx-border-radius: 2px; -fx-prompt-text-fill: #737674;");
        pane.getChildren().add(trocarporcombobox1);

        Label UnidadeTXT = new Label("Unidade");
        UnidadeTXT.setLayoutX(58.5625);
        UnidadeTXT.setLayoutY(272.359375);
        UnidadeTXT.setPrefWidth(105.8125);
        UnidadeTXT.setPrefHeight(18);
        UnidadeTXT.setFont(Font.loadFont(getClass().getResourceAsStream("/resources/fonts/Lexend.ttf"), 14.00));
        UnidadeTXT.setStyle("-fx-text-fill: #1b1b1b;");
        pane.getChildren().add(UnidadeTXT);

        TextField trocarporcombobox2 = new TextField("");
        trocarporcombobox2.setLayoutX(81.56);
        trocarporcombobox2.setLayoutY(298.11);
        trocarporcombobox2.setPrefWidth(105.81);
        trocarporcombobox2.setPrefHeight(24.00);
        trocarporcombobox2.setPromptText("trocar por combobox");
        trocarporcombobox2.setFont(Font.loadFont(getClass().getResourceAsStream("/resources/fonts/Lexend.ttf"), 14.00));
        trocarporcombobox2.setStyle("-fx-background-color: #ffffff; -fx-text-fill: #1b1b1b; -fx-border-color: #626262; -fx-border-width: 1px; -fx-border-radius: 2px; -fx-prompt-text-fill: #737674;");
        pane.getChildren().add(trocarporcombobox2);

        Scene scene = new Scene(pane, 899, 450);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}