package fye.slapburger;

import java.util.List;

public enum FoodCategory {
    MAIN(List.of("McDougie Burger", "Hump Day Hotdog", "Nachos")),
    SIDES(List.of("Fries", "Elotes", "Tater Tots")),
    BEVERAGE(List.of("Mexican Coke, Water, Sweet Tea"));

    private final List<String> items;

    FoodCategory(List<String> items) {
        this.items = items;
    }

    public void getMenuItem(FoodCategory category) {
        for (String item : items) {
            if (category == FoodCategory.SIDES) {
                System.out.println(item);
            } else if (category == FoodCategory.MAIN) {
                System.out.println(item);
            }
        }
    }

    public List<String> getItems() {
        return items;
    }
}
