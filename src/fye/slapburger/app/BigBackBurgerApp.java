package fye.slapburger.app;

import static com.apps.util.Console.clear;
import static com.apps.util.Console.pause;

import fye.slapburger.*;
import com.apps.util.Prompter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class BigBackBurgerApp {

  private final Order order = new Order();
  //private final Menu menu = new Menu();
  private final Prompter prompter = new Prompter(new Scanner(System.in));
  static List<MenuItem> menu = new ArrayList<MenuItem>();
  static Map<Character, MenuItem> menuMap = new HashMap<>();
  static {

    menu.add(new MenuItem("McDougie Burger", 5.99, FoodCategory.MAIN));
    menu.add(new MenuItem("Hump Day Hotdog", 2.99, FoodCategory.MAIN));
    menu.add(new MenuItem("Nachos", 4.99, FoodCategory.MAIN));
    menu.add(new MenuItem("Cheesy Fries", 3.99, FoodCategory.SIDES));
    menu.add(new MenuItem("Tater Tots", 6.99, FoodCategory.SIDES));
    menu.add(new MenuItem("Onion Rings", 8.99, FoodCategory.SIDES));
    menu.add(new MenuItem("Mexican Cola", 3.99, FoodCategory.BEVERAGE));
    menu.add(new MenuItem("Water", 1.99, FoodCategory.BEVERAGE));
    menu.add(new MenuItem("Sweet Tea", 2.99, FoodCategory.SIDES));


    menuMap.put('A', menu.get(0));
    menuMap.put('B', menu.get(1));
    menuMap.put('C', menu.get(2));
    menuMap.put('D', menu.get(3));
    menuMap.put('E', menu.get(4));
    menuMap.put('F', menu.get(5));
    menuMap.put('G', menu.get(6));
    menuMap.put('H', menu.get(7));
    menuMap.put('I', menu.get(8));

  }

  private Map<MenuItem, Integer> placeOrder() {
    Scanner scanner = new Scanner(System.in);
    Map<MenuItem, Integer> orderMap = new HashMap<>();
    Order order = new Order();
    boolean ordering = true;

    while (ordering) {
      System.out.println("\nMenu: ");
      for (Map.Entry<Character, MenuItem> entry : menuMap.entrySet()) {
        System.out.println(entry.getKey() + ". " + entry.getValue());
      }
      System.out.print("\nEnter the letter of the item you wish to order (or 0 to finished): ");
      String input = scanner.nextLine().trim();

      if (input.equals("0")) {
        ordering = false;
      } else if (input.length() == 1 && menuMap.containsKey(input.charAt(0))) {
        MenuItem selectedItem = menuMap.get(input.charAt(0));
        order.addItem(selectedItem);
        orderMap.put(selectedItem, orderMap.getOrDefault(selectedItem, 0) + 1);
      } else {
        System.out.println("Invalid item selection, please select a valid item");
      }
    }




      return orderMap;
  }

  public void execute() {
//    welcome();
//    showMenu();
    Map<MenuItem, Integer> orderMap = placeOrder();
    for (Map.Entry<MenuItem, Integer> entry : orderMap.entrySet()) {
      System.out.println(entry.getKey() + ". " + entry.getValue());
    }
//    confirmOrder();
//    pay();
//    cookOrder();
//    serveOrder();
//    reviewFood();
  }

//  private void reviewFood(Prompter prompter) {
//    System.out.println("Leave A Review of Your Big Back Experience ");
//    String review = prompter.prompt("Enter your review: ");
//    chef.setOrder(order);
//    System.out.println("Thank you for your Big Feedback");
//
//  }

  private void serveOrder() {
  }

  private void cookOrder() {
  }

  private void pay() {
    //TODO: give order total and take payment
  }

//  private void confirmOrder() {
//    chef.getOrder().displayOrder();
//
//  }




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