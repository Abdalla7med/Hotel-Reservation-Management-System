import java.io.*;
public class FileHandler {
     static File file = null;

    public FileHandler() { }

    // to use another file in program
    public void setFile(String filepath) {
        this.file = new File(filepath);
    }

    public FileHandler(String filePath) {
        this.file = new File(filePath);
    }

    // Method to read content from a file
    public static String readFile(String filePath) {
        StringBuilder content = new StringBuilder();
        try(FileReader reader= new FileReader(file)){
            String line;
            while((line = reader.readLine())){

            }
        }catch(IOException IOE){
            System.out.println("can't deal with this file");
        }
        return filePath;
    }
    // Method to write content to a file
    public static void writeFile(String filePath, String content) {

    }
}