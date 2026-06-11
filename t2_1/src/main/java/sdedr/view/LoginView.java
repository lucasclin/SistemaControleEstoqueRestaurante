package sdedr.view;

import sdedr.App;
import sdedr.ctrl.CtrlCtrl;
import sdedr.view.DefineView;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

/* Class LoginView
 * (obj.)
 * > Verificar conexão db   [?]
 * > Input para Usuário     [ok!]
 * > Input para Senha       [ok!]
 * > Comunicar com UserCtrl [?]
 * > Criar primeiro Admin   [?]
 */ 

public class LoginView extends GridPane {

  public LoginView(App loop) {
    CtrlCtrl ctrlCtrl = new CtrlCtrl();
    /* Config do GridPane, para mais veja:
     * https://fxdocs.github.io/docs/html5/#_gridpane
     * P.S. seção 4.5 */ 
    this.setAlignment(Pos.CENTER);
    this.setHgap(10);
    this.setVgap(10);
    this.setPadding(new Insets(25, 25, 25, 25));

    /* Titulo - talvez colocar uma img?*/
    /* Adiciona no grid: texto, posição (0,0), com coluna (y) ocupando 2 e linha (x) 1 */
    Text tituloText = new Text("SDEDR - Olá, faça login:");
    this.add(tituloText, 0, 0, 2, 1);

    /* Adiciona no grid: texto, posição (0,1) */
    Label usuarioLabel = new Label("Usuário:");
    this.add(usuarioLabel, 0, 1);

    /* Adiciona no grid: espaço para escrever, posição (1,1) */
    TextField usuarioTextField = new TextField();
    this.add(usuarioTextField, 1, 1);

    /* Adiciona no grid: texto, posição (0,2) */
    Label senhaLabel = new Label("Senha:");
    this.add(senhaLabel, 0, 2);

    /* Adiciona no grid: espaço para escrever SÓ que agora secreto, posição (1,2) */
    PasswordField senhaPasswordField = new PasswordField();
    this.add(senhaPasswordField, 1, 2);

    if (ctrlCtrl.userCtrl.primeiroUso()) {
      /* Adiciona no grid: botão dentro de uma grupo, posição (1,4) */
      Button logarButton = new Button("Logar");
      logarButton.setStyle(DefineView.estiloBotao);
      logarButton.setOnMousePressed(e -> logarButton.setStyle(DefineView.estiloBotaoAtivo));
      logarButton.setOnMouseReleased(e -> logarButton.setStyle(DefineView.estiloBotao));
      HBox grupoHBox = new HBox(10);
      grupoHBox.setAlignment(Pos.BOTTOM_RIGHT);
      grupoHBox.getChildren().add(logarButton);
      this.add(grupoHBox, 1, 4);

      /* Adiciona no grid: campo de resposta, posição (1,6) */
      final Text respostaDeLogarText = new Text();
      this.add(respostaDeLogarText, 1, 6);

      /* Lógica de logar... */
      logarButton.setOnAction(event -> {
        String usuario = usuarioTextField.getText();
        String senha = senhaPasswordField.getText();

        if(usuario.isEmpty() || senha.isEmpty()) {
          respostaDeLogarText.setText("Por favor preencha todos os campos.");
        } else {
          if(ctrlCtrl.userCtrl.confirmarLogin(usuario, senha)) {
            respostaDeLogarText.setText("Ok.");
            if (ctrlCtrl.userCtrl.confirmarPermissao(3)) {
              loop.vezDeMovimentacaoEstoqueView(ctrlCtrl);
            } else if (ctrlCtrl.userCtrl.confirmarPermissao(2)) {

            } else {
              loop.vezDeMovimentacaoEstoqueView(ctrlCtrl);
              //loop.vezMenuTmpView(ctrlCtrl);
            }
          } else {
            respostaDeLogarText.setText("Valores errados.");
          }
        }
      });
    } else {
      tituloText.setText("SDEDR - Primeiro uso\nEsse será o primeiro ADMIN user,\nenquanto não criar outros salve bem a senha.");
      /* Adiciona no grid: botão dentro de uma grupo, posição (1,4) */
      Button cadastrarButton = new Button("Salvar");    
      cadastrarButton.setStyle(DefineView.estiloBotao);
      cadastrarButton.setOnMousePressed(e -> cadastrarButton.setStyle(DefineView.estiloBotaoAtivo));
      cadastrarButton.setOnMouseReleased(e -> cadastrarButton.setStyle(DefineView.estiloBotao));
      HBox grupoHBox = new HBox(10);
      grupoHBox.setAlignment(Pos.BOTTOM_RIGHT);
      grupoHBox.getChildren().add(cadastrarButton);
      this.add(grupoHBox, 1, 4);

      /* Adiciona no grid: campo de resposta, posição (1,6) */
      final Text respostaDeCadastrarText = new Text();
      this.add(respostaDeCadastrarText, 1, 6);

      /* Lógica de logar... */
      cadastrarButton.setOnAction(event -> {
        String usuario = usuarioTextField.getText();
        String senha = senhaPasswordField.getText();

        if(usuario.isEmpty() || senha.isEmpty()) {
          respostaDeCadastrarText.setText("Por favor preencha todos os campos.");
        } else {
          if(ctrlCtrl.userCtrl.cadastrarPrimeiroLogin(usuario, senha)) {
            respostaDeCadastrarText.setText("Ok.");
          } else {
            respostaDeCadastrarText.setText("Tente outra vez.");
          }
        }
      });
    }
  }
}
