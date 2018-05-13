package Bookstore;

public class BookstoreIntern extends BookstoreEmpoyee {

    private double salaryPerHour;

    public BookstoreIntern(String firstName, String familyName, String email, int age, char gender, double salaryPerHour) {
        super(firstName, familyName, email, age, gender);
        this.salaryPerHour = salaryPerHour;
    }

    @Override
    public double getSalaryInformation(int numberOfWorkingHours) {
        return numberOfWorkingHours * salaryPerHour;
    }
}
