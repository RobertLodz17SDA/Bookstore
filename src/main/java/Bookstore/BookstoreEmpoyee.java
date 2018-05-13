package Bookstore;

public abstract class BookstoreEmpoyee {

    private String firstName;
    private String familyName;
    private String email;
    private int age;
    private char gender;

    public BookstoreEmpoyee(String firstName, String familyName, String email, int age, char gender) {
        this.firstName = firstName;
        this.familyName = familyName;
        this.email = email;
        this.age = age;
        this.gender = gender;
    }

    public abstract double getSalaryInformation(int numberOfWorkingHours);

    public String getFirstName() {
        return firstName;
    }

    public String getFamilyName() {
        return familyName;
    }
}

