package fye.slapburger;

import static com.apps.util.Console.blankLines;

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
    System.out.println("**********************");
    System.out.println("Cooking Order # " + order.getID());
    System.out.println("**********************");
    for (Map.Entry<MenuItem, Integer> entry : countMap.entrySet()) {
      System.out.println("Cooking " + entry.getValue() + " " + entry.getKey().getName());
    }
    System.out.println("------------------------");
  }

  //Serve Order
  public void serve() {
    Map<MenuItem, Integer> countMap = getMenuItemCount();
    System.out.println("**********************");
    System.out.println("Serving Order # " + order.getID());
    System.out.println("**********************");
    System.out.println("This Order Contains: ");
    System.out.println("----------------------");
    blankLines(1);
    for (Map.Entry<MenuItem, Integer> entry : countMap.entrySet()) {
      System.out.println(entry.getValue() + ": " + entry.getKey().getName() + "[s]");
    }
  }

  private Map<MenuItem, Integer> getMenuItemCount() {
    List<MenuItem> orderItems = order.getItems();
    Map<MenuItem, Integer> countMap = order.countEachItem(orderItems);
    return countMap;
  }

}