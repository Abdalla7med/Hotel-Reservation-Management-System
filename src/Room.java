public abstract class Room {
    // The fields for room number, price, status, and services
    private String roomNum;
    private double price;
    private boolean available;
    private boolean wifi;
    private boolean breakfast;
    public Room(){

    }

    // The constructor for the Room class
    public Room(String roomNum, double price, boolean wifi, boolean breakfast) {
        this.roomNum = roomNum;
        this.price = price;
        this.available = true; // assume all rooms are available by default
        this.wifi = wifi;
        this.breakfast = breakfast;
    }

    // The getters and setters for the fields
    public String getRoomNum() {
        return roomNum;
    }

    public void setRoomNum(String roomNum) {
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
    public String getContent(){
        StringBuilder content= new StringBuilder();
        content.append(roomNum).append(" , ");
        content.append(price).append(" , ");
        content.append(available).append(" , ");
        content.append(wifi?"hasWifi":"noWifi").append(" , ");
        content.append(breakfast?"hasbreakFast":"noBreakFast").append(" , ");
        return content.toString();
    }



    // The abstract method for getting the specifications of the room
    public abstract String getSpecifications();



}
