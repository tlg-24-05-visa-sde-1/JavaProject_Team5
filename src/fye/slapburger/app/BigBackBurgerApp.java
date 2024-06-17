package fye.slapburger.app;

import fye.slapburger.MenuItem;
import com.apps.util.Prompter;
import fye.slapburger.Chef;
import fye.slapburger.Order;
import fye.slapburger.Payment;

import java.util.List;
import java.util.Scanner;

public class BigBackBurgerApp {

  private final Chef chef = new Chef();
  private final Prompter prompter = new Prompter(new Scanner(System.in));

  public void execute() {
    welcome();
    showMenu();
    placeOrder();
    confirmOrder();
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
    chef.getOrder().displayOrder();

  }

  private void placeOrder() {
    Order order = new Order();
    boolean ordering = true;


    List<MenuItem> menu = order.getItems();

    while (ordering) {

      for (int i = 0; i < menu.size(); i++) {
        System.out.println((i + 1) + ". " + menu.get(i));
      }
      String itemNumber = prompter.prompt("\nEnter the number of the item you want to add to your order (or 0 to finish): ");

      int itemNumberInt = Integer.parseInt(itemNumber);

      if (itemNumberInt == 0) {
        ordering = false;
      } else if (itemNumberInt > 0 && itemNumberInt <= menu.size()) {
        order.addItem(menu.get(itemNumberInt - 1));
      } else {
        System.out.println("Invalid item number, please try again");
      }
    }
    order.displayOrder();
    if (Payment.processPayment(order.getTotalPrice())) {
      System.out.println("Payment successful! Here is your order. Enjoy your Big Back.");
    }
    order.clearOrder();
  }

  private void showMenu() {
  }

  private void welcome() {
  }
}