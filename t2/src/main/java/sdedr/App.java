package sdedr;

import sdedr.view.LoginView;
import java.time.LocalDate;
import java.time.LocalDateTime;
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
  public static void main(String[] args) {
    launch(args);
  }

  private Stage principalStage;

  @Override
  public void start(Stage stage) {
    this.principalStage = stage;
    this.principalStage.setTitle("Sistema de estoque de restaurante");
    vezDeLoginView();
  }

  public void vezDeLoginView() {
    LoginView loginView = new LoginView(this);
    Scene loginTela = new Scene(loginView, 500, 450);
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
}
