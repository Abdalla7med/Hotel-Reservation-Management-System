public class Guest extends Person{

    public Guest(){

        super.setId(IdGenerator.getNextId(MainPage.guestFile));
    }
    public Guest(String id,String name,String email,String Address){

        super(String.valueOf(IdGenerator.getNextId(MainPage.guestFile)),name,email,Address);
    }

    @Override
    public String getContent(){
        StringBuilder content= new StringBuilder();
        content.append(getId()).append(" , ");
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
