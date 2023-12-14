public class Employee extends Person {

    private String position;
    private double salary;

    public Employee(){
       super.setId(IdGenerator.getNextId(MainPage.empFile));
    }
    public  Employee(String id,String name,String email,String Address){
        super(id,name,email,Address);
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
       content.append(getId()).append(" , ");
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
