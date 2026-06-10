package sdedr.view;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;


public class MenuView{
    private String nomeUsuario;

    public MenuView(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public void start(Stage primaryStage) {
        primaryStage.setTitle("Sistema de Controle de Estoque Restaurante");

        Pane pane = new Pane();
        pane.setPrefSize(903, 452);
        pane.setStyle("-fx-background-color: #eeeeee;");

        Button MovimentarEstoqueButton = new Button("Adicionar ou Remover Estoque");
        MovimentarEstoqueButton.setLayoutX(56.00);
        MovimentarEstoqueButton.setLayoutY(53.00);
        MovimentarEstoqueButton.setPrefWidth(164.00);
        MovimentarEstoqueButton.setPrefHeight(47.00);
        MovimentarEstoqueButton.setDisable(false);
        MovimentarEstoqueButton.setFont(Font.loadFont(getClass().getResourceAsStream("/fonts/BlexMonoNerdFont-Regular.ttf"), 14.00));
        MovimentarEstoqueButton.setStyle("-fx-background-color: #ffffff; -fx-text-fill: #1b1b1b; -fx-border-color: #626262; -fx-border-radius: 4px; -fx-background-radius: 4px; -fx-border-width: 1px;");
        MovimentarEstoqueButton.addEventFilter(MouseEvent.MOUSE_PRESSED, e -> { MovimentarEstoqueButton.setBackground(new Background(new BackgroundFill(Color.web("#c2c2c2"), new CornerRadii(4.00), null))); });
        MovimentarEstoqueButton.addEventFilter(MouseEvent.MOUSE_RELEASED, e -> { MovimentarEstoqueButton.setBackground(new Background(new BackgroundFill(Color.web("#ffffff"), new CornerRadii(4.00), null))); });
        pane.getChildren().add(MovimentarEstoqueButton);

        Button ReceitasButton = new Button("Mostrar Receitas");
        ReceitasButton.setLayoutX(55.00);
        ReceitasButton.setLayoutY(111.00);
        ReceitasButton.setPrefWidth(164.00);
        ReceitasButton.setPrefHeight(47.00);
        ReceitasButton.setDisable(false);
        ReceitasButton.setFont(Font.loadFont(getClass().getResourceAsStream("/fonts/BlexMonoNerdFont-Regular.ttf"), 14.00));
        ReceitasButton.setStyle("-fx-background-color: #ffffff; -fx-text-fill: #1b1b1b; -fx-border-color: #626262; -fx-border-radius: 4px; -fx-background-radius: 4px; -fx-border-width: 1px;");
        ReceitasButton.addEventFilter(MouseEvent.MOUSE_PRESSED, e -> { ReceitasButton.setBackground(new Background(new BackgroundFill(Color.web("#c2c2c2"), new CornerRadii(4.00), null))); });
        ReceitasButton.addEventFilter(MouseEvent.MOUSE_RELEASED, e -> { ReceitasButton.setBackground(new Background(new BackgroundFill(Color.web("#ffffff"), new CornerRadii(4.00), null))); });
        pane.getChildren().add(ReceitasButton);

        Button InventarioButton = new Button("Gerar Inventário");
        InventarioButton.setLayoutX(54.44);
        InventarioButton.setLayoutY(166.05);
        InventarioButton.setPrefWidth(164.00);
        InventarioButton.setPrefHeight(47.00);
        InventarioButton.setDisable(false);
        InventarioButton.setFont(Font.loadFont(getClass().getResourceAsStream("/fonts/BlexMonoNerdFont-Regular.ttf"), 14.00));
        InventarioButton.setStyle("-fx-background-color: #ffffff; -fx-text-fill: #1b1b1b; -fx-border-color: #626262; -fx-border-radius: 4px; -fx-background-radius: 4px; -fx-border-width: 1px;");
        InventarioButton.addEventFilter(MouseEvent.MOUSE_PRESSED, e -> { InventarioButton.setBackground(new Background(new BackgroundFill(Color.web("#c2c2c2"), new CornerRadii(4.00), null))); });
        InventarioButton.addEventFilter(MouseEvent.MOUSE_RELEASED, e -> { InventarioButton.setBackground(new Background(new BackgroundFill(Color.web("#ffffff"), new CornerRadii(4.00), null))); });
        pane.getChildren().add(InventarioButton);

        Button RelatorioButton = new Button("Gerar Relatório");
        RelatorioButton.setLayoutX(53.00);
        RelatorioButton.setLayoutY(219.00);
        RelatorioButton.setPrefWidth(164.00);
        RelatorioButton.setPrefHeight(47.00);
        RelatorioButton.setDisable(false);
        RelatorioButton.setFont(Font.loadFont(getClass().getResourceAsStream("/fonts/BlexMonoNerdFont-Regular.ttf"), 14.00));
        RelatorioButton.setStyle("-fx-background-color: #ffffff; -fx-text-fill: #1b1b1b; -fx-border-color: #626262; -fx-border-radius: 4px; -fx-background-radius: 4px; -fx-border-width: 1px;");
        RelatorioButton.addEventFilter(MouseEvent.MOUSE_PRESSED, e -> { RelatorioButton.setBackground(new Background(new BackgroundFill(Color.web("#c2c2c2"), new CornerRadii(4.00), null))); });
        RelatorioButton.addEventFilter(MouseEvent.MOUSE_RELEASED, e -> { RelatorioButton.setBackground(new Background(new BackgroundFill(Color.web("#ffffff"), new CornerRadii(4.00), null))); });
        pane.getChildren().add(RelatorioButton);

        Button CardapiosButton = new Button("Mostrar Cardápios");
        CardapiosButton.setLayoutX(54.44);
        CardapiosButton.setLayoutY(274.05);
        CardapiosButton.setPrefWidth(164.00);
        CardapiosButton.setPrefHeight(47.00);
        CardapiosButton.setDisable(false);
        CardapiosButton.setFont(Font.loadFont(getClass().getResourceAsStream("/fonts/BlexMonoNerdFont-Regular.ttf"), 14.00));
        CardapiosButton.setStyle("-fx-background-color: #ffffff; -fx-text-fill: #1b1b1b; -fx-border-color: #626262; -fx-border-radius: 4px; -fx-background-radius: 4px; -fx-border-width: 1px;");
        CardapiosButton.addEventFilter(MouseEvent.MOUSE_PRESSED, e -> { CardapiosButton.setBackground(new Background(new BackgroundFill(Color.web("#c2c2c2"), new CornerRadii(4.00), null))); });
        CardapiosButton.addEventFilter(MouseEvent.MOUSE_RELEASED, e -> { CardapiosButton.setBackground(new Background(new BackgroundFill(Color.web("#ffffff"), new CornerRadii(4.00), null))); });
        pane.getChildren().add(CardapiosButton);

        TextArea AreaTexto = new TextArea("");
        AreaTexto.setLayoutX(257.00);
        AreaTexto.setLayoutY(55.00);
        AreaTexto.setPrefWidth(605.00);
        AreaTexto.setPrefHeight(363.00);
        AreaTexto.setPromptText("");
        AreaTexto.setFont(Font.loadFont(getClass().getResourceAsStream("/fonts/BlexMonoNerdFont-Regular.ttf"), 14.00));
        AreaTexto.setStyle("-fx-control-inner-background: #ffffff; -fx-background-color: #ffffff; -fx-text-fill: #1b1b1b; -fx-border-color: #626262; -fx-border-width: 1px; -fx-border-radius: 2px; -fx-prompt-text-fill: #737674;");
        pane.getChildren().add(AreaTexto);

        Label element7 = new Label("Olá, " + nomeUsuario);
        element7.setLayoutX(57.4375);
        element7.setLayoutY(15.796875);
        element7.setPrefWidth(105.8125);
        element7.setPrefHeight(18);
        element7.setFont(Font.loadFont(getClass().getResourceAsStream("/fonts/BlexMonoNerdFont-Regular.ttf"), 14.00));
        element7.setStyle("-fx-text-fill: #1b1b1b;");
        pane.getChildren().add(element7);

        Scene scene = new Scene(pane, 903, 452);
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}

