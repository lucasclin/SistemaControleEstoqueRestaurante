package sdedr;

import java.time.LocalDate;
import java.time.LocalDateTime;

/* JavaFX coisas:
 * link legal: https://docs.oracle.com/javafx/2/get_started/hello_world.htm
 * obs. É dinâmico! Whoa que moderno... */
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.text.Font;

import sdedr.view.*;
import sdedr.ctrl.CtrlCtrl;

public class App extends Application {
  /* Palco das cenas */
  private Stage principalStage;

  @Override
  public void start(Stage stage) {
    /* Vamos construir e manipular LoginView em seu .java Mas instaciamos ele aqui no App, como uma tela. */ 
    this.principalStage = stage;
    this.principalStage.setTitle("SDEDR - Sistema de estoque de restaurante");
    /* A manipulação das telas ficarão no view */
    Font.loadFont(getClass().getResourceAsStream("/fonts/BlexMonoNerdFont-Regular.ttf"), 12);
    vezDeLoginView();
  }

  /* Se tiver a opção de terminar sessão chamar esse método */
  public void vezDeLoginView() {
    LoginView loginView = new LoginView(this);
    Scene loginTela = new Scene(loginView, 300, 250);
    principalStage.setScene(loginTela);
    principalStage.show();
  }

  public void vezMenuTmpView(CtrlCtrl aux) {    
    MenuTmpView menuTmpView = new MenuTmpView(this, aux);
    DecoView menuTmpViewDecorado = new DecoView(menuTmpView);
    Scene menuTmpTela = new Scene(menuTmpViewDecorado, 450, 500);
    principalStage.setScene(menuTmpTela);
    principalStage.show();
  }

  /* Se quiser ir para Tabelas de Produto ou Receita informar tipo */
  public void vezDeManterGeralView(int tipo, CtrlCtrl aux) {
    ManterGeralView manterGeralView = new ManterGeralView(this, tipo, aux);
    Scene manterGeralTela = new Scene(manterGeralView, 450, 500);
    principalStage.setScene(manterGeralTela);
    principalStage.show();
  }

  public void vezDeMovimentacaoEstoqueView(CtrlCtrl aux) {
    MovimentacaoEstoqueView movimentacaoEstoqueView = new MovimentacaoEstoqueView(this, aux);
    DecoView movimentacaoEstoqueViewDecorada = new DecoView(movimentacaoEstoqueView);
    Scene movimentacaoEstoqueTela = new Scene(movimentacaoEstoqueViewDecorada, 450, 500);
    principalStage.setScene(movimentacaoEstoqueTela);
    principalStage.show();
  }

  private void applyGlobalStyles(Scene scene) {
    String cssCam = getClass().getResource("/css/uniqlo.css").toExternalForm();
    scene.getStylesheets().add(cssCam);
  }
}
