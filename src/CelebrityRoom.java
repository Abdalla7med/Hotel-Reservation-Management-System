public class CelebrityRoom extends Room{
    // The constructor for the CelebrityRoom class
    public CelebrityRoom(String roomNum, double price, boolean wifi, boolean breakfast) {
        super(roomNum, price, wifi, breakfast); // call the superclass constructor
    }

    // The override method for getting the specifications of the celebrity room
    @Override
    public String getSpecifications() {
        return "Celebrity room with " + (hasWifi() ? "wifi" : "no wifi") + " and " + (hasBreakfast() ? "breakfast" : "no breakfast");
    }
}

