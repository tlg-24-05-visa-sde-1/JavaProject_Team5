package fye.slapburger;

import static com.apps.util.Console.blankLines;
import static com.apps.util.Console.pause;

import java.util.List;
import java.util.Map;

public class Chef {

  private Order order = new Order();

  public Chef(Order order) {
    this.order = order;
  }

  //take an Order of MenuItems cooks MenuItems
  public void cook() {
    Map<MenuItem, Integer> countMap = getMenuItemCount();
    System.out.println("***************************");
    System.out.println("Cooking Order # " + order.getID());
    System.out.println("***************************");

    blankLines(2);
    pause(5500);
  }

  //Serve Order
  public void serve() {
    Map<MenuItem, Integer> countMap = getMenuItemCount();
    System.out.println("******************************");
    System.out.println("Serving Order # " + order.getID());
    System.out.println("******************************");
    System.out.println("This Order Contains: ");
    System.out.println("-------------------------------");
    for (Map.Entry<MenuItem, Integer> entry : countMap.entrySet()) {
      System.out.println(entry.getValue() + "x  | " + entry.getKey().getName());
    }
    blankLines(2);
    System.out.println("----------------------------------------------");
    System.out.println("Here is your order. Enjoy your Big Back Meal!");
    System.out.println("----------------------------------------------");
    blankLines(3);
  }

  private Map<MenuItem, Integer> getMenuItemCount() {
    List<MenuItem> orderItems = order.getItems();
    Map<MenuItem, Integer> countMap = order.countEachItem(orderItems);
    return countMap;
  }

}