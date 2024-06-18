package fye.slapburger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Menu {
    public static List<MenuItem> MENU_ITEMS = new ArrayList<MenuItem>();
    public static Map<Character, MenuItem> MENU_MAP = new HashMap<>();

    static {

        MENU_ITEMS.add(new MenuItem("McDougie Burger", 5.99 ));
        MENU_ITEMS.add(new MenuItem("Hump Day Hotdog", 2.99));
        MENU_ITEMS.add(new MenuItem("Nachos of Notre Dame", 4.99));
        MENU_ITEMS.add(new MenuItem("Tayo Fries", 3.99));
        MENU_ITEMS.add(new MenuItem("Tater Tots", 6.99));
        MENU_ITEMS.add(new MenuItem("Onion Rings", 8.99));
        MENU_ITEMS.add(new MenuItem("Mexican Coke", 3.99));
        MENU_ITEMS.add(new MenuItem("Water", 1.99));
        MENU_ITEMS.add(new MenuItem("Sweet Tea", 2.99));

        MENU_MAP.put('A', MENU_ITEMS.get(0));
        MENU_MAP.put('B', MENU_ITEMS.get(1));
        MENU_MAP.put('C', MENU_ITEMS.get(2));
        MENU_MAP.put('D', MENU_ITEMS.get(3));
        MENU_MAP.put('E', MENU_ITEMS.get(4));
        MENU_MAP.put('F', MENU_ITEMS.get(5));
        MENU_MAP.put('G', MENU_ITEMS.get(6));
        MENU_MAP.put('H', MENU_ITEMS.get(7));
        MENU_MAP.put('I', MENU_ITEMS.get(8));

    }
}
