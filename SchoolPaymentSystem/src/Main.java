import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * The Main class runs the School Management System. It uses a menu-based console interface to interact with the user.
 * The user can choose to perform actions like adding a teacher/student, making a student pay fees, pay a teacher's salary,
 * and display the financial status of the school.
 */
public class Main {

    /**
     * The main method is the entry point to the School Management System.
     * It sets up the scanner for user input, creates empty lists for teachers and students, and creates a new school.
     * Then it starts the main loop for user interaction, presenting a menu of options to the user and responding to their choice.
     *
     * @param args Command-line arguments
     */
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Create empty lists of teachers and students
        List<Teacher> teacherList = new ArrayList<>();
        List<Student> studentList = new ArrayList<>();

        // Welcome user and ask for school name
        System.out.println("\033[1m\033[34mWelcome to School Management System!\033[0m");
        System.out.print("Please enter your school's name: ");
        String schoolName = scanner.nextLine();

        // Create a new school with entered name and empty teacher and student lists
        School school = new School(schoolName, teacherList, studentList);

        // Start the main loop for user interactions
        while(true) {
            // Display main menu options
            System.out.println("\n\033[1m\033[34m------ " + school.getName() + " ------\033[0m");
            System.out.println("1. Add a new teacher");
            System.out.println("2. Add a new student");
            System.out.println("3. Make a student pay fees");
            System.out.println("4. Pay a teacher's salary");
            System.out.println("5. Display school financial status");
            System.out.println("0. Exit");
            System.out.print("Please enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume the leftover newline character

            // Handle user's choice
            switch (choice) {
                case 1: // Add new teacher
                    System.out.print("Enter teacher's id, name, and salary: ");
                    int teacherId = scanner.nextInt();
                    String teacherName = scanner.next();
                    int teacherSalary = scanner.nextInt();
                    Teacher teacher = new Teacher(teacherId, teacherName, teacherSalary);
                    school.addTeacher(teacher);
                    System.out.println("Teacher added successfully!");
                    break;
                case 2: // Add new student
                    System.out.print("Enter student's id, name, credits and feesPerCredit: ");
                    int studentId = scanner.nextInt();
                    String studentName = scanner.next();
                    int credits = scanner.nextInt();
                    int feesPerCredit = scanner.nextInt();
                    Student student = new Student(studentId, studentName, credits, feesPerCredit);
                    school.addStudent(student);
                    System.out.println("Student added successfully!");
                    break;
                case 3: // Handle fee payment by a student
                    System.out.print("Enter the id of the student who is paying fees: ");
                    int payingStudentId = scanner.nextInt();
                    for(Student s : studentList) {
                        if(s.getId() == payingStudentId) {
                            int fees = s.getFeesTotal();
                            s.payFees(fees, school);
                            System.out.println("The student paid: $" + fees);
                            break;
                        }
                    }
                    break;
                case 4: // Pay a teacher's salary
                    System.out.print("Enter the id of the teacher who is being paid: ");
                    int paidTeacherId = scanner.nextInt();
                    for(Teacher t : teacherList) {
                        if(t.getId() == paidTeacherId) {
                            school.paySalary(t.getSalary());
                            break;
                        }
                    }
                    break;
                case 5: // Display school's financial status
                    System.out.println("\033[1mTotal money earned by " + school.getName() + ": $\033[0m" + school.getTotalMoneyEarned());
                    System.out.println("\033[1mTotal money spent by " + school.getName() + ": $\033[0m" + school.getTotalMoneySpent());
                    break;
                case 0: // Exit the program
                    scanner.close();
                    System.out.println("\033[1m\033[34mThank you for using the School Management System!\033[0m");
                    return;
                default: // Handle invalid choice
                    System.out.println("\033[31mInvalid input. Please enter a number from 0 to 5\033[0m");
            }
        }
    }
}
