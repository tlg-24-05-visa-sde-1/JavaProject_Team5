package fye.slapburger;

public class MenuItem {
  private FoodCategory foodCategory;
  private String name;
  private double price;

  public FoodCategory getFoodCategory() {
    return foodCategory;
  }

  public void setFoodCategory(FoodCategory foodCategory) {
    this.foodCategory = foodCategory;
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

}