import java.util.List;
import java.util.Scanner;

public class MainPage {
    // System files
    public static final String empFile="D:\\Pl2\\Project\\Hotel Reservation Management System\\TXT files\\Employees.txt";
    public static final String guestFile="D:\\Pl2\\Project\\Hotel Reservation Management System\\TXT files\\Guest.txt";
    public static final String RoomFile="D:\\Pl2\\Project\\Hotel Reservation Management System\\TXT files\\Rooms.txt";
    public static final String ServiceFile="D:\\Pl2\\Project\\Hotel Reservation Management System\\TXT files\\Services.txt";
    public static final String tempFile="D:\\Pl2\\Project\\Hotel Reservation Management System\\TXT files\\Temp.txt";
    // only one admin in our system (Receptionist)
    private final static Administrator Admin=new Administrator("Admin");
    //breaking encapsulation to use it in authorization in login and other related methods
    public final static String pass="admin101";
    private static Scanner in=new Scanner(System.in);

    public static void main(String[] args) {

        /// login or register
        System.out.println("a.login b.Register");
        char c=in.nextLine().charAt(0);
        if(c=='a'||c=='l') {
            System.out.println("login as : ");
            System.out.print("a.Admin b.Employee b.Guest");
            c = in.nextLine().charAt(0);
             if (c == 'a' || c == 'A') {
                while(true) {
                    System.out.println("enter password : ");
                    String p = in.nextLine();
                    // access static member -- make it static to make it available throw System form main
                    if (p.equals(MainPage.pass)) {
                        System.out.println("Welcome Our Administrator"); break;
                    } else {
                        System.out.println("Incorrect pass");
                    }
                }
            }else if (c == 'E' || c == 'b') {
                new login(empFile);

            }else {
                new login(guestFile);
            }
        }else{
            Admin.addGuest();
        }

       
    }


    // end Room Management
}