package EX6;
import java.io.*;
import java.util.Scanner;

public class StudentInfoManager {

    static final String FILE_NAME = "students.txt";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\nStudent Info System");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    addStudent(sc);
                    break;
                case 2:
                    viewStudents();
                    break;
                case 3:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    static void addStudent(Scanner sc) {
        try (FileWriter fw = new FileWriter(FILE_NAME, true);
            BufferedWriter bw = new BufferedWriter(fw)) {

            System.out.print("Enter Name: ");
            String name = sc.nextLine();
            System.out.print("Enter Roll Number: ");
            String roll = sc.nextLine();
            System.out.print("Enter Marks: ");
            String marks = sc.nextLine();

            String record = roll + "," + name + "," + marks;
            bw.write(record);
            bw.newLine();
            System.out.println("Student added successfully.");

        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

    static void viewStudents() {
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            System.out.println("\n--- Student Records ---");
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    System.out.println("Roll: " + parts[0] + ", Name: " + parts[1] + ", Marks: " + parts[2]);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("No student records found.");
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}