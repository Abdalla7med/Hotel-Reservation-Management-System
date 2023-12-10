public class MainPage {
    // only one admin in our system (Receptionist)
    private final static Administrator Admin=new Administrator("Admin");

    public static void main(String[] args) {
       //  Admin.AddEmployee();
       /* if( Admin.deleteEmployee()){
            System.out.println("deleted successfully ");
        }else{
            System.out.println("can't find employee with this ssn try again...");
        }*/
        if(Admin.updateEmployee()){
            System.out.println("updated successfully");
        }else{
            System.out.println("no employee with this key!!");
        }
    }
}