import java.io.*;
public class FileHandler {
    private File file = null;

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

        return filePath;
    }

    // Method to write content to a file
    public static void writeFile(String filePath, String content) {

    }
}