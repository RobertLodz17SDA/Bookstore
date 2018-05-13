package Bookstore;

public class BookstoreSalesPerson extends BookstoreEmpoyee {

    double baseSalary;

    public BookstoreSalesPerson(String firstName, String familyName, String email, int age, char gender, double baseSalary) {
        super(firstName, familyName, email, age, gender);
        this.baseSalary = baseSalary;
    }

    @Override
    public double getSalaryInformation(int numberOfWorkingHours) {
        return baseSalary;
    }
}
