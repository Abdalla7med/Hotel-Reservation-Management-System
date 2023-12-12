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
        char c = in.nextLine().charAt(0);
        if (c == 'a' || c == 'l') {
            System.out.print("a.Admin b.Employee ");
            c = in.nextLine().charAt(0);
            if (c == 'a' || c == 'A') {
                while (true) {
                    System.out.println("enter password : ");
                    String p = in.nextLine();
                    // access static member -- make it static to make it available throw System form main
                    if (p.equals(MainPage.pass)) {
                        System.out.println("Welcome Our Administrator");
                        break;
                    } else {
                        System.out.println("Incorrect pass");
                    }
                }
                // menu for Admin
                System.out.println("what you will do this day--------------");
                int choice;
                // Declare a variable for the exit condition
                boolean exit = false;
                // Use a do-while loop to repeat the menu until the user chooses to exit
                do {
                    // Display the menu options to the user
                    System.out.println("Menu:");
                    System.out.println("1) Add employee");
                    System.out.println("2) Delete employee");
                    System.out.println("3) Update employee");
                    System.out.println("4) Add room");
                    System.out.println("6) Delete room");
                    System.out.println("7) Update room");
                    System.out.print("8) Exit");
                    choice = in.nextInt();
                    // Use a switch statement to execute the corresponding actions based on the user choice
                    switch (choice) {
                        case 1:
                            // Call the method to add an employee
                            Admin.AddEmployee();
                            break;
                        case 2:
                            // Call the method to delete an employee
                            Admin.deleteEmployee();
                            break;
                        case 3:
                            // Call the method to update an employee
                            Admin.updateEmployee();
                            break;
                        case 4:
                            // Call the method to add a room
                            Admin.addRoom();
                            break;
                        case 6:
                            // Call the method to delete a room
                            Admin.deleteRoom();

                            break;
                        case 7:
                            // Call the method to update a room
                            Admin.updateRoom();
                            break;
                        case 8:
                            // Set the exit condition to true
                            exit = true;
                            // Print a farewell message
                            System.out.println("Thank you for using the program. Goodbye.");
                            break;
                        default:
                            // Print an error message
                            System.out.println("Invalid choice. Please try again.");
                            break;
                    }
                } while (!exit); // Repeat the loop until the exit condition is true
            }else {
              new login(empFile);
            }
        }else{
            // Register for Guest only
            Admin.addGuest();

        }

    }
}