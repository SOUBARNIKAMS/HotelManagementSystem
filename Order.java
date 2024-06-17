import java.util.HashMap;
import java.util.Map;

public class Order {
    private static int nextOrderId = 1;

    private int orderId;
    private String guestName;
    private boolean paymentStatus;
    private double totalCost;
    private Map<String, Integer> itemsOrdered; // item name -> quantity

    public Order(String guestName) {
        this.orderId = nextOrderId++;
        this.guestName = guestName;
        this.paymentStatus = false;
        this.totalCost = 0.0;
        this.itemsOrdered = new HashMap<>();
    }

    public int getOrderId() {
        return orderId;
    }

    public String getGuestName() {
        return guestName;
    }

    public boolean isPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(boolean paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public Map<String, Integer> getItemsOrdered() {
        return itemsOrdered;
    }

    public void addItem(String itemName, int quantity, Menu menu) {
        if (menu.isItemAvailable(itemName)) {
            if (itemsOrdered.containsKey(itemName)) {
                itemsOrdered.put(itemName, itemsOrdered.get(itemName) + quantity);
            } else {
                itemsOrdered.put(itemName, quantity);
            }
            totalCost += menu.getPrice(itemName) * quantity;
            System.out.println("Item added to order: " + itemName + ", Quantity: " + quantity);
        } else {
            System.out.println("Item not available in the menu: " + itemName);
        }
    }

    @Override
    public String toString() {
        return "Order ID: " + orderId +
               "\nGuest Name: " + guestName +
               "\nPayment Status: " + (paymentStatus ? "Paid" : "Not Paid") +
               "\nTotal Cost: Rs" + totalCost +
               "\nItems Ordered: " + itemsOrdered;
    }
}
