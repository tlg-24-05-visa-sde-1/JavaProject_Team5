package fye.slapburger;

public class MenuItem {
  private FoodCategory category;
  private String name;
  private double price;


  public MenuItem(String name, double price, FoodCategory category) {
    this.name = name;
    this.price = price;
    this.category = category;
  }


  public FoodCategory getCategory() {
    return category;
  }

  public void setCategory(FoodCategory category) {
    this.category = category;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  @Override
  public String toString() {
    return name + " - $" + price + " (" + category + ")";
  }


}