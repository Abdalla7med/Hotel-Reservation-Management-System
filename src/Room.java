public class Room {
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




}
