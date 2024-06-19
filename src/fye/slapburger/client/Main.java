package fye.slapburger.client;

import com.apps.util.SplashApp;
import fye.slapburger.app.BigBackBurgerApp;

class Main implements SplashApp {

  public static void main(String[] args) {
    Main main = new Main();
    main.welcome("images/truck.png");
    main.start();
  }

  @Override
  public void start() {
    BigBackBurgerApp app = new BigBackBurgerApp();
    app.execute();
  }
}