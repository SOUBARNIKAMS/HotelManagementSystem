import java.util.ArrayList;
import java.util.List;
public class Guest extends Person {
    private static int guestCounter = 0;
    private int guestId;
    private ArrayList<String> preferences;
    private List<Order> orders;

    public Guest(String name, String password, String email, String phoneNumber, String preference) {
        super(name, "Guest", password, email, phoneNumber);
        this.guestId = ++guestCounter;
        this.preferences = new ArrayList<>();
        this.preferences.add(preference);
        this.orders = new ArrayList<>(); // Initialize the orders list
    }

    public int getGuestId() {
        return guestId;
    }

    public ArrayList<String> getPreferences() {
        return preferences;
    }

    public void addPreference(String preference) {
        preferences.add(preference);
    }

    public void viewOrders() {
        System.out.println("Orders for " + getName() + ":");
        for (Order order : orders) {
            System.out.println(order);
        }
    }

    public void placeOrder(Order order) {
        orders.add(order);
        System.out.println("Order placed successfully.");
    }
    public List<Order> getOrders() {
        return orders;
    }
    public Order getOrder(int orderNumber) {
        for (Order order : orders) {
            if (order.getOrderId() == orderNumber) {
                return order;
            }
        }
        return null; // Order not found
    }

    @Override
    public String toString() {
        return "Guest(guestId=" + guestId +
               ", name='" + getName() +
               "', type='" + getType() +
               "', email='" + getEmail() +
               "', phoneNumber='" + getPhoneNumber() +
               "', preferences=" + preferences +
               ")";
    }
}
