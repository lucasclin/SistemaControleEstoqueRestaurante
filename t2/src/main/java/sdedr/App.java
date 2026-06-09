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

import sdedr.view.LoginView;

public class App extends Application {

  /* Palco das cenas */
  private Stage principalStage;

  @Override
  public void start(Stage stage) {
    /* Vamos construir e manipular LoginView em seu .java
     * Mas instaciamos ele aqui no App, como uma tela. */ 
    this.principalStage = stage;
    this.principalStage.setTitle("SDEDR - Sistema de estoque de restaurante");
    /* Aqui teremos um "ArrayList", ou melhor uma árvore chamada:
     * primaryStage que conterá:
     *  loginTela - manterGeralView - etc.
     * E dependendo da ação utilizará um .set e .show para manipular as telas... */
    vezDeLoginView();
  }

  public void vezDeLoginView() {
    LoginView loginView = new LoginView(this);
    Scene loginTela = new Scene(loginView, 300, 250);
    principalStage.setScene(loginTela);
    principalStage.show();
  }
}
