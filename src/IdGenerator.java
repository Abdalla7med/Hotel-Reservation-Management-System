import java.io.*;

public class IdGenerator {
    // The static field for the counter value
    private static int counter;

    // The static method for generating the next id
    public static int getNextId(String fileName) {
        load(fileName);
        // Increment the counter by one and return it
        return ++counter;
    }
    // The method for loading the counter value from a file
    public static void load(String fileName) {
        try (BufferedReader reader=new BufferedReader(new FileReader(fileName))){
           String line;
           while((line=reader.readLine())!=null) {
               String []data=line.split(" , ");
               counter = Integer.parseInt(data[0].trim());
           }
        } catch (IOException e) {
            // Handle the exception
            System.out.println("can't deal with this file");
        }
    }
}
