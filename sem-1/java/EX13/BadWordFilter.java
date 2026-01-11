package EX13;
import java.io.*;
import java.util.*;

public class BadWordFilter {
   
    static Set<String> badWords = new HashSet<>(Arrays.asList(
        "badword1", "badword2", "nastyword", "offensive"  // Example bad words
    ));

    public static void main(String[] args) {
        // Path to the file to read
        String filePath = "EX13/test.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean containsBadWord = false;

            while ((line = br.readLine()) != null) {
                for (String word : line.toLowerCase().split("\\W+"))
        {  // Split by non-word characters
                    if (badWords.contains(word)) {
                        containsBadWord = true;
                        break;
                    }
                }
                if (containsBadWord) {
                    break;
                }
            }

            if (containsBadWord) {
                System.out.println("Access Denied: File contains prohibited content.");
            } else {
                System.out.println("File is clean. Reading contents:\n");
                printFile(filePath);
            }

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    // Method to print file content
    private static void printFile(String path) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while((line = br.readLine()) != null) {
                System.out.println(line);
            }
        }
    }
}