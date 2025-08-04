import java.io.*;
import java.util.*;

public class FileOperationsDemo {

    // File path (you can change this as needed)
    static final String FILE_NAME = "example.txt";

    public static void main(String[] args) {
        try {
            // 1. Write content to a file
            writeFile("Hello, this is a sample file.\nLet's modify this text.");

            // 2. Read and display file content
            System.out.println("Original File Content:");
            readFile();

            // 3. Modify file content (replace "sample" with "modified")
            modifyFile("sample", "modified");

            // 4. Read and display modified content
            System.out.println("\nModified File Content:");
            readFile();

        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }

    // Method to write content to a file (overwrites if file already exists)
    public static void writeFile(String content) throws IOException {
        FileWriter writer = new FileWriter(FILE_NAME);
        writer.write(content);
        writer.close();
    }

    // Method to read and display file content
    public static void readFile() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME));
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
        reader.close();
    }

    // Method to modify file content by replacing oldString with newString
    public static void modifyFile(String oldString, String newString) throws IOException {
        File file = new File(FILE_NAME);

        // Read the existing content into a StringBuilder
        BufferedReader reader = new BufferedReader(new FileReader(file));
        StringBuilder newContent = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            // Replace occurrences of oldString with newString
            newContent.append(line.replace(oldString, newString)).append("\n");
        }
        reader.close();

        // Write the modified content back to the file
        FileWriter writer = new FileWriter(file);
        writer.write(newContent.toString());
        writer.close();
    }
}
