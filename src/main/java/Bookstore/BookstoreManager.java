package Bookstore;

public class BookstoreManager extends BookstoreEmpoyee {

    private int phoneNyumber;
    private double salaryPerHourB2B;

    public BookstoreManager(String firstName, String familyName, String email, int age, char gender, int phoneNyumber, double salaryPerHourB2B) {
        super(firstName, familyName, email, age, gender);
        this.phoneNyumber = phoneNyumber;
        this.salaryPerHourB2B = salaryPerHourB2B;
    }

    @Override
    public double getSalaryInformation(int numberOfWorkingHours) {
        return numberOfWorkingHours * salaryPerHourB2B;
    }
}
