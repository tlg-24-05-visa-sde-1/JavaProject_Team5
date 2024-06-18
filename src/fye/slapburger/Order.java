package fye.slapburger;

import static com.apps.util.Console.blankLines;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Order {

  private List<MenuItem> items;
  private double totalPrice;
  private int ID = 0;
  private String nameOfCustomer;

  public Order() {
    items = new ArrayList<MenuItem>();
    totalPrice = 0.0;
    ID++;
  }

  public Map<MenuItem, Integer> countEachItem(List<MenuItem> items) {
    this.items = items;
    Map<MenuItem, Integer> map = new HashMap<MenuItem, Integer>();
    for (MenuItem item : items) {
      map.put(item, map.getOrDefault(item, 0) + 1);
    }
    return map;
  }

  public void addItem(MenuItem item) {
    items.add(item);
    totalPrice += item.getPrice();
  }

  public void displayOrder() {
    System.out.println("Your Order: ");
    System.out.println("***********************");
    for (MenuItem item : items) {
      System.out.println(item);
    }
    System.out.println("***********************");

    System.out.format("Total Price: %.2f\n", totalPrice);
    System.out.println("----------------------");
    blankLines(2);
  }

  public void clearOrder() {
    items.clear();
    totalPrice = 0.0;
  }

  public List<MenuItem> getItems() {
    return items;
  }

  public double getTotalPrice() {
    return totalPrice;
  }

  public int getID() {
    return ID;
  }

  public String getNameOfCustomer() {
    return nameOfCustomer;
  }

  public void setNameOfCustomer(String nameOfCustomer) {
    this.nameOfCustomer = nameOfCustomer;
  }
}