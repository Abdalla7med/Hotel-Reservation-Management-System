import java.io.*;
import java.util.*;

public class Administrator extends Person{
    private static final String empFile="D:\\Pl2\\Project\\Hotel Reservation Management System\\TXT files\\Employees.txt";
    private static final String guestFile="D:\\Pl2\\Project\\Hotel Reservation Management System\\TXT files\\Guest.txt";
    private static final String RoomFile="D:\\Pl2\\Project\\Hotel Reservation Management System\\TXT files\\Rooms.txt";
    private static final String ServiceFile="D:\\Pl2\\Project\\Hotel Reservation Management System\\TXT files\\Services.txt";
    private static final String tempFile="D:\\Pl2\\Project\\Hotel Reservation Management System\\TXT files\\Temp.txt";


    public Administrator(){}
    public Administrator(String name){
        if("Admin".equals(name)||"admin".equals(name))
             this.setName(name);
        else
            this.setName("Admin");

    }
    public void SetName(String name){
        if("Admin".equals(name)||"admin".equals(name)) {

        }else
            System.out.println("please enter correct name");
    }
    @Override
    public String getContent() {
        return this.getName();
    }


    // Employee Section
    public void AddEmployee(){
        FileHandler fileHandler=new FileHandler(Administrator.empFile);
        Scanner Sc= new Scanner(System.in);
        Employee employee= new Employee();
        System.out.print("enter employee name: ");
        String name=Sc.nextLine();
        employee.setName(name);
        System.out.print("enter employee address : ");
        String address=Sc.nextLine();
        employee.setAddress(address);
        System.out.print("enter employee email : ");
        String email=Sc.nextLine();
        employee.setEmail(email);
        System.out.print("enter employee position : ");
        String position=Sc.nextLine();
        employee.setPosition(position);  // this function need Administrator as second parameter
        this.setEmployeeSalary(employee,3200);
        String content=employee.getContent();
        fileHandler.writeToFile(Administrator.empFile,content);
    }

    public boolean deleteEmployee() {
        String ssn;
        System.out.print("enter employee ssn : ");
        Scanner sc=new Scanner(System.in);
        ssn=sc.nextLine();
        File sfile=new File(Administrator.empFile);
        File temp = new File(Administrator.tempFile);
        boolean founded=false;
        // add this to try to auto close it after end try block
        try (
            BufferedReader reader = new BufferedReader(new FileReader(sfile));
            BufferedWriter writer=new BufferedWriter(new FileWriter(temp))){
            String line=null;
            while((line=reader.readLine())!=null){
                String []data= line.split(",");
                if(data[0].trim().equals(ssn)){
                     founded=true;
                    continue;
                }
                writer.write(line);
                writer.flush();
                writer.newLine();
            }
            // to save changes before deleting and renaming files
            writer.close();
            reader.close();
            // change files
            sfile.delete();
            temp.renameTo(sfile);
        }catch(IOException ioe){
            System.out.println("can't deal with this file");
        }
        return founded;
    }

    public boolean updateEmployee() {
        Scanner sc = new Scanner(System.in);
        FileHandler fileHandler = new FileHandler();
        System.out.print("enter employee ssn : ");
        String ssn = sc.nextLine();
        String line;
        String[]data;
        String newLine = null;
        boolean founded=false;
        try (BufferedReader reader = new BufferedReader(new FileReader(Administrator.empFile))) {
            while ((line = reader.readLine()) != null) {
                data=line.split(",");
                if (data[0].trim().equals(ssn)) {
                    Employee employee = new Employee();
                    // these data isn't expected to be updated employee won't change his name (:
                    employee.setName(data[1]);
                    System.out.print("enter employee new address : ");
                    String address = sc.nextLine();
                    employee.setAddress(address);
                    System.out.print("enter employee new email : ");
                    String email = sc.nextLine();
                    employee.setEmail(email);
                    System.out.print("enter employee new position : ");
                    String position = sc.nextLine();
                    employee.setPosition(position);
                    System.out.print("enter employee new salary");
                    double salary = sc.nextDouble();
                    this.setEmployeeSalary(employee, salary);
                    newLine = employee.getContent();
                    fileHandler.updateRecord(Administrator.empFile, line, newLine);
                    founded = true;
                    break;
                }
            }
        } catch (IOException e) {
            System.out.println("can't deal with this file");
        }
        File source=new File(empFile);
        File temp=new File(tempFile);
        try (BufferedReader reader = new BufferedReader(new FileReader(source));
             BufferedWriter writer = new BufferedWriter(new FileWriter(temp))) {
            while ((line = reader.readLine()) != null) {
                if (line.equals(line)) {
                    writer.write(newLine);
                    writer.flush();
                    writer.newLine();
                    continue;
                }
                writer.write(line);
                writer.flush();
                writer.newLine();
            }
            // need to close first because you can't modify file while it's in use
            writer.close();
            reader.close();
            // delete original and rename temp to its name
            source.delete();
            temp.renameTo(source);
        } catch (IOException e) {
            System.out.println("can't deal with this file");
        }
      return founded;
    }



    // Room Section
    public void addRoom(){
        FileHandler handler= new FileHandler();
        RegularRoom room= new RegularRoom();
        try {
            Scanner sc = new Scanner(System.in);
            System.out.print("enter Room Price ");
            double price = sc.nextDouble();
            room.setPrice(price);
            System.out.print("has wifi?  "); boolean wifi=sc.nextBoolean();
            room.setWifi(wifi);
            System.out.println("has breakfast?  "); boolean breakfast=sc.nextBoolean();
            room.setBreakfast(breakfast);
            // this include all IntputMismatch , NosuchElement , and IllegalStata Exceptions
        }catch(Exception e1){
            System.out.println("please enter data in correct form");
        }
     handler.writeToFile(RoomFile,room.getContent());
    }
    public boolean deleteRoom(){
        String Id;
        System.out.print("enter Room Id : ");
        Scanner sc=new Scanner(System.in);
        Id=sc.nextLine();
        File sfile=new File(RoomFile);
        File temp = new File(tempFile);
        boolean founded=false;
        // add this to try to auto close it after end try block
        try (   BufferedReader reader = new BufferedReader(new FileReader(sfile));
                BufferedWriter writer=new BufferedWriter(new FileWriter(temp))){
            String line;
            while((line=reader.readLine())!=null){
                String []data= line.split(",");
                if(data[0].trim().equals(Id)){
                    founded=true;
                    continue;
                }
                writer.write(line);
                writer.flush();
                writer.newLine();
            }
            // to save changes before deleting and renaming files
            writer.close();
            reader.close();
            // change files
            sfile.delete();
            temp.renameTo(sfile);
        }catch(IOException ioe){
            System.out.println("can't deal with this file");
        }
        return founded;
    }

    public boolean updateRoom(){
        Scanner sc = new Scanner(System.in);
        System.out.print("enter Room Number :");
        String Id = sc.nextLine();
        String line;
        String newLine = null;
        boolean founded=false;
        try (BufferedReader reader = new BufferedReader(new FileReader(RoomFile))) {
            while ((line = reader.readLine()) != null) {
                if (line.contains(Id)){
                    String[]data=line.split(",");
                    Room room= new RegularRoom();
                    room.setRoomNum(data[0]);
                    System.out.print("enter Room Price : "); double price=sc.nextDouble();
                    room.setPrice(price);
                    System.out.println("has wifi : "); boolean wifi=sc.nextBoolean(); room.setWifi(wifi);
                    System.out.println("has breakfast : "); boolean breakfast=sc.nextBoolean(); room.setBreakfast(breakfast);
                    room.setAvailable(true);  // room is available while no reservation is done
                   newLine=room.getContent();
                }
            }
        } catch (IOException e) {
            System.out.println("can't deal with this file");
        }
        File source=new File(RoomFile);
        File temp=new File(tempFile);
        try (BufferedReader reader = new BufferedReader(new FileReader(source));
             BufferedWriter writer = new BufferedWriter(new FileWriter(temp))) {
            while ((line = reader.readLine()) != null) {
                if (line.equals(line)) {
                    writer.write(newLine);
                    writer.flush();
                    writer.newLine();
                    continue;
                }
                writer.write(line);
                writer.flush();
                writer.newLine();
            }
            writer.close();
            reader.close();
            // change files
            source.delete();
            temp.renameTo(source);
        }catch(IOException ioe){
                System.out.println("can't deal with this file ");
        }
        return founded;
    }



    // Customer (Guest module)
    public void addGuest(){
        FileHandler fileHandler=new FileHandler(Administrator.empFile);
        Scanner Sc= new Scanner(System.in);
        Guest guest= new Guest();
        System.out.print("enter Guest name: ");
        String name=Sc.nextLine();
        guest.setName(name);
        System.out.print("enter Guest address : ");
        String address=Sc.nextLine();
        guest.setAddress(address);
        System.out.print("enter Guest email : ");
        String email=Sc.nextLine();
        guest.setEmail(email);
        fileHandler.writeToFile(guestFile,guest.getContent());
        Sc.close();
    }

    public boolean deleteGuest(){
        String ssn;
        System.out.print("enter Guest ssn : ");
        Scanner sc=new Scanner(System.in);
        ssn=sc.nextLine();
        File sfile=new File(Administrator.guestFile);
        File temp = new File(Administrator.tempFile);
        boolean founded=false;
        // add this to try to auto close it after end try block
        try (   BufferedReader reader = new BufferedReader(new FileReader(sfile));
                BufferedWriter writer=new BufferedWriter(new FileWriter(temp))){
            String line;
            while((line=reader.readLine())!=null){
                String []data= line.split(",");
                if(data[0].trim().equals(ssn)){
                    founded=true;
                    continue;
                }
                writer.write(line);
                writer.flush();
                writer.newLine();
            }
            // to save changes before deleting and renaming files
            writer.close();
            reader.close();
            // change files
            sfile.delete();
            temp.renameTo(sfile);
        }catch(IOException ioe){
            System.out.println("can't deal with this file");
        }
        return founded;
    }

    public boolean updateGuest(){
        Scanner sc = new Scanner(System.in);
        FileHandler fileHandler = new FileHandler();
        System.out.print("enter Guest ssn :");
        String ssn = sc.nextLine();
        boolean founded=false;
        try (BufferedReader reader = new BufferedReader(new FileReader(Administrator.guestFile))) {
            String line;
            String newLine;
            while ((line = reader.readLine()) != null) {
                if (line.contains(ssn)) {
                    Scanner Sc= new Scanner(System.in);
                    Guest guest= new Guest();
                    System.out.print("enter Guest name: ");
                    String name=Sc.nextLine();
                    guest.setName(name);
                    System.out.print("enter Guest address : ");
                    String address=Sc.nextLine();
                    guest.setAddress(address);
                    System.out.print("enter Guest email : ");
                    String email=Sc.nextLine();
                    guest.setEmail(email);
                    newLine=guest.getContent();
                    fileHandler.updateRecord(Administrator.empFile, line, newLine);
                    founded = true;
                    sc.close();
                    break;
                }
            }
        } catch (IOException e) {
            System.out.println("can't deal with this file");
        }
        return founded;
    }

    private void setEmployeeSalary(Employee emp,double salary){
        emp.setSalary(salary);
    }
    private void setEmployeePosition(Employee emp,String pos){
        emp.setPosition(pos);
    }
}
