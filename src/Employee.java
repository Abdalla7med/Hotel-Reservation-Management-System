public class Employee extends Person {

    private String position;
    private double salary;
    public static int counter =0;
    Employee(){
        counter++;
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
       content.append(getSSnn()).append(" , ");
       content.append(getName()).append(" , ");
       content.append(getEmail()).append(" , ");
       content.append(getPhone()).append(" , ");
       content.append(getAddress()).append(" , ");
       content.append(this.position).append(" , ");
       content.append(this.salary).append(" , ");
    return content.toString();
    }
    public void setRoomStatus(boolean status,Room target){
        target.setAvailable(status);
    }
}
