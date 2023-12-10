public class Room {
    public static int counter=1;
    Room(){
        counter++;
    }
   private String No;
   private boolean status;
   private double price;
   private Service[] services;
    public String getNo() {
        return No;
    }

    public void setNo(String no) {
        No = no;
    }

    public boolean isAvaliable() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Service[] getServices() {
        return services;
    }

    public void setServices(Service[] services) {
        this.services = services;
    }

    // content will be as following
   public String getContent(){
    StringBuilder content= new StringBuilder();
        content.append(No).append(" , ");
        content.append(price).append(" , ");
        content.append("Services { ");
        for(Service ser: services){
            content.append(ser.getContent()).append(" , ");
        }
        content.append(" }\n");
        return content.toString();
   }


}
