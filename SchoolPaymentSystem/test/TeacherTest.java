import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TeacherTest {
    private Teacher teacher;

    @BeforeEach
    public void setUp() {
        teacher = new Teacher(1, "John Doe", 5000);
    }

    @Test
    public void getId() {
        assertEquals(1, teacher.getId());
    }

    @Test
    public void getName() {
        assertEquals("John Doe", teacher.getName());
    }

    @Test
    public void getSalary() {
        assertEquals(5000, teacher.getSalary());
    }

    @Test
    public void testToString() {
        assertEquals("Teacher's Name : John Doe Salary $5000", teacher.toString());
    }
}
