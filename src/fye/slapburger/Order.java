package fye.slapburger;

import java.util.ArrayList;
import java.util.List;

class Order {
  private List<MenuItem> items;
  private double totalPrice;

  public Order() {
    items = new ArrayList<MenuItem>();
    totalPrice = 0.0;
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






}