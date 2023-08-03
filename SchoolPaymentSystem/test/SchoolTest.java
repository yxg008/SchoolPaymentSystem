import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

public class SchoolTest {

    private School school;
    private Student student;
    private Teacher teacher;

    @BeforeEach
    public void setUp() {
        student = new Student(1, "Test Student", 3, 200);
        teacher = new Teacher(1, "Test Teacher", 500);

        ArrayList<Teacher> teachers = new ArrayList<>();
        teachers.add(teacher);

        ArrayList<Student> students = new ArrayList<>();
        students.add(student);

        school = new School("Test School", teachers, students);
    }

    @Test
    void addTeacher() {
        Teacher newTeacher = new Teacher(2, "New Teacher", 500);
        school.addTeacher(newTeacher);

        // Assuming getTeachers is a method in the School class to return the list of teachers
        assertTrue(school.getTeachers().contains(newTeacher));
    }

    @Test
    void addStudent() {
        Student newStudent = new Student(2, "New Student", 3, 200);
        school.addStudent(newStudent);

        // Assuming getStudents is a method in the School class to return the list of students
        assertTrue(school.getStudents().contains(newStudent));
    }

    @Test
    void receiveFees() {
        int initialMoney = school.getTotalMoneyEarned();
        int fees = 600;
        student.payFees(fees, school);

        assertEquals(initialMoney + fees, school.getTotalMoneyEarned());
    }

    @Test
    void paySalary() {
        int initialMoney = school.getTotalMoneyEarned();
        school.paySalary(teacher);

        assertEquals(initialMoney - teacher.getSalary(), school.getTotalMoneyEarned());
    }

    @Test
    void getName() {
        assertEquals("Test School", school.getName());
    }
}
