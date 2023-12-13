public class Employee extends Person {

    private String position;
    private double salary;
    private static  int SSnn=FileHandler.nOofLines(MainPage.empFile);
    public static int counter =0;

    Employee(){
        SSnn++;
        counter++;
    }
    public int getSSn(){
        return this.SSnn;
    }
    public void setSalary(double salary){
        this.salary=salary;
    }
    public void setPosition(String position){

            this.position=position;

    }
    @Override
    public String getContent(){
       StringBuilder content= new StringBuilder();
       content.append(getSSn()).append(" , ");
       content.append(getName()).append(" , ");
       content.append(getEmail()).append(" , ");
       content.append(getAddress()).append(" , ");
       content.append(this.position).append(" , ");
       content.append(this.salary);
    return content.toString();
    }
    @Override
    public String toString(){
        return this.getName();
    }
    public void setRoomStatus(boolean status,Room target){
        target.setAvailable(status);
    }
}
