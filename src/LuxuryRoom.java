public class LuxuryRoom extends Room{
    public LuxuryRoom(String roomNum, double price, boolean wifi, boolean breakfast) {
        super(roomNum, price, wifi, breakfast); // call the superclass constructor
    }

    // The override method for getting the specifications of the luxury room
    @Override
    public String getSpecifications() {
        return "Luxury room with " + (hasWifi() ? "wifi" : "no wifi") + " and " + (hasBreakfast() ? "breakfast" : "no breakfast");
    }
}
