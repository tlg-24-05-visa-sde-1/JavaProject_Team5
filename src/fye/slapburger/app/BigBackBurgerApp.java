package fye.slapburger.app;

import fye.slapburger.Chef;
import fye.slapburger.Order;

public class BigBackBurgerApp {

  Chef chef = new Chef();

  public void execute() {
    welcome();
    showMenu();
    placeOrder();
    chef.getOrder().displayOrder();
    pay();
    cookOrder();
    serveOrder();
    reviewFood();
  }

  private void reviewFood() {
  }

  private void serveOrder() {
  }

  private void cookOrder() {
  }

  private void pay() {
    //TODO: give order total and take payment
  }

  private void confirmOrder() {
  }

  private void placeOrder() {
    //TODO: Choose from menu items and save the order to a file;
  }

  private void showMenu() {
  }

  private void welcome() {
  }
}