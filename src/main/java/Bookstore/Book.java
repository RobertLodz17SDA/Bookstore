package Bookstore;

public class Book implements Comparable{

    private String title;
    private String numberISDN;
    private int yearOfPublication;

    Book(String title, String numberISDN, int year) {
        this.title = title;
        this.numberISDN = numberISDN;
        this.yearOfPublication = year;
    }

    public void setYearOfPublication(int yearOfPublication) {
        this.yearOfPublication = yearOfPublication;
    }

    public String getTitle() {
        return title;
    }

    public String getNumberISDN() {
        return numberISDN;
    }

    public int getYearOfPublication() {
        return yearOfPublication;
    }

    @Override
    public String toString() {
        return  "Tytuł : \'" + title + '\'' +
                "   ISBN " + numberISDN +
                "   Rok publikacji " + yearOfPublication;
    }

    public int compareTo(Object anotherBook) throws ClassCastException {
        if (!(anotherBook instanceof Book))
            throw new ClassCastException("A Book object expected.");
        int anotherBookYear = ((Book) anotherBook).getYearOfPublication();
        return this.yearOfPublication - anotherBookYear;
    }
}
