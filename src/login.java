import java.util.Scanner;

public class login {
    Scanner in=new Scanner(System.in);
    FileHandler handler=new FileHandler();
    public login(){}
    public login(String file){
         System.out.print("enter Id: "); String id=in.nextLine();
         if(handler.Exist(file,id)) {
             String line = handler.CertainRecord(file, id);
             if (line.contains(",")) {
                 String[] data = line.split(",");
                 System.out.println("Welcome " + data[1].trim());
             }
         }else {
             System.out.println("Incorrect Id");
         }
      }
} // end of class
