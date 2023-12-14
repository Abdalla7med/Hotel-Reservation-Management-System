abstract class Person {
    private String name;
    private String email;
    private String Address;
    private String id;
    public Person(){

    }
    public Person(String id,String name,String email,String Address){
        this.setId(id);
        this.setName(name);
        this.setEmail(email);
        this.setAddress(Address);
    }
    public void setId(int id){
        this.id=String.valueOf(id);
    }
    public void setId(String id){
        this.id=id;
    }
    public String getId(){
        return this.id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }
    public abstract String getContent();

}
