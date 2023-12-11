public class test {
    // The abstract Room class
    public abstract class Room {
        // The fields for room number, price, status, and services
        private int roomNum;
        private double price;
        private boolean available;
        private boolean wifi;
        private boolean breakfast;

        // The constructor for the Room class
        public Room(int roomNum, double price, boolean wifi, boolean breakfast) {
            this.roomNum = roomNum;
            this.price = price;
            this.available = true; // assume all rooms are available by default
            this.wifi = wifi;
            this.breakfast = breakfast;
        }

        // The getters and setters for the fields
        public int getRoomNum() {
            return roomNum;
        }

        public void setRoomNum(int roomNum) {
            this.roomNum = roomNum;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public boolean isAvailable() {
            return available;
        }

        public void setAvailable(boolean available) {
            this.available = available;
        }

        public boolean hasWifi() {
            return wifi;
        }

        public void setWifi(boolean wifi) {
            this.wifi = wifi;
        }

        public boolean hasBreakfast() {
            return breakfast;
        }

        public void setBreakfast(boolean breakfast) {
            this.breakfast = breakfast;
        }

        // The abstract method for getting the specifications of the room
        public abstract String getSpecifications();
    }

    // The RegularRoom subclass
    public class RegularRoom extends Room {
        // The constructor for the RegularRoom class
        public RegularRoom(int roomNum, double price, boolean wifi, boolean breakfast) {
            super(roomNum, price, wifi, breakfast); // call the superclass constructor
        }

        // The override method for getting the specifications of the regular room
        @Override
        public String getSpecifications() {
            return "Regular room with " + (hasWifi() ? "wifi" : "no wifi") + " and " + (hasBreakfast() ? "breakfast" : "no breakfast");
        }
    }

    // The LuxuryRoom subclass
    public class LuxuryRoom extends Room {
        // The constructor for the LuxuryRoom class
        public LuxuryRoom(int roomNum, double price, boolean wifi, boolean breakfast) {
            super(roomNum, price, wifi, breakfast); // call the superclass constructor
        }

        // The override method for getting the specifications of the luxury room
        @Override
        public String getSpecifications() {
            return "Luxury room with " + (hasWifi() ? "wifi" : "no wifi") + " and " + (hasBreakfast() ? "breakfast" : "no breakfast");
        }
    }

    // The CelebrityRoom subclass
    public class CelebrityRoom extends Room {
        // The constructor for the CelebrityRoom class
        public CelebrityRoom(int roomNum, double price, boolean wifi, boolean breakfast) {
            super(roomNum, price, wifi, breakfast); // call the superclass constructor
        }

        // The override method for getting the specifications of the celebrity room
        @Override
        public String getSpecifications() {
            return "Celebrity room with " + (hasWifi() ? "wifi" : "no wifi") + " and " + (hasBreakfast() ? "breakfast" : "no breakfast");
        }
    }

    // The Hotel class
    public class Hotel {
        // The field for the list or map of rooms
        private List<Room> rooms;

        // The constructor for the Hotel class
        public Hotel() {
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

    // The main method for testing
    public static void main(String[] args) {
        // Create a hotel object
        Hotel hotel = new Hotel();

        // Create some room objects
        Room r1 = new RegularRoom(101, 100, true, false);
        Room r2 = new RegularRoom(102, 100, false, true);
        Room r3 = new LuxuryRoom(201, 200, true, true);
        Room r4 = new LuxuryRoom(202, 200, false, false);
        Room r5 = new CelebrityRoom(301, 300, true, true);

        // Add the rooms to the hotel
        hotel.addRoom(r1);
        hotel.addRoom(r2);
        hotel.addRoom(r3);
        hotel.addRoom(r4);
        hotel.addRoom(r5);

        // Show all the available rooms in the hotel
        System.out.println("All the available rooms in the hotel:");
        hotel.showAvailableRooms();

        // Book some rooms
        r1.setAvailable(false);
        r3.setAvailable(false);

        // Show all the available rooms in the hotel after booking
        System.out.println("All the available rooms in the hotel after booking:");
        hotel.showAvailableRooms();

        // Create a criteria for filtering rooms


}
