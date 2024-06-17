package fye.slapburger.app;

import static com.apps.util.Console.clear;
import static com.apps.util.Console.pause;

import fye.slapburger.FoodTruck;
import fye.slapburger.Menu;
import fye.slapburger.MenuItem;
import com.apps.util.Prompter;
import fye.slapburger.Chef;
import fye.slapburger.Order;
import fye.slapburger.Payment;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class BigBackBurgerApp {

  private final Chef chef = new Chef();
  private final Order order = new Order();
  private final Menu menu = new Menu();
  Map<MenuItem, Integer> orderMap;

  private final Prompter prompter = new Prompter(new Scanner(System.in));

  public BigBackBurgerApp() {
    FoodTruck foodTruck = new FoodTruck(chef, menu);
  }


  public void execute() {
    welcome();
    showMenu();
    Map<MenuItem, Integer> orderMap = placeOrder();
//    confirmOrder();
//    pay();
//    cookOrder();
//    serveOrder();
//    reviewFood();
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

  private Map<MenuItem, Integer> placeOrder() {

    /*
     * prompt for which items they want to order, after each selection, prompt for how many they want of that item
     * store in a map whos key is MenuItem and Value is Integer Map<MenuItem, Integer> orderMap;
     */

    orderMap = new HashMap<MenuItem, Integer>();
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

    return orderMap;
  }

  private void showMenu() {
    try {
      String menuFile = Files.readString(Path.of("resources/menu.txt"));
      System.out.println("\n" + menuFile + "\n");
    } catch (IOException e) {
      throw new RuntimeException(e);
    }

  }

  private void welcome() {
    try {
      String bigBackBurgerFile = Files.readString(Path.of("resources/bigBackBurger.txt"));
      System.out.println("\n" + bigBackBurgerFile + "\n");
      pause(3500);
      clear();
    } catch (IOException e){
      e.printStackTrace();
    }
  }
}