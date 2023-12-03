import java.io.*;

public class Receptionist extends Person{
    public Receptionist(String[]values){
        super.setName(values[0]);
        super.setEmail(values[1]);
        super.setPhone(values[2]);
        super.setAddress(values[3]);
        super.setSSnn(values[4]);
    }
    private static File file=null;
    public  void add_Employee(Employee employee){
       file= new File("D:\\Pl2\\Project\\Hotel Reservation Management System\\TXT files\\Employees.txt");
        try (FileWriter writer= new FileWriter(file,true);){
            writer.write(employee.getName()+","); // 0
            writer.write(employee.getSSnn()+",");  // 1
            writer.write(employee.getEmail()+","); //2
            writer.write(employee.getPhone()+",");  //3
            writer.write(employee.getAddress()); //4
            writer.write("\n");
        } catch (IOException e) {
            System.out.println("can't deal with this file");
        }

    }

    public  boolean delete_Employee(String name){


        File db = new File("D:\\Pl2\\Project\\Hotel Reservation Management System\\TXT files\\Employees.txt");
        if(db.length()<=0){
            System.out.println("No Employees exist");
            return false;
        }
        File tempDB = new File("D:\\Pl2\\Project\\Hotel Reservation Management System\\TXT files\\temp.txt");
        String record;
   try(BufferedReader br = new BufferedReader( new FileReader(db) );
        BufferedWriter bw = new BufferedWriter( new FileWriter( tempDB ) )){

       tempDB.createNewFile();
       while( ( record = br.readLine() ) != null ) {
           if( record.contains(name) )
               continue;

           bw.write(record);
           bw.flush();
           bw.newLine();
       }

       br.close();
       bw.close();
       db.delete();
       tempDB.renameTo(db);

   } catch (IOException e) {
      System.out.println("can't deal with this file");
      return false;
   }
   return true;
}
    public  void add_Room(Room room){
        // one line in file contains room info and next of contains its services
     file=new File("D:\\Pl2\\Project\\Hotel Reservation Management System\\TXT files\\Rooms.txt");
     try(FileWriter writer= new FileWriter(file,true)){
         writer.write(room.getNo()+","); // 0
         writer.write(room.getPrice()+",");  // 1
         if(room.isAvaliable()) {
             writer.write("status : Available" + ","); //2
         }
         writer.write("\n");
         for(Service service: room.getServices()) {
             writer.write(service.getName() + ",");
         }

         writer.write("\n");
     }catch(IOException e){
         System.out.println("can't deal with this file");
     }

    }
    public  boolean delete_Room(String Room_NO){
        File db = new File("D:\\Pl2\\Project\\Hotel Reservation Management System\\TXT files\\Rooms.txt");
        if(db.length()<=0){
            System.out.println("No Rooms exist");
            return false;
        }
        File tempDB = new File("D:\\Pl2\\Project\\Hotel Reservation Management System\\TXT files\\temp.txt");
        String record;
        try(BufferedReader br = new BufferedReader( new FileReader(db) );
            BufferedWriter bw = new BufferedWriter( new FileWriter( tempDB ) )){

            tempDB.createNewFile();
            while( ( record = br.readLine() ) != null ) {
                if( record.contains(Room_NO) ) {
                    record = br.readLine();  // to read services line
                    continue;
                }
                bw.write(record);
                bw.flush();
                bw.newLine();
            }

            br.close();
            bw.close();
            db.delete();
            tempDB.renameTo(db);

        } catch (IOException e) {
            System.out.println("can't deal with this file");
            return false;
        }
        return true;
    }
    public  void add_Guest(Guest guest){
       file= new File("Guest.txt");

    }

    public  void delete_Guest(Guest guest){
        file=new File("Guest.txt");

    }

}

