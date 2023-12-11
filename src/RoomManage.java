import java.util.ArrayList;
import java.util.List;

public class RoomManage {
    private List<Room> rooms;

    // The constructor for the Hotel class
    public RoomManage() {
        rooms = new ArrayList<>(); // initialize the list of rooms
    }

    // The method for adding a room to the hotel
    public void addRoom(Room room) {
        rooms.add(room); // add the room to the list
    }

    // The method for removing a room from the hotel
    public void removeRoom(Room room) {
        rooms.remove(room); // remove the room from the list
    }

    // The method for showing all the available rooms in the hotel
    public void showAvailableRooms() {
        for (Room room : rooms) { // loop through the list of rooms
            if (room.isAvailable()) { // check if the room is available
                System.out.println("Room number: " + room.getRoomNum()); // print the room number
                System.out.println("Room type: " + room.getSpecifications()); // print the room type and features
                System.out.println("Room price: " + room.getPrice()); // print the room price
                System.out.println(); // print a blank line
            }
        }
    }

    // The method for filtering rooms by status and services
    public List<Room> filterRooms(Room criteria) {
        List<Room> filteredRooms = new ArrayList<>(); // create a new list for the filtered rooms
        for (Room room : rooms) { // loop through the list of rooms
            // check if the room matches the criteria for status and services
            if (room.isAvailable() == criteria.isAvailable() && room.hasWifi() == criteria.hasWifi() && room.hasBreakfast() == criteria.hasBreakfast()) {
                filteredRooms.add(room); // add the room to the filtered list
            }
        }
        return filteredRooms; // return the filtered list
    }

}

