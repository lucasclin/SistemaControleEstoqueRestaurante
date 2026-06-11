package sdedr.view;

import sdedr.App;
/* Mudar depois, mas como não terminei não sei o escopo disso ainda... */
import sdedr.model.*;
import sdedr.model.Enum.*;
import sdedr.ctrl.*;

import java.math.BigDecimal;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.beans.property.SimpleStringProperty;

public class ManterGeralView extends GridPane{

  public ManterGeralView(App loop, int tipo, CtrlCtrl aux) {
    TableView<Produto> produtoTableView = null;
    TableView<Receita> receitaTableView = null;
    Text tituloText = null;
    /* definições das margens da Grid */
    this.setAlignment(Pos.CENTER);
    this.setHgap(10);
    this.setVgap(10);
    this.setPadding(new Insets(25, 25, 25, 25));
    /* dependendo do tipo, criar tabela do tipo em (0,0) */
    switch (tipo) {
      case 1:
        /* tabela de produto */    
        tituloText = new Text("Produtos:");
        this.add(tituloText, 0, 0, 2, 1);
        ProdutoCtrl produtoCtrl = new ProdutoCtrl();
        produtoTableView = (TableView<Produto>) switchTabela(tipo);
        if (produtoCtrl.prepararProdutos()) {
          produtoTableView.getItems().addAll(produtoCtrl.getProdutos());
        }
        this.add(produtoTableView, 0, 1);
        break;
      case 2:
        /* tabela de receita */
        tituloText = new Text("Receitas:");
        this.add(tituloText, 0, 0, 2, 1);
        ReceitaCtrl receitaCtrl = new ReceitaCtrl();
        receitaTableView = (TableView<Receita>) switchTabela(tipo);
        if (receitaCtrl.prepararReceitas()) {
          receitaTableView.getItems().addAll(receitaCtrl.getReceitas());
        }
        this.add(receitaTableView, 0, 1);
        break;
      default:
        /* deu ruim! */
        break;
    }

    /* Adiciona o botão (0, 1) */
    Button sairButton = new Button("Sair");
    HBox sairHBox = new HBox(sairButton);
    sairHBox.setAlignment(Pos.BOTTOM_RIGHT);
    this.add(sairHBox, 0, 2);
    /* Ao ser selecionado ativa tela de login no App*/
    sairButton.setOnAction(event -> {
      loop.vezMenuTmpView(aux);
    });
  }

  /* Aqui começa a diversão! 
   * 1. Produto + Unidade
   *  a. Ver produto é estoque
   * 2. Estoque --> Movimentacao
   * 3. Receita + Cardapio
   *  a. Ver receita + ingrediente? Talvez em outro lugar... */

  /* INCOMPLETO TERMINAR !!! */
  public static TableView<?> switchTabela (int tipo) {
    switch (tipo) {
      case 1:
        return tabelaProdutoUnidade();
      case 2:
        return tabelaReceita();
      default:
        return null;
    }
  }

  /* obs. para mais informação veja:
   * https://fxdocs.github.io/docs/html5/#_tableview  */
  private static TableView<Produto> tabelaProdutoUnidade() {
    /* Criar a tabela de produto */
    TableView<Produto> produtoTableView = new TableView<>();
    produtoTableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

    /* Cria as colunas, ...<Classe, Tipo de atributo> ... ("nome da coluna") */
    TableColumn<Produto, Long> idColuna = new TableColumn<>("id");
    TableColumn<Produto, String> nomeColuna = new TableColumn<>("nome");
    TableColumn<Produto, BigDecimal> precoAtualColuna = new TableColumn<>("preço");
    TableColumn<Produto, BigDecimal> quantidadeEstoqueColuna = new TableColumn<>("quant.");
    TableColumn<Produto, BigDecimal> estoqueMinimoColuna = new TableColumn<>("min.");
    TableColumn<Produto, Boolean> permiteFracionamentoColuna = new TableColumn<>("fracionar");
    TableColumn<Produto, Boolean> isAtivoColuna = new TableColumn<>("ativo");

    /* Aqui será mais complicado, porque o atributo é outra classe. */
    TableColumn<Produto, String> unidadeColuna = new TableColumn<>("unidade");

    /* set na coluna o atributo (nome do atributo na classe) */
    idColuna.setCellValueFactory(new PropertyValueFactory<>("id"));
    nomeColuna.setCellValueFactory(new PropertyValueFactory<>("nome"));
    precoAtualColuna.setCellValueFactory(new PropertyValueFactory<>("precoAtual"));
    quantidadeEstoqueColuna.setCellValueFactory(new PropertyValueFactory<>("quantidadeEstoque"));
    estoqueMinimoColuna.setCellValueFactory(new PropertyValueFactory<>("estoqueMinimo"));
    permiteFracionamentoColuna.setCellValueFactory(new PropertyValueFactory<>("permiteFracionamento"));
    isAtivoColuna.setCellValueFactory(new PropertyValueFactory<>("ativo"));

    /* A complicação de o atributo ser uma classe, a solução?
     * Pegamos o valor do atributo da classe "atributada" e transformamos em uma String! 
     * [link interessante]:
     * https://stackoverflow.com/questions/38049734/java-setcellvaluefactory-lambda-vs-propertyvaluefactory-advantages-disadvant */
    unidadeColuna.setCellValueFactory(cellData -> {
      Produto produto = cellData.getValue();
      if (produto != null && produto.getUnidade() != null) {
        return new SimpleStringProperty(produto.getUnidade().getNome());
      } else {
        return new SimpleStringProperty("");
      }
    });

    produtoTableView.getColumns().addAll(idColuna, nomeColuna, precoAtualColuna, quantidadeEstoqueColuna, 
        estoqueMinimoColuna, permiteFracionamentoColuna, isAtivoColuna, unidadeColuna);

    return produtoTableView;
  }  

  /* Tabela só para Receita */
  private static TableView<Receita> tabelaReceita() {
    /* Criar a tabela de receita */
    TableView<Receita> receitaTableView = new TableView<>();
    receitaTableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

    /* Cria as colunas, ...<Classe, Tipo de atributo> ... ("nome da coluna") */
    TableColumn<Receita, Long> idColuna = new TableColumn<>("id");
    TableColumn<Receita, String> nomeColuna = new TableColumn<>("nome");
    TableColumn<Receita, BigDecimal> precoColuna = new TableColumn<>("preço");
    TableColumn<Receita, Cardapio> cardapioColuna = new TableColumn<>("cardápio");

    /* set na coluna o atributo (nome do atributo na classe) */
    idColuna.setCellValueFactory(new PropertyValueFactory<>("id"));
    nomeColuna.setCellValueFactory(new PropertyValueFactory<>("nome"));
    precoColuna.setCellValueFactory(new PropertyValueFactory<>("preco"));
    cardapioColuna.setCellValueFactory(new PropertyValueFactory<>("cardapio"));

    receitaTableView.getColumns().addAll(idColuna, nomeColuna, precoColuna, cardapioColuna);

    return receitaTableView;
  }
}
