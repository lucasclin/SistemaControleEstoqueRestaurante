// package sdedr.view;
//
// import sdedr.App;
// /* Mudar depois, mas como não terminei não sei o escopo disso ainda... */
// import sdedr.model.*;
// import sdedr.ctrl.*;
//
// import java.math.BigDecimal;
// import java.util.Objects;
//
// import javafx.geometry.Insets;
// import javafx.geometry.Pos;
// import javafx.scene.control.*;
// import javafx.scene.layout.GridPane;
// import javafx.scene.layout.TableView;
// import javafx.scene.layout.HBox;
// import javafx.scene.text.Font;
// import javafx.scene.text.FontWeight;
// import javafx.scene.text.Text;
// import javafx.event.ActionEvent;
// import javafx.event.EventHandler;
//
// public class ManterGeralView extends GridPane{
//   public ManterGeralView(App loop, int tipo) {
//
//     ProdutoCtrl produtoCtrl = null;
//     TableView<Produto> produtoTableView = null;
//
//     ReceitaCtrl receitaCtrl = null;
//     TableView<Receita> receitaTableView = null;
//
//     switch (tipo) {
//       case 1:
//         produtoCtrl = new ProdutoCtrl();
//         produtoTableView = switchTabela(tipo);        
//         break;
//       case 2:
//         receitaCtrl = new ReceitaCtrl();
//         receitaTableView = switchTabela(tipo);
//         if (receitaCtrl.prepararReceitas()) {
//           receitaTableView.getItems().addAll(receitaCtrl.getReceitas());
//         }
//         break;
//       default:
//         break;
//     }
//
//         Button btnInventory = new Button("Inventory");
//         Button btnCalcTax = new Button("Tax");
//
//         btnInventory.disableProperty().bind(
//             tblItems.getSelectionModel().selectedItemProperty().isNull()
//         );
//
//         btnCalcTax.disableProperty().bind(
//             tblItems.getSelectionModel().selectedItemProperty().isNull().or(
//                     Bindings.select(
//                         tblItems.getSelectionModel().selectedItemProperty(),
//                         "taxable"
//                     ).isEqualTo(false)
//             )
//         );
//
//         HBox buttonHBox = new HBox( btnInventory, btnCalcTax );
//         buttonHBox.setSpacing( 8 );
//
//         VBox vbox = new VBox( tblItems, buttonHBox );
//         vbox.setPadding( new Insets(10) );
//         vbox.setSpacing( 10 );
//
//         Scene scene = new Scene(vbox);
//
//         primaryStage.setTitle("TableSelectApp");
//         primaryStage.setScene( scene );
//         primaryStage.setHeight( 376 );
//         primaryStage.setWidth( 667 );
//         primaryStage.show();
//   }
//
//   /* Aqui começa a diversão! 
//    * 1. Produto + Unidade
//    *  a. Ver produto é estoque
//    * 2. Estoque --> Movimentacao
//    * 3. Receita + Cardapio
//    *  a. Ver receita + ingrediente? Talvez em outro lugar... */
//
//   /* INCOMPLETO TERMINAR !!! */
//   public static TableView<?> switchTabela (int tipo) {
//     switch (tipo) {
//       case 1:
//         return tabelaProdutoUnidade();
//       case 2:
//         return tabelaReceita();
//       default:
//         return null;
//     }
//   }
//
//   /* obs. para mais informação veja:
//    * https://fxdocs.github.io/docs/html5/#_tableview  */
//   private static TableView<Produto> tabelaProdutoUnidade() {
//     /* Criar a tabela de produto */
//     TableView<Produto> produtoTableView = new TableView<>();
//     produtoTableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
//
//     /* Cria as colunas, ...<Classe, Tipo de atributo> ... ("nome da coluna") */
//     TableColumn<Produto, Long> idColuna = new TableColumn<>("id");
//     TableColumn<Produto, String> nomeColuna = new TableColumn<>("nome");
//     TableColumn<Produto, BigDecimal> precoAtualColuna = new TableColumn<>("preço");
//     TableColumn<Produto, BigDecimal> quantidadeEstoqueColuna = new TableColumn<>("quant.");
//     TableColumn<Produto, BigDecimal> estoqueMinimoColuna = new TableColumn<>("min.");
//     TableColumn<Produto, Boolean> permiteFracionamentoColuna = new TableColumn<>("fracionar");
//     TableColumn<Produto, Boolean> isAtivoColuna = new TableColumn<>("ativo");
//
//     /* Aqui será mais complicado, porque o atributo é outra classe. */
//     TableColumn<Produto, String> unidadeColuna = new TableColumn<>("unidade");
//
//     /* set na coluna o atributo (nome do atributo na classe) */
//     idColuna.setCellValueFactory(new PropertyValueFactory<>("id"));
//     nomeColuna.setCellValueFactory(new PropertyValueFactory<>("nome"));
//     precoAtualColuna.setCellValueFactory(new PropertyValueFactory<>("precoAtual"));
//     quantidadeEstoqueColuna.setCellValueFactory(new PropertyValueFactory<>("estoqueMinimo"));
//     permiteFracionamentoColuna.setCellValueFactory(new PropertyValueFactory<>("permiteFracionamento"));
//     isAtivoColuna.setCellValueFactory(new PropertyValueFactory<>("ativo"));
//
//     /* A complicação de o atributo ser uma classe, a solução?
//      * Pegamos o valor do atributo da classe "atributada" e transformamos em uma String! 
//      *
//      * link interessante:
//      * https://stackoverflow.com/questions/38049734/java-setcellvaluefactory-lambda-vs-propertyvaluefactory-advantages-disadvant */
//     unidadeColuna.setCellValueFactory(cellData -> {
//       Produto produto = cellData.getValue();
//       if (produto != null && produto.getUnidade() != null) {
//         return new SimpleStringProperty(produto.getUnidade().getNome());
//       } else {
//         return new SimpleStringProperty("");
//       }
//     });
//
//     produtoTableView.getColumns().addAll(idColuna, nomeColuna, precoAtualColuna, quantidadeEstoqueColuna, estoqueMinimoColuna, permiteFracionamentoColuna, isAtivoColuna, unidadeColuna);
//
//     return produtoTableView;
//   }  
//
//   /* Tabela só para Receita */
//   private static TableView<Receita> tabelaReceita() {
//     /* Criar a tabela de receita */
//     TableView<Receita> receitaTableView = new TableView<>();
//     receitaTableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
//
//     /* Cria as colunas, ...<Classe, Tipo de atributo> ... ("nome da coluna") */
//     TableColumn<Receita, Long> idColuna = new TableColumn<>("id");
//     TableColumn<Receita, String> nomeColuna = new TableColumn<>("nome");
//     TableColumn<Receita, BigDecimal> precoColuna = new TableColumn<>("preço");
//     TableColumn<Receita, Cardapio> cardapioColuna = new TableColumn<>("cardápio");
//
//     /* set na coluna o atributo (nome do atributo na classe) */
//     idColuna.setCellValueFactory(new PropertyValueFactory<>("id"));
//     nomeColuna.setCellValueFactory(new PropertyValueFactory<>("nome"));
//     precoAtualColuna.setCellValueFactory(new PropertyValueFactory<>("preco"));
//     cardapioColuna.setCellValueFactory(new PropertyValueFactory<>("cardapio"));
//
//     receitaTableView.getColumns().addAll(idColuna, nomeColuna, precoColuna, cardapioColuna);
//
//     return receitaTableView;
//   }
// }
