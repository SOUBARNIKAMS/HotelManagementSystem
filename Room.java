import java.util.ArrayList;

public class Room {
    private int room_number;
    private int room_capacity;
    private String room_type;
    private boolean occupancy_status;
    private ArrayList<String> amenities;
    private final double cost;

    public Room(int room_number, String room_type, boolean occupancy_status, String amenity) {
        this.room_number = room_number;
        this.room_type = room_type;
        this.occupancy_status = occupancy_status;
        this.amenities = new ArrayList<>();
        this.amenities.add(amenity);
        this.room_capacity = setRoomCapacityByType(room_type);
        this.cost = setCostByType(room_type);
    }

    private int setRoomCapacityByType(String room_type) {
        switch (room_type.toLowerCase()) {
            case "single":
                return 1;
            case "double":
            case "twin":
                return 2;
            case "suite":
                return 3;
            case "family":
                return 5;
            default:
                return 2;
        }
    }

    private double setCostByType(String room_type) {
        switch (room_type.toLowerCase()) {
            case "single":
                return 7500.0; 
            case "double":
            case "twin":
                return 9000.0; 
            case "suite":
                return 15000.0; 
            case "family":
                return 18750.0; 
            default:
                return 9000.0; 
        }
    }

    public int getRoomNumber() {
        return room_number;
    }

    public void setRoomNumber(int room_number) {
        this.room_number = room_number;
    }

    public int getRoomCapacity() {
        return room_capacity;
    }

    public void setRoomCapacity(int room_capacity) {
        this.room_capacity = room_capacity;
    }

    public String getRoomType() {
        return room_type;
    }

    public void setRoomType(String room_type) {
        this.room_type = room_type;
    }

    public boolean isOccupied() {
        return occupancy_status;
    }

    public void setRoomStatus(boolean occupancy_status) {
        this.occupancy_status = occupancy_status;
    }

    public void addRoomAmenity(String amenity) {
        amenities.add(amenity);
    }

    public ArrayList<String> getRoomAmenities() {
        return amenities;
    }

    public double getCost() {
        return cost;
    }

    @Override
    public String toString() {
        return "Room Number: " + room_number +
               "\nRoom Capacity: " + room_capacity +
               "\nRoom Type: " + room_type +
               "\nOccupancy Status: " + (occupancy_status ? "Occupied" : "Vacant") +
               "\nAmenities: " + (amenities.size() == 1 ? amenities.get(0) : amenities) +
               "\nCost: " + cost;
    }
}
