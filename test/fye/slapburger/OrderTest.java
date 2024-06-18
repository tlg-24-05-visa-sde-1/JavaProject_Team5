package fye.slapburger;

import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class OrderTest {

  Order order;
  List<MenuItem> items;

  @Before
  public void setUp() {
    order = new Order();
    MenuItem mcdougie = new MenuItem("McDougie Burger", 5.99);
    MenuItem dog = new MenuItem("Hump Day Hotdog", 2.99);
    MenuItem coke = new MenuItem("Mexican Coke", 3.99);
    MenuItem water = new MenuItem("Water", 1.99);
    order.addItem(mcdougie);
    order.addItem(mcdougie);
    order.addItem(dog);
    order.addItem(coke);
    order.addItem(water);
    items = order.getItems();
  }

  @Test
  public void countEachItem() {
  }

  @Test
  public void clearOrder() {
  }
}