abstract class Person {
    private String name;
    private String SSnn;
    private String email;
    private String phone;
    private String Address;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSSnn() {
        return SSnn;
    }

    public void setSSnn(String SSnn) {
        this.SSnn = SSnn;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }
    public abstract String getContent();

}
