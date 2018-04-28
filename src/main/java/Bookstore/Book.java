package Bookstore;

public class Book {

    private String title;
    private int refNumber;
    private int yearOfPublication;

    Book(String title, int refNumber, int year) {
        this.title = title;
        this.refNumber = refNumber;
        this.yearOfPublication = year;
    }

    public String getTitle() {
        return title;
    }

    public int getRefNumber() {
        return refNumber;
    }

    public int getYearOfPublication() {
        return yearOfPublication;
    }

    @Override
    public String toString() {
        return  "Tytuł : \'" + title + '\'' +
                "   ISBN " + refNumber +
                "   Rok publikacji " + yearOfPublication;
    }
}
