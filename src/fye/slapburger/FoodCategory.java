package fye.slapburger;

import java.util.List;

public enum FoodCategory {
    MAIN(List.of("McDougie Burger", "Hotdog", "Nachos")),
    SIDES(List.of("Fries", "Elotes", "Tater Tots"));

    private final List<String> items;

    FoodCategory(List<String> items) {
        this.items = items;
    }

    public List<String> getItems() {
        return items;
    }
}
