package sdedr.view;

import java.util.ArrayList;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import sdedr.ctrl.IngredienteCtrl;
import sdedr.ctrl.MovimentacaoCtrl;
import sdedr.ctrl.ProdutoCtrl;
import sdedr.ctrl.ReceitaCtrl;
import sdedr.model.Ingrediente;
import sdedr.model.MovimentacaoEstoqueDeProduto;
import sdedr.model.Produto;
import sdedr.model.User;
import sdedr.model.Enum.TipoCadastro;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;


public class MenuView{
    private String nomeUsuario;
    private User user;

    public MenuView(String nomeUsuario, User user) {
        this.nomeUsuario = nomeUsuario;
        this.user = user;
    }

    public void start(Stage primaryStage) {
        primaryStage.setTitle("Sistema de Controle de Estoque Restaurante");

        Pane pane = new Pane();
        pane.setPrefSize(903, 452);
        pane.setStyle("-fx-background-color: #eeeeee;");

        Button MovimentarEstoqueButton = new Button("Movimentar Estoque");
        MovimentarEstoqueButton.setLayoutX(55.00);
        MovimentarEstoqueButton.setLayoutY(53.00);
        MovimentarEstoqueButton.setPrefWidth(164.00);
        MovimentarEstoqueButton.setPrefHeight(47.00);
        MovimentarEstoqueButton.setDisable(false);
        MovimentarEstoqueButton.setFont(Font.loadFont(getClass().getResourceAsStream("/fonts/BlexMonoNerdFont-Regular.ttf"), 13.00));
        MovimentarEstoqueButton.setStyle("-fx-background-color: #ffffff; -fx-text-fill: #1b1b1b; -fx-border-color: #626262; -fx-border-radius: 4px; -fx-background-radius: 4px; -fx-border-width: 1px;");
        MovimentarEstoqueButton.addEventFilter(MouseEvent.MOUSE_PRESSED, e -> { MovimentarEstoqueButton.setBackground(new Background(new BackgroundFill(Color.web("#c2c2c2"), new CornerRadii(4.00), null))); });
        MovimentarEstoqueButton.addEventFilter(MouseEvent.MOUSE_RELEASED, e -> { MovimentarEstoqueButton.setBackground(new Background(new BackgroundFill(Color.web("#ffffff"), new CornerRadii(4.00), null))); });
        pane.getChildren().add(MovimentarEstoqueButton);

        Button ReceitasButton = new Button("Mostrar Receitas");
        ReceitasButton.setLayoutX(55.00);
        ReceitasButton.setLayoutY(110.00);
        ReceitasButton.setPrefWidth(164.00);
        ReceitasButton.setPrefHeight(47.00);
        ReceitasButton.setDisable(false);
        ReceitasButton.setFont(Font.loadFont(getClass().getResourceAsStream("/fonts/BlexMonoNerdFont-Regular.ttf"), 13.00));
        ReceitasButton.setStyle("-fx-background-color: #ffffff; -fx-text-fill: #1b1b1b; -fx-border-color: #626262; -fx-border-radius: 4px; -fx-background-radius: 4px; -fx-border-width: 1px;");
        ReceitasButton.addEventFilter(MouseEvent.MOUSE_PRESSED, e -> { ReceitasButton.setBackground(new Background(new BackgroundFill(Color.web("#c2c2c2"), new CornerRadii(4.00), null))); });
        ReceitasButton.addEventFilter(MouseEvent.MOUSE_RELEASED, e -> { ReceitasButton.setBackground(new Background(new BackgroundFill(Color.web("#ffffff"), new CornerRadii(4.00), null))); });
        pane.getChildren().add(ReceitasButton);

        Button InventarioButton = new Button("Gerar Inventário");
        InventarioButton.setLayoutX(55.00);
        InventarioButton.setLayoutY(167.00);
        InventarioButton.setPrefWidth(164.00);
        InventarioButton.setPrefHeight(47.00);
        InventarioButton.setDisable(false);
        InventarioButton.setFont(Font.loadFont(getClass().getResourceAsStream("/fonts/BlexMonoNerdFont-Regular.ttf"), 13.00));
        InventarioButton.setStyle("-fx-background-color: #ffffff; -fx-text-fill: #1b1b1b; -fx-border-color: #626262; -fx-border-radius: 4px; -fx-background-radius: 4px; -fx-border-width: 1px;");
        InventarioButton.addEventFilter(MouseEvent.MOUSE_PRESSED, e -> { InventarioButton.setBackground(new Background(new BackgroundFill(Color.web("#c2c2c2"), new CornerRadii(4.00), null))); });
        InventarioButton.addEventFilter(MouseEvent.MOUSE_RELEASED, e -> { InventarioButton.setBackground(new Background(new BackgroundFill(Color.web("#ffffff"), new CornerRadii(4.00), null))); });
        pane.getChildren().add(InventarioButton);

        Button RelatorioButton = new Button("Gerar Relatório");
        RelatorioButton.setLayoutX(55.00);
        RelatorioButton.setLayoutY(224.00);
        RelatorioButton.setPrefWidth(164.00);
        RelatorioButton.setPrefHeight(47.00);
        RelatorioButton.setDisable(false);
        RelatorioButton.setFont(Font.loadFont(getClass().getResourceAsStream("/fonts/BlexMonoNerdFont-Regular.ttf"), 13.00));
        RelatorioButton.setStyle("-fx-background-color: #ffffff; -fx-text-fill: #1b1b1b; -fx-border-color: #626262; -fx-border-radius: 4px; -fx-background-radius: 4px; -fx-border-width: 1px;");
        RelatorioButton.addEventFilter(MouseEvent.MOUSE_PRESSED, e -> { RelatorioButton.setBackground(new Background(new BackgroundFill(Color.web("#c2c2c2"), new CornerRadii(4.00), null))); });
        RelatorioButton.addEventFilter(MouseEvent.MOUSE_RELEASED, e -> { RelatorioButton.setBackground(new Background(new BackgroundFill(Color.web("#ffffff"), new CornerRadii(4.00), null))); });
        pane.getChildren().add(RelatorioButton);

        Button CardapiosButton = new Button("Mostrar Cardápios");
        CardapiosButton.setLayoutX(55.00);
        CardapiosButton.setLayoutY(281.00);
        CardapiosButton.setPrefWidth(164.00);
        CardapiosButton.setPrefHeight(47.00);
        CardapiosButton.setDisable(false);
        CardapiosButton.setFont(Font.loadFont(getClass().getResourceAsStream("/fonts/BlexMonoNerdFont-Regular.ttf"), 13.00));
        CardapiosButton.setStyle("-fx-background-color: #ffffff; -fx-text-fill: #1b1b1b; -fx-border-color: #626262; -fx-border-radius: 4px; -fx-background-radius: 4px; -fx-border-width: 1px;");
        CardapiosButton.addEventFilter(MouseEvent.MOUSE_PRESSED, e -> { CardapiosButton.setBackground(new Background(new BackgroundFill(Color.web("#c2c2c2"), new CornerRadii(4.00), null))); });
        CardapiosButton.addEventFilter(MouseEvent.MOUSE_RELEASED, e -> { CardapiosButton.setBackground(new Background(new BackgroundFill(Color.web("#ffffff"), new CornerRadii(4.00), null))); });
        pane.getChildren().add(CardapiosButton);

        Button CadastrosButton = new Button("Cadastros");
        CadastrosButton.setLayoutX(55.00);
        CadastrosButton.setLayoutY(338.00);
        CadastrosButton.setPrefWidth(164.00);
        CadastrosButton.setPrefHeight(47.00);
        CadastrosButton.setDisable(false);
        CadastrosButton.setFont(Font.loadFont(getClass().getResourceAsStream("/fonts/BlexMonoNerdFont-Regular.ttf"), 13.00));
        CadastrosButton.setStyle("-fx-background-color: #ffffff; -fx-text-fill: #1b1b1b; -fx-border-color: #626262; -fx-border-radius: 4px; -fx-background-radius: 4px; -fx-border-width: 1px;");
        CadastrosButton.addEventFilter(MouseEvent.MOUSE_PRESSED, e -> { CadastrosButton.setBackground(new Background(new BackgroundFill(Color.web("#c2c2c2"), new CornerRadii(4.00), null))); });
        CadastrosButton.addEventFilter(MouseEvent.MOUSE_RELEASED, e -> { CadastrosButton.setBackground(new Background(new BackgroundFill(Color.web("#ffffff"), new CornerRadii(4.00), null))); });
        pane.getChildren().add(CadastrosButton);

        TextArea AreaTexto = new TextArea("");
        AreaTexto.setEditable(false);
        AreaTexto.setLayoutX(257.00);
        AreaTexto.setLayoutY(55.00);
        AreaTexto.setPrefWidth(605.00);
        AreaTexto.setPrefHeight(363.00);
        AreaTexto.setPromptText("");
        AreaTexto.setFont(Font.loadFont(getClass().getResourceAsStream("/fonts/BlexMonoNerdFont-Regular.ttf"), 13.00));
        AreaTexto.setStyle("-fx-control-inner-background: #ffffff; -fx-background-color: #ffffff; -fx-text-fill: #1b1b1b; -fx-border-color: #626262; -fx-border-width: 1px; -fx-border-radius: 2px; -fx-prompt-text-fill: #737674;");
        pane.getChildren().add(AreaTexto);

        Label element7 = new Label("Olá, " + nomeUsuario);
        element7.setLayoutX(57.4375);
        element7.setLayoutY(15.796875);
        element7.setPrefWidth(105.8125);
        element7.setPrefHeight(18);
        element7.setFont(Font.loadFont(getClass().getResourceAsStream("/fonts/BlexMonoNerdFont-Regular.ttf"), 13.00));
        element7.setStyle("-fx-text-fill: #1b1b1b;");
        pane.getChildren().add(element7);

        Scene scene = new Scene(pane, 903, 452);
        primaryStage.setScene(scene);

        primaryStage.setResizable(true);

        primaryStage.widthProperty().addListener((obs, velho, novo) -> {
            AreaTexto.setPrefWidth(novo.doubleValue() - 298);
        });

        primaryStage.heightProperty().addListener((obs, velho, novo) -> {
            AreaTexto.setPrefHeight(novo.doubleValue() - 120);
        });

        // Garante que ela já comece com o tamanho correto se a janela abrir maior
        AreaTexto.setPrefWidth(primaryStage.getWidth() - 298);
        AreaTexto.setPrefHeight(primaryStage.getHeight() - 120);

        primaryStage.show();

        InventarioButton.setOnAction(event -> {
            AreaTexto.setText("--- INVENTÁRIO DO ESTOQUE ---\n\n");
            ProdutoCtrl produtoCtrl = new ProdutoCtrl();
            ArrayList<Produto> listaProdutos = produtoCtrl.getInventario();

            for (Produto p : listaProdutos) {
                String linha;

                if (p.isPermiteFracionamento()) {
                    if (p.getUnidade() != null) {
                        linha = "Codigo: " + p.getId() + " | Produto: " + p.getNome() + " | Qtd: " + p.getQuantidadeEstoque() + " " + p.getUnidade().getNome() + " (Fracionável)" + "\n";
                    } else {
                        linha = "Codigo: " + p.getId() + " | Produto: " + p.getNome() + " | Qtd: " + p.getQuantidadeEstoque() + " (Fracionável)" + "\n";
                    }

                } else {
                    linha = "Codigo: " + p.getId() + " | Produto: " + p.getNome() + " | Qtd: " + p.getQuantidadeEstoque() + "\n";
                }
                AreaTexto.appendText(linha);
            }
        });

        RelatorioButton.setOnAction(event -> {
            if (user.getTipoCadastro() == TipoCadastro.ADMIN || user.getTipoCadastro() == TipoCadastro.ALMOXARIFADO) {
                AreaTexto.setText("--- RELATÓRIO DE MOVIMENTAÇÕES ---\n\n");

                MovimentacaoCtrl movimentacaoCtrl = new MovimentacaoCtrl();
                ArrayList<MovimentacaoEstoqueDeProduto> listaMovimentacoes = movimentacaoCtrl.getRelatorio();

                for (MovimentacaoEstoqueDeProduto m : listaMovimentacoes) {
                    String linha;
                    if (m.getProduto().getUnidade() != null) {
                        linha = "Codigo: " + m.getId() + " | Produto: " + m.getProduto().getNome() + " | Tipo: " + m.getTipoMovimentacao() + " | Qtd: " + m.getQuantidade() + " " + m.getProduto().getUnidade().getNome() + " | Usuario: " + m.getUserName() + " | Data: " + m.getDataHora() + " | Valor unitário (R$): " + m.getPrecoUnitario() + " | Valor Total (R$): " + m.getPrecoTotal() + "\n";  
                    }
                    else{
                        linha = "Codigo: " + m.getId() + " | Produto: " + m.getProduto().getNome() + " | Tipo: " + m.getTipoMovimentacao() + " | Qtd: " + m.getQuantidade() + " | Usuario: " + m.getUserName() + " | Data: " + m.getDataHora() + " | Valor unitário (R$): " + m.getPrecoUnitario() + " | Valor Total (R$): " + m.getPrecoTotal() + "\n";
                    }
                    AreaTexto.appendText(linha);
                }
            }
            else {
                AreaTexto.setText("Acesso negado. Você não tem permissão para acessar o relatório.");
            }
        });
        

        CardapiosButton.setOnAction(event -> {
            if (user.getTipoCadastro() == TipoCadastro.ADMIN || user.getTipoCadastro() == TipoCadastro.CHEF){
                CardapioView cardapioView = new CardapioView();
                cardapioView.start(new Stage());
            } else {
                AreaTexto.setText("Acesso negado. Você não tem permissão para acessar aos cardápios.");
            }
        });

        ReceitasButton.setOnAction(event -> {
            if(user.getTipoCadastro() == TipoCadastro.ADMIN || user.getTipoCadastro() == TipoCadastro.CHEF) {
                AreaTexto.setText("--- RECEITAS CADASTRADAS ---\n\n");
                ReceitaCtrl receitaCtrl = new ReceitaCtrl();
                receitaCtrl.prepararReceitas();
                ArrayList<sdedr.model.Receita> listaReceitas = receitaCtrl.getReceitas();

                for (sdedr.model.Receita r : listaReceitas) {
                    String linha = "Codigo: " + r.getId() + " | Receita: " + r.getNome() + " | Preço: R$ " + r.getPreco() + "\n";
                    AreaTexto.appendText(linha);

                    ArrayList<Ingrediente> ingredientes = new ArrayList<>();
                    IngredienteCtrl ingredienteCtrl = new IngredienteCtrl();
                    ingredienteCtrl.retornarIngredientesReceita(r, ingredientes);

                    if (ingredientes.isEmpty() || ingredientes == null) {
                        AreaTexto.appendText("  (Sem ingredientes cadastrados)\n");
                    } else {
                        

                        AreaTexto.appendText("  Ingredientes:\n");
                    }
                    for (Ingrediente i : ingredientes) {
                        String linhaIngrediente;
                        // Verifica se o produto tem unidade antes de tentar pegar o nome dela
                        if (i.getProduto().getUnidade() != null) {
                            linhaIngrediente = "    - " + i.getProduto().getNome() + ": " + i.getQuantidadeProduto() + " " + i.getProduto().getUnidade().getNome() + "\n";
                        } else {
                            linhaIngrediente = "    - " + i.getProduto().getNome() + ": " + i.getQuantidadeProduto() + "\n";
                        }
                        AreaTexto.appendText(linhaIngrediente);
                    }
                }
            }
            else {
                AreaTexto.setText("Acesso negado. Você não tem permissão para acessar as receitas.");
            }
        });

        CadastrosButton.setOnAction(event -> {
            if (user.getTipoCadastro() == TipoCadastro.ADMIN){
                CadastrosView cadastrosView = new CadastrosView();
                cadastrosView.start(new Stage());
            }
            else{
                AreaTexto.setText("Acesso negado. Você não tem permissão para acessar o menu de cadastros.");
            }
        });
        
    }
}


