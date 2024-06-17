import java.time.LocalDate;
public class Reservation {
    private String guestName;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private Room room;
    private double cost;
    private boolean paymentStatus;

    public Reservation(String guestName, LocalDate checkInDate, LocalDate checkOutDate, Room room, double cost) {
        this.guestName = guestName;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.room = room;
        this.cost = cost;
        this.paymentStatus = false; // Default payment status is false (not paid)
    }

    public String getGuestName() {
        return guestName;
    }

    public void setGuestName(String guestName) {
        this.guestName = guestName;
    }

    public LocalDate getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(LocalDate checkInDate) {
        this.checkInDate = checkInDate;
    }

    public LocalDate getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(LocalDate checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public boolean isPaymentStatus() {
        return paymentStatus;
    }
    public void makePayment() {
        System.out.println("Processing payment for reservation...");
        this.paymentStatus = true;
        System.out.println("Payment successful for reservation:\n" + this);
    }

    @Override
    public String toString() {
        return "Reservation details:\n" +
               "Guest Name: " + guestName + "\n" +
               "Check-in Date: " + checkInDate + "\n" +
               "Check-out Date: " + checkOutDate + "\n" +
               "Room Number: " + room.getRoomNumber() + "\n" +
               "Cost: " + cost + "\n" + 
               "Payment Status: " + (paymentStatus ? "Paid" : "Not Paid");
    }
}
