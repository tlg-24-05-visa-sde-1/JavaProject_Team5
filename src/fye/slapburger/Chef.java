package fye.slapburger;

import java.util.List;
import java.util.Map;

public class Chef {

  private Order order = new Order();

  public Chef(Order order) {
    this.order = order;
  }

  //take an Order of MenuItems cooks MenuItems
  public void cook() {
    //TODO prepare menu.txt Items from order
    Map<MenuItem, Integer> countMap = getMenuItemCount();
    System.out.println("Cooking Order Number: " + order.getID());
    for (Map.Entry<MenuItem, Integer> entry : countMap.entrySet()) {
      System.out.println("Cooking " + entry.getValue() + " " + entry.getKey().getName());
    }
  }

  //Serve Order
  public void serve() {
    Map<MenuItem, Integer> countMap = getMenuItemCount();
    System.out.println("Serving + " + order.getID());
    System.out.println("This Order Contains: ");
    for (Map.Entry<MenuItem, Integer> entry : countMap.entrySet()) {
      System.out.println(entry.getKey().getName() + ": " + entry.getValue());
    }
  }

  private Map<MenuItem, Integer> getMenuItemCount() {
    List<MenuItem> orderItems = order.getItems();
    Map<MenuItem, Integer> countMap = order.countEachItem(orderItems);
    return countMap;
  }

  public Order getOrder() {
    return order;
  }

  public void setOrder(Order order) {
    this.order = order;
  }
}