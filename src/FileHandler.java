import java.io.*;
import java.nio.Buffer;

public class FileHandler {
    static File file = null;

    public FileHandler() {
    }

    public FileHandler(String filePath) {
        file = new File(filePath);
    }

    // to use another file in program
    public void setFile(String filepath) {
        file = new File(filepath);
    }

    // Method to read one line from a file content from a file
    public String readFromFile(String filePath, int Lindex) {
        file = new File(filePath);
        if (Lindex > file.length()) {
            System.out.println("inValid index");
            return new String();
        }
        StringBuilder content = new StringBuilder();
        try (LineNumberReader reader = new LineNumberReader(new FileReader(file))) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                if (reader.getLineNumber() == Lindex) {
                    content.append(line);
                    break;
                }
            }
        } catch (IOException IOE) {
            System.out.println("can't deal with this file");
        }
        // return only one line
        return content.toString();
    }

    // Method to write content to a file
    // content variable will be created from Each (Room , employee , Guest or any)  class as the format it will be retrieved in
    public void writeToFile(String filePath, String content) {
        file = new File(filePath);
        try (FileWriter writer = new FileWriter(file, true)) {  //  new FileWriter(File obj, boolean append)
            writer.write(content);
            writer.write("\n");
        } catch (IOException e) {
            System.out.println("can't deal with this file");
        }
    }

    public void updateRecord(String filePath, String old, String updated) throws FileNotFoundException {
        File source = new File(filePath);
        File temp=new File("D:\\Pl2\\Project\\Hotel Reservation Management System\\TXT files\\Temp.txt");
        String line;
        try (BufferedReader reader = new BufferedReader(new FileReader(source));
             BufferedWriter writer= new BufferedWriter(new FileWriter(temp))){
               while((line=reader.readLine())!=null){
                   if(line.equals(old)){
                       writer.write(updated);
                       writer.flush();
                       writer.newLine();
                   }else{
                       writer.write(line);
                       writer.flush();
                       writer.newLine();
                   }
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
    }

    public int nOofLines(String filePath){
        int size=0;
        try(BufferedReader reader= new BufferedReader(new FileReader((filePath)))){
            String line;
            while((line=reader.readLine())!=null){
                size++;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return size;
    }

    public boolean Exist(String filepath,String key){
        boolean found=false;
        file=new File(filepath);
        try(BufferedReader reader=new BufferedReader(new FileReader(filepath))){
            String line;
            while((line=reader.readLine())!=null){
                if(line.contains(key)){
                    found=true;
                    break;
                }
            }
        }catch(IOException ioe){
            System.out.println("file doesn't exist");
        }
        return found;
    }
}