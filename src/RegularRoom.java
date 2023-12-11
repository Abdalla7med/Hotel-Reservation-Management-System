public class RegularRoom extends Room{
    public RegularRoom(){
        super();
    }
    public RegularRoom(String roomNum, double price, boolean wifi, boolean breakfast) {
        super(roomNum, price, wifi, breakfast); // call the superclass constructor
    }

    // The override method for getting the specifications of the regular room
    @Override
    public String getSpecifications() {
        return "Regular room with " + (hasWifi() ? "wifi" : "no wifi") + " and " + (hasBreakfast() ? "breakfast" : "no breakfast");
    }
}
