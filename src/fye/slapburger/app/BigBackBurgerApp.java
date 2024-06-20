package fye.slapburger.app;

import static com.apps.util.Console.blankLines;
import static com.apps.util.Console.clear;
import static com.apps.util.Console.pause;
import static fye.slapburger.Menu.MENU_MAP;

import com.apps.util.Prompter;
import fye.slapburger.Chef;
import fye.slapburger.MenuItem;
import fye.slapburger.Order;
import fye.slapburger.Payment;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BigBackBurgerApp {

  private static final Prompter prompter = new Prompter(new Scanner(System.in));
  private final Order order = new Order();
  private Chef chef;

  public void execute() {

    intro();
    Map<MenuItem, Integer> orderMap = placeOrder();
    boolean keepOrder = true;
    while (keepOrder) {
      String confirmed = prompter.prompt("Confirm your order by pressing [1] or cancel with [0] ",
          "[1|0]", "\nPlease Select [1] 0r [0]");
      if (Integer.parseInt(confirmed) == 1) {
        payForOrder(order);
        chef = new Chef(order);
        chef.cook();
        chef.serve();
        keepOrder = false;
      } else {
        order.clearOrder();
        orderMap.clear();
        orderMap = placeOrder();
      }
    }
  }

  private void payForOrder(Order order) {
    clear();
    boolean paymentSuccess = false;
    while (!paymentSuccess) {
      String paymentMethod = prompter.prompt(
          "Please select payment method ([D]ebit-Card or [C]ash): ", "[D|C|c|d]",
          "\nMust choose D or C\n").toUpperCase();
      paymentSuccess = Payment.processPayment(order.getTotalPrice(), paymentMethod);
      if (!paymentSuccess) {
        prompter.info("Card payment FAILED! Jay's Debit cards were imaginary!");
        blankLines(1);
      } else {
        prompter.info("Payment SUCCESSFUL!");
        blankLines(1);
      }
    }
  }

  private Map<MenuItem, Integer> placeOrder() {
    clear();
    Map<MenuItem, Integer> orderMap = new HashMap<>();
    boolean ordering = true;

    while (ordering) {
      showMenu();
      order.displayOrder();
      String input = prompter.prompt(
          "Enter the letter of the item you wish to order [Press [1] to finish]  : ",
          "[A-I|a-i|1]", "\nPlease enter a letter from the Menu\n").toUpperCase();
      if (input.equals("1")) {
        ordering = false;
      } else if (input.length() == 1 && MENU_MAP.containsKey(input.charAt(0))) {
        MenuItem selectedItem = MENU_MAP.get(input.charAt(0));
        order.addItem(selectedItem);
        orderMap.put(selectedItem, orderMap.getOrDefault(selectedItem, 0) + 1);
      }
    }
    clear();
    order.displayOrder();
    return orderMap;
  }

  private void showMenu() {
    try {
      clear();
      String menuFile = Files.readString(Path.of("resources/menu.txt"));
      prompter.info("\n" + menuFile + "\n");
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  private void intro() {
    try {
      String bigBackBurgerFile = Files.readString(Path.of("resources/bigBackBurger.txt"));
      prompter.info("\n" + bigBackBurgerFile + "\n");
      pause(3500);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}