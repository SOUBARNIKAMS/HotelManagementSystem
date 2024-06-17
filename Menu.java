import java.util.*;

public class Menu {
    private Map<String, Integer> vegMenu = new HashMap<>();
    private Map<String, Integer> nonvegMenu = new HashMap<>();

    public Menu() {
        initializeMenu();
    }

    private void initializeMenu() {
        vegMenu.put("dosa", 120);
        vegMenu.put("poori", 100);
        vegMenu.put("chapati", 100);
        vegMenu.put("roti", 60);
        vegMenu.put("naan", 70);
        vegMenu.put("idli", 50);
        nonvegMenu.put("chicken biryani", 180);
        nonvegMenu.put("mutton biryani", 200);
        nonvegMenu.put("butter chicken", 160);
        nonvegMenu.put("egg biryani", 140);
    }

    public void displayVegMenu() {
        System.out.println("The dishes available in veg section are:");
        for (Map.Entry<String, Integer> entry : vegMenu.entrySet()) {
            System.out.println(entry.getKey() + " Rs" + entry.getValue());
        }
    }

    public void displayNonVegMenu() {
        System.out.println("The dishes available in nonveg section are:");
        for (Map.Entry<String, Integer> entry : nonvegMenu.entrySet()) {
            System.out.println(entry.getKey() + " Rs" + entry.getValue());
        }
    }

    public boolean isItemAvailable(String itemName) {
        return vegMenu.containsKey(itemName) || nonvegMenu.containsKey(itemName);
    }

    public double getPrice(String itemName) {
        if (vegMenu.containsKey(itemName)) {
            return vegMenu.get(itemName);
        } else if (nonvegMenu.containsKey(itemName)) {
            return nonvegMenu.get(itemName);
        }
        return 0.0; // Handle this case based on your application logic
    }

    public void addFoodItem(String itemName, int price, boolean isVeg) {
        if (isVeg) {
            vegMenu.put(itemName, price);
            System.out.println("Item added to veg menu: " + itemName + " Rs" + price);
        } else {
            nonvegMenu.put(itemName, price);
            System.out.println("Item added to nonveg menu: " + itemName + " Rs" + price);
        }
    }

    public void removeFoodItem(String itemName) {
        if (vegMenu.containsKey(itemName)) {
            vegMenu.remove(itemName);
            System.out.println("Item deleted from veg menu: " + itemName);
        } else if (nonvegMenu.containsKey(itemName)) {
            nonvegMenu.remove(itemName);
            System.out.println("Item deleted from nonveg menu: " + itemName);
        } else {
            System.out.println("Item not found in the menu: " + itemName);
        }
    }
}
