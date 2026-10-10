import java.util.ArrayList;
import java.util.Scanner;

class Student {
    private String name;
    private int marks;

    public Student(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }

    public String getName() {
        return name;
    }

    public int getMarks() {
        return marks;
    }

    public String getResult() {
        return marks >= 40 ? "Pass" : "Fail";
    }

    public void display() {
        System.out.println(
            "Name: " + name
            + " | Marks: " + marks
            + " | Result: " + getResult()
        );
    }
}

public class Main {
    private static final ArrayList<Student> students =
            new ArrayList<>();

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n=== Student Management App ===");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");

            try {
                int choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1:
                        System.out.print("Enter student name: ");
                        String name = scanner.nextLine().trim();

                        if (name.isEmpty()) {
                            System.out.println("Name cannot be empty.");
                            break;
                        }

                        System.out.print("Enter marks (0-100): ");
                        int marks = Integer.parseInt(scanner.nextLine());

                        if (marks < 0 || marks > 100) {
                            System.out.println("Invalid marks.");
                            break;
                        }

                        students.add(new Student(name, marks));
                        System.out.println("Student added successfully!");
                        break;

                    case 2:
                        if (students.isEmpty()) {
                            System.out.println("No students found.");
                        } else {
                            for (Student student : students) {
                                student.display();
                            }
                        }
                        break;

                    case 3:
                        System.out.println("Thank you!");
                        scanner.close();
                        return;

                    default:
                        System.out.println("Please select 1, 2, or 3.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }
}
