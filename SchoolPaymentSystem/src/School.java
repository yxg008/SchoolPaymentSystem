import java.util.List;
/**
 * The School class represents a school, which has a list of teachers, students and a record of the total money earned/spent.
 */
public class School {

    // School's list of teachers
    private List<Teacher> teachers;

    // School's list of students
    private List<Student> students;

    // Total money earned by the school
    private int totalMoneyEarned;

    // Total money spent by the school (salaries paid)
    private int totalMoneySpent;

    // Name of the school
    private String name;

    /**
     * Constructs a new School with specified name, list of teachers, list of students.
     * Initializes the total money earned/spent to 0.
     *
     * @param name      the name of the school
     * @param teachers  the list of teachers
     * @param students  the list of students
     */
    public School(String name, List<Teacher> teachers, List<Student> students) {
        this.teachers = teachers;
        this.students = students;
        this.name = name;
        totalMoneyEarned = 0;
        totalMoneySpent = 0;
    }
    public List<Teacher> getTeachers() {
        return teachers;
    }
    public List<Student> getStudents() {
        return students;
    }
    public void paySalary(Teacher teacher) {
        int salary = teacher.getSalary();
        this.totalMoneyEarned -= salary;
    }

    /**
     * Adds a new teacher to the school.
     *
     * @param teacher the teacher to be added
     */
    public void addTeacher(Teacher teacher) {
        teachers.add(teacher);
    }

    /**
     * Adds a new student to the school.
     *
     * @param student the student to be added
     */
    public void addStudent(Student student) {
        students.add(student);
    }

    /**
     * @return the total money earned by the school
     */
    public int getTotalMoneyEarned() {
        return totalMoneyEarned;
    }

    /**
     * Increments the total money earned by the school.
     *
     * @param moneyEarned the money that is to be added to the total earned
     */
    public void receiveFees(int moneyEarned) {
        totalMoneyEarned += moneyEarned;
        System.out.println("School has received a fee and now has $" + totalMoneyEarned);
    }

    /**
     * @return the total money spent by the school (salaries paid)
     */
    public int getTotalMoneySpent() {
        return totalMoneySpent;
    }

    /**
     * Pays salaries to the school staff from the total money collected. Updates the total money spent and the total money earned.
     *
     * @param moneySpent the money that is to be spent on salaries
     */
    public void paySalary(int moneySpent) {
        if (totalMoneyEarned >= moneySpent) {
            totalMoneyEarned -= moneySpent;
            totalMoneySpent += moneySpent;
            System.out.println("School has paid salary and now has $" + totalMoneyEarned);
        } else {
            System.out.println("Not enough money to pay salary");
        }
    }

    /**
     * @return the name of the school
     */
    public String getName() {
        return name;
    }
}
