import java.text.DateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;

public class Reservation {
    private static final String path="D:\\Pl2\\Project\\Hotel Reservation Management System\\TXT files\\Reservations.txt";
    //formatter to set values for checkIn checkOut ("11-12-2020 19:30:45")
    private final DateTimeFormatter formatter= DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
    private String ReservationId;
    private LocalDateTime check_in=null;
    private LocalDateTime check_out=null;
    private String Room_no;
    private String GuestId;

    private void setReservationId(String reservationId) {
        ReservationId = reservationId;
    }

    private void setCheck_in(LocalDateTime check_in) {
        this.check_in = check_in;
    }

    private void setCheck_out(LocalDateTime check_out) {
        this.check_out = check_out;
    }

    private void setRoom_no(String room_no) {
        Room_no = room_no;
    }

    private void setGuestId(String guestId) {
        GuestId = guestId;
    }

    private void setStatus(boolean status) {
        this.status = status;
    }

    private boolean status; // true indicate that reservation still , false mean that Guest checkout either in date or before end his duration

    public Reservation(){
      Scanner in=new Scanner(System.in);
      System.out.println("--------------------Reservation Page--------------------");
      System.out.print("enter your id : "); String id=in.nextLine(); this.setGuestId(id);
      System.out.print("enter Room number : "); String no=in.nextLine(); this.setRoom_no(no);
      System.out.print("need Wifi  ?  "); boolean wifi=in.nextBoolean(); System.out.print("\n");
      System.out.print("need breakfast ?  "); boolean breakfast=in.nextBoolean(); System.out.print("\n");
      double price= 100+ (wifi?10:0 )+ (breakfast?15:0);
      RegularRoom room=new RegularRoom(price,wifi,breakfast);
      System.out.print("enter checkout date : "); String checkout=in.nextLine();
      this.check_in=LocalDateTime.now();
      this.setCheck_out(LocalDateTime.parse(checkout,formatter));
    }
    public void makeReservation(){

    }

    public LocalDateTime getCheck_in() {
        return this.check_in;
    }

    public LocalDateTime getCheck_out() {
        return this.check_out;
    }

    public String getReservationId() {
        return this.ReservationId;
    }
    public boolean validateCheckIn(){
        return check_in==null;
    }
    public void ValidateCheckout(){

    }
    public void validateCheckOut(){
        if(check_out==null){
            System.out.println("enter checkout date in form dd-MM-YYYY HH:mm:ss");
        }
    }

}
