import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

public class StudentTest {

    private School school;
    private Student student;

    @BeforeEach
    public void setUp() {
        school = new School("Test School", new ArrayList<>(), new ArrayList<>());
        student = new Student(1, "Test Student", 3, 100);
    }

    @Test
    void payFees() {
        // Arrange
        int fees = 300;

        // Act
        student.payFees(fees, school);

        // Assert
        assertEquals(fees, student.getFeesPaid());
        assertEquals(fees, school.getTotalMoneyEarned());
    }

    @Test
    void getId() {
        // Assert
        assertEquals(1, student.getId());
    }

    @Test
    void getFeesTotal() {
        // Assert
        assertEquals(300, student.getFeesTotal());
    }

    @Test
    void testToString() {
        // Assert
        assertEquals("Student's Name  : Test Student Total Fees paid till now $0", student.toString());
    }
}
