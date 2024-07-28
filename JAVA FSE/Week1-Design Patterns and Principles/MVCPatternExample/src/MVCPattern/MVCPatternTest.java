package MVCPattern;

import java.util.Scanner;

public class MVCPatternTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create initial student data
        System.out.println("Enter student ID:");
        String id = scanner.nextLine();

        System.out.println("Enter student name:");
        String name = scanner.nextLine();

        System.out.println("Enter student grade:");
        String grade = scanner.nextLine();

        Student student = new Student(id, name, grade);
        StudentView view = new StudentView();
        StudentController controller = new StudentController(student, view);

        // Display initial student details
        controller.updateView();

        // Loop to update student details based on user input
        while (true) {
            System.out.println("\nDo you want to update student details? (yes/no):");
            String response = scanner.nextLine();

            if (response.equalsIgnoreCase("no")) {
                break;
            }

            System.out.println("Enter new student name:");
            name = scanner.nextLine();
            controller.setStudentName(name);

            System.out.println("Enter new student grade:");
            grade = scanner.nextLine();
            controller.setStudentGrade(grade);

            // Display updated student details
            controller.updateView();
        }

        scanner.close();
    }
}
