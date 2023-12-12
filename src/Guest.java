public class Guest extends Person{
    public static int counter =1;
    public Guest(){
        counter++;
    }
    @Override
    public String getContent(){
        StringBuilder content= new StringBuilder();
        content.append(getSSnn()).append(" , ");
        content.append(getName()).append(" , ");
        content.append(getEmail()).append(" , ");
        content.append(getAddress());
        return content.toString();
    }
}
