package fye.slapburger.client;

import com.apps.util.SplashApp;
import fye.slapburger.app.BigBackBurgerApp;

class Main implements SplashApp {

  public static void main(String[] args) {
    Main mainApp = new Main();
    mainApp.welcome("images/steakfries.png", "images/meal.png");
    mainApp.start();
  }

  @Override
  public void start() {
    BigBackBurgerApp app = new BigBackBurgerApp();
    app.execute();
  }
}