package sdedr;


/* JavaFX coisas:
 * link legal: https://docs.oracle.com/javafx/2/get_started/hello_world.htm
 * obs. É dinâmico! Whoa que moderno... */
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import sdedr.view.LoginView;

public class App extends Application {
  public static void main(String[] args) {
    /* Lançar a aplicação JavaFX */
    launch(args);
  }

  /* Palco das cenas */
  private Stage principalStage;

  @Override
  public void start(Stage stage) {
    /* Vamos construir e manipular LoginView em seu .java
     * Mas instaciamos ele aqui no App, como uma tela. */ 
    this.principalStage = stage;
    this.principalStage.setTitle("Sistema de estoque de restaurante");
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
