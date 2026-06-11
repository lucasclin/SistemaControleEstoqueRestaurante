package sdedr.view.Cadastros;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class CadastroUnidadeView extends Application {
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("My Awesome Window");

        Pane pane = new Pane();
        pane.setPrefSize(899, 450);
        pane.setStyle("-fx-background-color: #eeeeee;");

        Label CadastrarUnidadeTXT = new Label("Cadastro de Unidade");
        CadastrarUnidadeTXT.setLayoutX(24.5625);
        CadastrarUnidadeTXT.setLayoutY(19.359375);
        CadastrarUnidadeTXT.setPrefWidth(150);
        CadastrarUnidadeTXT.setPrefHeight(19);
        CadastrarUnidadeTXT.setFont(Font.loadFont(getClass().getResourceAsStream("/resources/fonts/Lexend.ttf"), 14.00));
        CadastrarUnidadeTXT.setStyle("-fx-text-fill: #1b1b1b;");
        pane.getChildren().add(CadastrarUnidadeTXT);

        TextField nomeInput = new TextField("");
        nomeInput.setLayoutX(226.00);
        nomeInput.setLayoutY(169.00);
        nomeInput.setPrefWidth(332.00);
        nomeInput.setPrefHeight(24.00);
        nomeInput.setPromptText("Nome da nova unidade");
        nomeInput.setFont(Font.loadFont(getClass().getResourceAsStream("/resources/fonts/Lexend.ttf"), 14.00));
        nomeInput.setStyle("-fx-background-color: #ffffff; -fx-text-fill: #1b1b1b; -fx-border-color: #626262; -fx-border-width: 1px; -fx-border-radius: 2px; -fx-prompt-text-fill: #737674;");
        pane.getChildren().add(nomeInput);

        TextField element5 = new TextField();
        element5.setText("");
        element5.setLayoutX(225.00);
        element5.setLayoutY(205.00);
        element5.setPrefWidth(333.00);
        element5.setPrefHeight(24.00);
        element5.setPromptText("Observação da nova unidade");
        element5.setFont(Font.loadFont(getClass().getResourceAsStream("/resources/fonts/Lexend.ttf"), 14.00));
        element5.setStyle("-fx-background-color: #ffffff; -fx-text-fill: #1b1b1b; -fx-border-color: #626262; -fx-border-width: 1px; -fx-border-radius: 2px; -fx-prompt-text-fill: #737674;");
        pane.getChildren().add(element5);

        Label element6 = new Label("Insira as informações do cadastro");
        element6.setLayoutX(220);
        element6.setLayoutY(127.359375);
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

        Scene scene = new Scene(pane, 899, 450);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}