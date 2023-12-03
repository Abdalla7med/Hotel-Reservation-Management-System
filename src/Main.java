// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
     private static final String[] AdminInfo=new String[]{"Admin101","admin@ABM.org","978 7890 234","4455 Landing Lange, APT 4","89848834934321"};
     private static final Receptionist receptionist=new Receptionist(AdminInfo);

    public static void main(String[] args) {
    /*Scanner input= new Scanner(System.in);
     System.out.println("a.Login b.Register");
     char ch= input.nextLine().charAt(0);
     if(ch=='a'){
         new login();
     }else if(ch=='b'){
         Register();
     }*/

     Employee employee=new Employee();
     employee.setName("Basel");
     employee.setEmail("basel23@gamil.com");
     employee.setPhone("0223890323");
     employee.setSSnn("30932899959");
     employee.setAddress("Giza,Egypt");
     //receptionist.add_Employee(employee);
    if(receptionist.delete_Employee("Basel")){
         System.out.println("deleted Successfully");
     }
    }
}