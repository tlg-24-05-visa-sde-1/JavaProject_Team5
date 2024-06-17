package fye.slapburger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Order {

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
    System.out.println("Your Order:");
    for (MenuItem item : items) {
      System.out.println(item);
    }
    System.out.format("Total Price: %.2f\n", totalPrice);
  }

  public void clearOrder() {
    items.clear();
    totalPrice = 0.0;
  }

  public List<MenuItem> getItems() {
    return items;
  }

  public void setItems(List<MenuItem> items) {
    this.items = items;
  }

  public double getTotalPrice() {
    return totalPrice;
  }

  public void setTotalPrice(double totalPrice) {
    this.totalPrice = totalPrice;
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