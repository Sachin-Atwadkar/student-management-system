import java.util.ArrayList;
import java.util.Scanner;

class Student {
    int id;
    String name;

    Student(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        while (true) {
            System.out.println("\n===== STUDENT MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Delete Student");
            System.out.println("4. Update Student");
            System.out.println("5. Exit");
            System.out.print("Choose option: ");

            int choice = sc.nextInt();

            // ADD STUDENT
            if (choice == 1) {
                System.out.print("Enter Student ID: ");
                int id = sc.nextInt();

                sc.nextLine();

                System.out.print("Enter Student Name: ");
                String name = sc.nextLine();

                students.add(new Student(id, name));
                System.out.println("Student Added Successfully!");

            }

            // VIEW STUDENTS
            else if (choice == 2) {
                System.out.println("\n--- Student List ---");

                if (students.isEmpty()) {
                    System.out.println("No students found!");
                } else {
                    for (Student s : students) {
                        System.out.println("ID: " + s.id + " | Name: " + s.name);
                    }
                }
            }

            // DELETE STUDENT
            else if (choice == 3) {
                System.out.print("Enter Student ID to delete: ");
                int id = sc.nextInt();

                boolean found = false;

                for (int i = 0; i < students.size(); i++) {
                    if (students.get(i).id == id) {
                        students.remove(i);
                        System.out.println("Student Deleted!");
                        found = true;
                        break;
                    }
                }

                if (!found) {
                    System.out.println("Student not found!");
                }
            }

            // UPDATE STUDENT
            else if (choice == 4) {
                System.out.print("Enter Student ID to update: ");
                int id = sc.nextInt();

                sc.nextLine();

                boolean found = false;

                for (Student s : students) {
                    if (s.id == id) {
                        System.out.print("Enter new name: ");
                        s.name = sc.nextLine();
                        System.out.println("Student Updated!");
                        found = true;
                        break;
                    }
                }

                if (!found) {
                    System.out.println("Student not found!");
                }
            }

            // EXIT
            else if (choice == 5) {
                System.out.println("Exiting...");
                break;
            }

            else {
                System.out.println("Invalid choice!");
            }
        }

        sc.close();
    }
}