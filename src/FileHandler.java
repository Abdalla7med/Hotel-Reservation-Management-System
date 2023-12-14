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
    public void setFile(File f) {
        file = f;
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
            writer.write(content+"\n");
        } catch (IOException e) {
            System.out.println("can't deal with this file");
        }
    }
    public void writeToFil(File f, String content) {
        file = f;
        try (FileWriter writer = new FileWriter(file, true)) {  //  new FileWriter(File obj, boolean append)
            writer.write(content+"\n");
        } catch (IOException e) {
            System.out.println("can't deal with this file");
        }
    }
    public void updateRecord(String filePath, String old, String updated) {
        File source = new File(filePath);
        File temp = new File("D:\\Pl2\\Project\\Hotel Reservation Management System\\TXT files\\Temp.txt");
        String line;
        try (BufferedReader reader = new BufferedReader(new FileReader(source));
             BufferedWriter writer = new BufferedWriter(new FileWriter(temp))) {
            while ((line = reader.readLine()) != null) {
                if (line.equals(old)) {
                    writer.write(updated);
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
    }

    public void updateRecord(File f, String old, String updated) {
        File source = f;
        File temp = new File("D:\\Pl2\\Project\\Hotel Reservation Management System\\TXT files\\Temp.txt");
        String line;
        try (BufferedReader reader = new BufferedReader(new FileReader(source));
             BufferedWriter writer = new BufferedWriter(new FileWriter(temp))) {
            while ((line = reader.readLine()) != null) {
                if (line.equals(old)) {
                    writer.write(updated);
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
    }

    public static  int nOofLines(String filePath) {
        int size = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader((filePath)))) {
            String line;
            while ((line = reader.readLine()) != null) {
                size++;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return size;
    }

    public static int nOofLines(File f) {
        int size = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader((f)))) {
            String line;
            while ((line = reader.readLine()) != null) {
                size++;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return size;
    }

   // search if exist or not
    public boolean Exist(String filepath, String key) {
        boolean found = false;
        file = new File(filepath);
        try (BufferedReader reader = new BufferedReader(new FileReader(filepath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains(key)) {
                    found = true;
                    break;
                }
            }
        } catch (IOException ioe) {
            System.out.println("file doesn't exist");
        }
        return found;
    }
    public boolean Exist(File f, String key) {
        boolean found = false;
        file = f;
        try (BufferedReader reader = new BufferedReader(new FileReader(f))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains(key)) {
                    found = true;
                    break;
                }
            }
        }catch (IOException ioe) {
            System.out.println("file doesn't exist");
        }
        return found;
    }

    // get certain record
    public String CertainRecord(String filepath, String key) {
        String line = null;
        file=new File(filepath);
        if (this.Exist(filepath, key)) {
            try (BufferedReader reader = new BufferedReader(new FileReader(filepath))) {
                while ((line = reader.readLine()) != null) {
                    if (line.contains(key)) {
                        break;
                    }
                }
            } catch (IOException ioe) {
                System.out.println("can't deal with this file");
            }
        } else {
            System.out.println("doesn't exist");
            return "doesn't exist";
        }
        return line;
    }
    // overloaded
    public String CertainRecord(File f, String key) {
        String line = null;
        file =f;
        if(file.length()==0){
            System.out.println("no Person in "+f.getName());
            return "false";
        }
        if (this.Exist(f, key)) {
            file = f;
            try (BufferedReader reader = new BufferedReader(new FileReader(f))) {
                while ((line = reader.readLine()) != null) {
                    if (line.contains(key)) {
                        break;
                    }
                }
            } catch (IOException ioe) {
                System.out.println("can't deal with this file");
            }
        } else {
            System.out.println("doesn't exist");
            return "doesn't exist";
        }
        return line;
    }
    // the Intuition behind this solution is to keep last line in prev because after loop line will be null

    public static String getLast(String file){
        String line=null,prev=null;
        try(BufferedReader reader=new BufferedReader(new FileReader(file))){
            while((line=reader.readLine())!=null){
                prev=line;
            }
        }catch(IOException e){
            System.out.println("can't deal with this file");
        }
        return prev;
    }
    // Overloaded method
    public static String getLast(File file){
        String line=null,prev=null;
        try(BufferedReader reader=new BufferedReader(new FileReader(file))){
            while((line=reader.readLine())!=null){
                prev=line;
            }
        }catch(IOException e){
            System.out.println("can't deal with this file");
        }
        return prev;
    }


} // end of class