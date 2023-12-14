public class CelebrityRoom extends Room{

    public CelebrityRoom(){

     super.setRoomNum(IdGenerator.getNextId(MainPage.RoomFile));
    }
    // The constructor for the CelebrityRoom class
    public CelebrityRoom( double price, boolean wifi, boolean breakfast) {
        super(String.valueOf(IdGenerator.getNextId(MainPage.RoomFile)), price, wifi, breakfast); // call the superclass constructor
    }

    // The override method for getting the specifications of the celebrity room
    @Override
    public String getSpecifications() {
        return "Celebrity room with " + (hasWifi() ? "wifi" : "no wifi") + " and " + (hasBreakfast() ? "breakfast" : "no breakfast");
    }
}

