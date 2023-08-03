/**
 * Student class represents a student with attributes like id, name, credits, fees per credit, and fees details.
 */
public class Student {

    // Student attributes
    private int id;
    private String name;
    private int credits;
    private int feesPerCredit;
    private int feesPaid;

    /**
     * Constructs a new Student object with the given id, name, credits, and fees per credit.
     * Initializes the feesPaid to 0.
     *
     * @param id            the id of the student
     * @param name          the name of the student
     * @param credits       the number of credits the student is enrolled in
     * @param feesPerCredit the fee per credit
     */
    public Student(int id, String name, int credits, int feesPerCredit){
        // Initialize attributes
        this.feesPaid = 0;
        this.id = id;
        this.name = name;
        this.credits = credits;
        this.feesPerCredit = feesPerCredit;
    }
    public int getFeesPaid() {
        return feesPaid;
    }

    /**
     * The student pays fees, which increases the amount of money the school has.
     * The school's total money earned is updated with the fees paid.
     *
     * @param fees   the total amount of fees the student pays
     * @param school the school the student pays fees to
     */
    public void payFees(int fees, School school) {
        this.feesPaid += fees;
        school.receiveFees(fees);
    }

    /**
     * @return the student's id
     */
    public int getId() {
        return id;
    }

    /**
     * @return the total fees the student has to pay, calculated by multiplying the number of credits and the fee per credit
     */
    public int getFeesTotal() {
        return credits * feesPerCredit;
    }

    /**
     * @return a string representation of the student
     */
    @Override
    public String toString() {
        return "Student's Name  : " + name +
                " Total Fees paid till now $" + feesPaid;
    }
}
