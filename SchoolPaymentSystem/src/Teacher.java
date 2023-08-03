/**
 * Teacher class represents a teacher with attributes like id, name, and salary.
 */
public class Teacher {

    // Teacher attributes
    private int id;
    private String name;
    private int salary;

    /**
     * Constructs a new Teacher object with the given id, name, and salary.
     *
     * @param id      the id of the teacher
     * @param name    the name of the teacher
     * @param salary  the salary of the teacher
     */
    public Teacher(int id, String name, int salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    /**
     * @return the teacher's id
     */
    public int getId() {
        return id;
    }

    /**
     * @return the teacher's name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the teacher's salary
     */
    public int getSalary() {
        return salary;
    }

    /**
     * @return a string representation of the teacher
     */
    @Override
    public String toString() {
        return "Teacher's Name : " + name +
                " Salary $" + salary;
    }
}
