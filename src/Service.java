public class Service {
    public Service(){}
    public Service(String name,String id,boolean status, double price){
        this.name=name;
        this.id=id;
        this.status=status;
        this.price=price;
    }
    static int use=1; // will be incremented when new object is instantiated


    private String name;
    private boolean status;
    private double price;
    private String id;
    public String getName(){
        return name;
    }
    public String getId(){
        return id;
    }
    public boolean getStatus(){
        return status;
    }
    public double getPrice(){
        return price;
    }
    public void getUsage(){
        System.out.println("this service is used for : "+ use);
        System.out.println("and total benefits of this service is :"+use*price);
    }
}
