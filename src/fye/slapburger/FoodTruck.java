package fye.slapburger;

public class FoodTruck {
  private Menu menu;
  private Chef chef;



  public FoodTruck( Chef chef, Menu menu) {
    this.menu = menu;
    this.chef = chef;
  }

  public Menu getMenu() {
    return menu;
  }

  public void setMenu(Menu menu) {
    this.menu = menu;
  }

  public Chef getChef() {
    return chef;
  }

  public void setChef(Chef chef) {
    this.chef = chef;
  }
}