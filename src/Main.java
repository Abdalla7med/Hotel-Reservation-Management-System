import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Scanner input= new Scanner(System.in);
     System.out.println("a.Login b.Register");
     char ch= input.nextLine().charAt(0);
     if(ch=='a'){
         new login();
     }else if(ch=='b'){
         new Register();
     }
    }
}