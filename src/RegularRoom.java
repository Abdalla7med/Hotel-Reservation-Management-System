public class RegularRoom extends Room{

    public RegularRoom(){

        super.setRoomNum(IdGenerator.getNextId(MainPage.RoomFile));
    }
    public RegularRoom( double price, boolean wifi, boolean breakfast) {
        super(String.valueOf(IdGenerator.getNextId(MainPage.RoomFile)), price, wifi, breakfast); // call the superclass constructor
    }

    // The override method for getting the specifications of the regular room
    // getSpecification differ from getContent because getSpecification used to filter room only we can use getSpecification in getContent method
    // but just to keep it simple and separate each task
    @Override
    public String getSpecifications() {
        return "Regular room with " + (hasWifi() ? "wifi" : "no wifi") + " and " + (hasBreakfast() ? "breakfast" : "no breakfast");
    }
}
