public class Guest extends Person{
    public static int counter =1;
    private static int  ssn=12434001;
    public Guest(){
        ssn++;
        counter++;
    }
    public int getSSN(){
        return this.ssn;
    }
    @Override
    public String getContent(){
        StringBuilder content= new StringBuilder();
        content.append(getSSN()).append(" , ");
        content.append(getName()).append(" , ");
        content.append(getEmail()).append(" , ");
        content.append(getAddress());
        return content.toString();
    }
    @Override
    public String toString(){
        return this.getName();
    }
}
