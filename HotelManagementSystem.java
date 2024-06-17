import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class HotelManagementSystem {
    private static Scanner scanner = new Scanner(System.in);
    private static Menu menu = new Menu();
    private static Admin admin; 
    private static ArrayList<Employee> employees = new ArrayList<>();
    private static ArrayList<Room> rooms = new ArrayList<>();
    private static ArrayList<Reservation> reservations = new ArrayList<>();
    private static ArrayList<Guest> guests = new ArrayList<>();
    public static void main(String[] args) {
        admin = new Admin("Admin Name", "admin", "admin@example.com", "1234566788");
        initalizationHotel();
        System.out.println("Welcome to the Hotel Management System!");
        boolean exit = false;
        while (!exit) {
            System.out.println("\nPlease choose your role:");
            System.out.println("1. Admin");
            System.out.println("2. Guest");
            System.out.println("3. Exit");
            System.out.print("Enter your choice (1, 2, or 3): ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    authenticateAdmin();
                    break;
                case 2:
                    guestMenu();
                    break;
                case 3:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
                    break;
            }
        }
        System.out.println("Exiting the Hotel Management System. Goodbye!");
        scanner.close();
    }
    private static void initalizationHotel(){
        employees.add(new Employee("Employee1", "employee1@example.com", "1111111111", "chef"));
        employees.add(new Employee("Employee2", "employee2@example.com", "2222222222", "server"));
        employees.add(new Employee("Employee3", "employee3@example.com", "3333333333", "manager"));
        guests.add(new Guest("varun","varun123","va12@gmail.com","4321111234","less noise"));
        rooms.add(new Room(101, "double", false, "WiFi"));
        rooms.add(new Room(102, "single", false, "TV"));
        rooms.add(new Room(103, "suite", false, "Jacuzzi"));
    }
    private static void authenticateAdmin() {
        System.out.print("Enter admin password: ");
        String password = scanner.nextLine();
        if (admin.authenticate(password)) {
            System.out.println("Admin authenticated successfully.");
            displayAdminMenu();
        } else {
            System.out.println("Authentication failed. Invalid password.");
        }
    }
    private static void authenticateGuest() {
        System.out.print("Enter guest username: ");
        String username = scanner.nextLine();
        System.out.print("Enter guest password: ");
        String password = scanner.nextLine();

        Guest guest = findGuest(username);
        if (guest != null && guest.authenticate(password)) {
            System.out.println("Guest authenticated successfully.");
            displayGuestMenu(guest); 
        } else {
            System.out.println("Authentication failed. Invalid username or password.");
        }
    }
    private static Guest findGuest(String username) {
        for (Guest guest : guests) {
            if (guest.getName().equalsIgnoreCase(username)) {
                return guest;
            }
        }
        return null;
    }
    private static void displayAdminMenu() {
        boolean adminExit = false;
        while (!adminExit) {
            System.out.println("\nAdmin Menu:");
            System.out.println("1. Add Employee");
            System.out.println("2. View Employee Details");
            System.out.println("3. Add Room");
            System.out.println("4. View Room Details");
            System.out.println("5. View Guest Details");
            System.out.println("6. View Menu");
            System.out.println("7. Add Food Item");
            System.out.println("8. Remove Food Item");
            System.out.println("9. Exit to Main Menu");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 
            switch (choice) {
                case 1:
                    addEmployee();
                    break;
                case 2:
                    viewEmployeeDetails();
                    break;
                case 3:
                    addRoom();
                    break;
                case 4:
                    viewRoomDetails();
                    break;
                case 5:
                    viewGuestDetails();
                    break;
                case 6:
                    viewMenu();
                    break;
                case 7:
                    addFoodItem();
                    break;
                case 8:
                    removeFoodItem();
                    break;
                case 9:
                    adminExit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
                    break;
            }
        }
    }
    private static void addEmployee() {
        System.out.println("\nEnter employee details:");
        String name = getInput("Enter employee name: ");
        String email = getEmailInput();
        String phoneNumber = getInput("Enter employee phone number: ");
        String post = getValidPost();
        Employee newEmployee = new Employee(name, email, phoneNumber, post);
        employees.add(newEmployee);
        System.out.println("New employee added successfully:\n" + newEmployee);
    }
    private static String getEmailInput() {
        String email;
        do {
            email = getInput("Enter employee email: ");
            if (!isValidEmail(email)) {
                System.out.println("Invalid email format. Please enter a valid email.");
            }
        } while (!isValidEmail(email));
        return email;
    }
    private static String getValidPost() {
        String post;
        do {
            post = getInput("Enter employee post (chef, server, manager, housekeeping): ");
            if (!isValidPost(post)) {
                System.out.println("Invalid post. Please enter a valid post.");
            }
        } while (!isValidPost(post));
        return post;
    }
    private static boolean isValidPost(String post) {
        String[] validPosts = {"chef", "server", "manager", "housekeeping"};
        for (String valid : validPosts) {
            if (post.equalsIgnoreCase(valid)) {
                return true;
            }
        }
        return false;
    }
    private static boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        return email.matches(emailRegex);
    }
    private static void addRoom() {
        System.out.println("\nEnter room details:");
        int roomNumber = getIntInput("Enter room number: ");
        String roomType = getValidRoomType();
        String amenity = getInput("Enter room amenity: ");
        Room newRoom = new Room(roomNumber, roomType, false, amenity);
        rooms.add(newRoom);
        System.out.println("New room added successfully:\n" + newRoom);
    }
    private static int getIntInput(String message) {
        int number;
        do {
            System.out.print(message);
            while (!scanner.hasNextInt()) {
                System.out.print("Invalid input. Please enter a number: ");
                scanner.next(); // Discard invalid input
            }
            number = scanner.nextInt();
            scanner.nextLine(); 
        } while (number <= 0); 
        return number;
    }
    private static String getValidRoomType() {
        String roomType;
        do {
            roomType = getInput("Enter room type (single, double, twin, suite, family): ");
            if (!isValidRoomType(roomType)) {
                System.out.println("Invalid room type. Please enter a valid room type.");
            }
        } while (!isValidRoomType(roomType));
        return roomType;
    }
    private static boolean isValidRoomType(String roomType) {
        String[] validRoomTypes = {"single", "double", "twin", "suite", "family"};
        for (String valid : validRoomTypes) {
            if (roomType.equalsIgnoreCase(valid)) {
                return true;
            }
        }
        return false;
    }
    private static void viewRoomDetails() {
        System.out.println("\nRoom Details:");
        for (Room room : rooms) {
            System.out.println(room);
            System.out.println();
        }
    }
    private static void viewGuestDetails() {
        System.out.println("\nGuest Details:");
        for (Guest guest : guests) {
            System.out.println(guest);
            System.out.println();
        }
    }
    private static void viewEmployeeDetails() {
        System.out.println("\nEmployee Details:");
        for (Employee employee : employees) {
            System.out.println(employee);
            System.out.println();
        }
    }
    private static void viewMenu(){
        System.out.println("Menu:");
        System.out.println("Veg Items\n");
        menu.displayVegMenu();
        System.out.println("\nNonveg Items\n");
        menu.displayNonVegMenu();
    }
    private static void addFoodItem() {
        System.out.println("\nAdding Food Item:");
        System.out.print("Enter the name of the item: ");
        String itemName = scanner.nextLine();
        
        System.out.print("Enter the price of the item: ");
        int price = scanner.nextInt();
        scanner.nextLine(); 
        
        System.out.print("Is the item vegetarian? (yes/no): ");
        String vegChoice = scanner.nextLine().trim().toLowerCase();
        
        boolean isVeg = vegChoice.equals("yes") || vegChoice.equals("y");

        menu.addFoodItem(itemName.toLowerCase(), price, isVeg);
    }
    private static void removeFoodItem() {
        System.out.println("\nRemoving Food Item:");
        System.out.print("Enter the name of the item to remove: ");
        String itemName = scanner.nextLine();

        menu.removeFoodItem(itemName.toLowerCase());
        System.out.println();System.out.println();
        menu.displayNonVegMenu();
        menu.displayVegMenu();
    }
    private static void guestMenu() {
        System.out.println("\nGuest Menu:");
        System.out.println("1. Login");
        System.out.println("2. Sign Up");
        System.out.println("3. Back to Main Menu");
        System.out.print("Enter your choice (1, 2, or 3): ");
        int choice = scanner.nextInt();
        scanner.nextLine(); 
        switch (choice) {
            case 1:
                authenticateGuest();
                break;
            case 2:
                signUpGuest();
                break;
            case 3:
                break;
            default:
                System.out.println("Invalid choice. Please enter a valid option.");
                break;
        }
    }
    private static void signUpGuest() {
        System.out.println("\nGuest Sign Up:");
        String name = getInput("Enter guest name: ");
        String password = getInput("Enter guest password: ");
        String email = getEmailInput();
        String phoneNumber = getInput("Enter guest phone number: ");
        String preference = getInput("Enter guest preference: ");
        Guest newGuest = new Guest(name, password, email, phoneNumber, preference);
        guests.add(newGuest);
        System.out.println("Guest signed up successfully. You can now log in.");
    }
    private static String getInput(String message) {
        System.out.print(message);
        return scanner.nextLine();
    }
    private static void displayGuestMenu(Guest guest) {
        boolean guestExit = false;
        while (!guestExit) {
            System.out.println("\nGuest Menu:");
            System.out.println("1. View Room Availability");
            System.out.println("2. Make Reservation");
            System.out.println("3. Make Room Payment");
            System.out.println("4. View Reservations");
            System.out.println("5. View Menu");
            System.out.println("6. Place Order");
            System.out.println("7. View Order");
            System.out.println("8. Make Order Payment");
            System.out.println("9. Leave Feedback");
            System.out.println("10. Exit to Main Menu");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 
            switch (choice) {
                case 1:
                    viewRoomAvailability();
                    break;
                case 2:
                    makeReservation(guest);
                    break;
                case 3:
                    makePayment(guest);
                    break;
                case 4:
                    viewGuestReservations(guest);
                    break;
                case 5:
                    viewMenu();
                    break;
                case 6:
                    placeOrder(guest,menu);
                    break;
                case 7:
                    guest.viewOrders();
                    break;
                case 8:
                    makeOrderPayment(guest);
                    break;      
                case 9:
                    showFeedbackForm(guest);
                    break;
                case 10:
                    guestExit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
                    break;
            }
        }
    }
    private static void viewRoomAvailability() {
        System.out.println("\nRoom Availability:");
        for (Room room : rooms) {
            if (!room.isOccupied()) {
                System.out.println(room);
                System.out.println();
            }
        }
    }
    private static void makeReservation(Guest guest) {
        System.out.println("\nMake Reservation:");
        viewRoomAvailability();
        System.out.print("Enter room number to reserve: ");
        int roomNumber = scanner.nextInt();
        scanner.nextLine(); 
        Room selectedRoom = findRoomByNumber(roomNumber);
        if (selectedRoom != null && !selectedRoom.isOccupied()) {
            LocalDate checkInDate = getValidDate("Enter check-in date (yyyy-mm-dd): ");
            LocalDate checkOutDate = getValidDate("Enter check-out date (yyyy-mm-dd): ");
            double cost = calculateReservationCost(selectedRoom, checkInDate, checkOutDate);
            Reservation reservation = new Reservation(guest.getName(), checkInDate, checkOutDate, selectedRoom, cost);
            reservations.add(reservation);
            selectedRoom.setRoomStatus(true); 
            System.out.println("Reservation made successfully:\n" + reservation);
        } else {
            System.out.println("Room not available or does not exist.");
        }
    }
    private static Room findRoomByNumber(int roomNumber) {
        for (Room room : rooms) {
            if (room.getRoomNumber() == roomNumber) {
                return room;
            }
        }
        return null;
    }
    private static double calculateReservationCost(Room room, LocalDate checkInDate, LocalDate checkOutDate) {
        long numberOfDays = ChronoUnit.DAYS.between(checkInDate, checkOutDate);
        double costPerNight = room.getCost();
        return numberOfDays * costPerNight;
    }
    private static void makePayment(Guest guest) {
        System.out.println("\nMake Payment:");
        System.out.println("Unpaid Reservations:");
        boolean hasUnpaidReservations = false;
        for (Reservation reservation : reservations) {
            if (reservation.getGuestName().equals(guest.getName()) && !reservation.isPaymentStatus()) {
                System.out.println(reservation);
                hasUnpaidReservations = true;
            }
        }
        if (!hasUnpaidReservations) {
            System.out.println("No unpaid reservations found.");
            return;
        }
        System.out.print("Enter the room number of the reservation to pay for: ");
        int roomNumber = scanner.nextInt();
        scanner.nextLine(); 
        Reservation selectedReservation = null;
        for (Reservation reservation : reservations) {
            if (reservation.getGuestName().equals(guest.getName()) && reservation.getRoom().getRoomNumber() == roomNumber) {
                selectedReservation = reservation;
                break;
            }
        }
        if (selectedReservation != null && !selectedReservation.isPaymentStatus()) {
            selectedReservation.makePayment();
            System.out.println("Payment successful for reservation:\n" + selectedReservation);
        } else {
            System.out.println("Invalid reservation selection or reservation is already paid.");
        }
    }
    private static void viewGuestReservations(Guest guest) {
        System.out.println("\nGuest Reservations:");
        boolean foundReservations = false;
        for (Reservation reservation : reservations) {
            if (reservation.getGuestName().equals(guest.getName())) {
                System.out.println(reservation);
                foundReservations = true;
            }
        }
        if (!foundReservations) {
            System.out.println("No reservations found for this guest.");
        }
    }
    public static void placeOrder(Guest guest, Menu menu) {
        Order order = new Order(guest.getName());
        boolean addingItems = true;
        while (addingItems) {
            System.out.println("Available items:");
            menu.displayVegMenu();
            menu.displayNonVegMenu();
            System.out.print("Enter item name to add (or 'done' to finish): ");
            String itemName = scanner.nextLine();
            if (itemName.equalsIgnoreCase("done")) {
                addingItems = false;
            } else {
                if (menu.isItemAvailable(itemName)) {
                    System.out.print("Enter quantity: ");
                    int quantity = scanner.nextInt();
                    scanner.nextLine(); // Consume newline after nextInt()
    
                    order.addItem(itemName, quantity, menu);
                } else {
                    System.out.println("Item not available in the menu: " + itemName);
                }
            }
        }
        guest.placeOrder(order);
    }
    private static void makeOrderPayment(Guest guest) {
        System.out.println("\nMake Order Payment:");
        System.out.println("Orders for " + guest.getName() + ":");
        List<Order> orders = guest.getOrders();
        if (orders.isEmpty()) {
            System.out.println("No orders found for " + guest.getName());
            return;
        }
        for (Order order : orders) {
            System.out.println("Order ID: " + order.getOrderId() + ", Total Cost: Rs" + order.getTotalCost() + ", Payment Status: " + (order.isPaymentStatus() ? "Paid" : "Not Paid"));
        }
        System.out.print("Enter the Order ID to make payment: ");
        int orderId = scanner.nextInt();
        scanner.nextLine(); 
        Order orderToPay = null;
        for (Order order : orders) {
            if (order.getOrderId() == orderId) {
                orderToPay = order;
                break;
            }
        }
        if (orderToPay != null && !orderToPay.isPaymentStatus()) {
            orderToPay.setPaymentStatus(true); 
            System.out.println("Payment successful for Order ID: " + orderId);
        } else {
            System.out.println("Payment unsuccessful. Either the order does not exist or it is already paid.");
        }
    }
    private static LocalDate getValidDate(String message) {
        LocalDate date = null;
        boolean valid = false;
        while (!valid) {
            try {
                System.out.print(message);
                date = LocalDate.parse(scanner.nextLine());
                if (date.isBefore(LocalDate.now())) {
                    System.out.println("Date must be today or a future date.");
                } else {
                    valid = true;
                }
            } catch (DateTimeParseException e) {
                System.out.println("Invalid date format. Please enter a valid date (yyyy-mm-dd).");
            }
        }
        return date;
    }
    private static void showFeedbackForm(Guest guest) {
        SwingUtilities.invokeLater(() ->  {
            JFrame frame = new JFrame("Feedback Form");
            frame.setSize(400, 300);
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.setLayout(new BorderLayout());
    
            JPanel panel = new JPanel();
            panel.setLayout(new GridBagLayout());
            panel.setBorder(new EmptyBorder(20, 20, 20, 20));
    
            GridBagConstraints constraints = new GridBagConstraints();
            constraints.anchor = GridBagConstraints.WEST;
            constraints.insets = new Insets(5, 5, 5, 5);
    
            JLabel titleLabel = new JLabel("Guest Feedback Form");
            titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
            constraints.gridx = 0;
            constraints.gridy = 0;
            constraints.gridwidth = 2;
            panel.add(titleLabel, constraints);
    
            JLabel nameLabel = new JLabel("Guest Name:");
            constraints.gridx = 0;
            constraints.gridy = 1;
            constraints.gridwidth = 1;
            panel.add(nameLabel, constraints);
    
            JLabel nameLabelValue = new JLabel(guest.getName()); 
            constraints.gridx = 1;
            panel.add(nameLabelValue, constraints);
    
            JLabel ratingLabel = new JLabel("Rating (1-5):");
            constraints.gridx = 0;
            constraints.gridy = 2;
            panel.add(ratingLabel, constraints);
    
            JTextField ratingField = new JTextField(10);
            constraints.gridx = 1;
            panel.add(ratingField, constraints);
    
            JLabel commentsLabel = new JLabel("Comments:");
            constraints.gridx = 0;
            constraints.gridy = 3;
            panel.add(commentsLabel, constraints);
    
            JTextArea commentsArea = new JTextArea(5, 20);
            JScrollPane scrollPane = new JScrollPane(commentsArea);
            constraints.gridx = 1;
            panel.add(scrollPane, constraints);
    
            JButton submitButton = new JButton("Submit Feedback");
            submitButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String ratingText = ratingField.getText();
                    int rating = 0;
                    try {
                        rating = Integer.parseInt(ratingText);
                        if (rating < 1 || rating > 5) {
                            JOptionPane.showMessageDialog(frame, "Rating must be between 1 and 5.");
                            return;
                        }
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(frame, "Please enter a valid integer for rating.");
                        return;
                    }
    
                    String comments = commentsArea.getText();
                    Feedback feedback = new Feedback(guest.getName(), rating, comments);
                    writeFeedbackToFile(feedback);
                    JOptionPane.showMessageDialog(frame, "Thank you for your feedback!");
                    frame.dispose(); 
                }
            });
            constraints.gridx = 1;
            constraints.gridy = 4;
            panel.add(submitButton, constraints);
    
            frame.add(panel, BorderLayout.CENTER);
            frame.setVisible(true);
        });
    }
    private static void writeFeedbackToFile(Feedback feedback) {
        String fileName = "feedback.txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            writer.write("Guest: " + feedback.getGuestName() + "\n");
            writer.write("Rating: " + feedback.getRating() + "\n");
            writer.write("Comments: " + feedback.getComments() + "\n");
            writer.write("----------------------------------------\n");
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Failed to save feedback to file.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }    
}        