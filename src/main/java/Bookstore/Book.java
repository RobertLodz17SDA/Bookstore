package Bookstore;

import javafx.print.Collation;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Book implements Comparable {

    private String title;
    private String numberISBN;
    private int yearOfPublication;
    private char cover;
    private List<BookAuthor> authorsList;
    private BookCategory category;



    public Book(String title, String numberISBN, int yearOfPublication, char cover, List<BookAuthor> authorsList, BookCategory category) {
        this.title = title;
        this.numberISBN = numberISBN;
        this.yearOfPublication = yearOfPublication;
        this.cover = cover;
        this.authorsList = authorsList;
        this.category = category;
    }

    public Book(String title, String numberISBN, int yearOfPublication) {
        this.title = title;
        this.numberISBN = numberISBN;
        this.yearOfPublication = yearOfPublication;
    }

    public Book(){
        this.title = "";
        this.numberISBN = "";
        this.yearOfPublication = 0;
        this.cover = ' ';
        this.authorsList = null;
        this.category = null;
    }


    public void setYearOfPublication(int yearOfPublication) {
        this.yearOfPublication = yearOfPublication;
    }

    public String getTitle() {
        return title;
    }

    public String getNumberISBN() {
        return numberISBN;
    }

    public int getYearOfPublication() {
        return yearOfPublication;
    }

    @Override
    public int compareTo(Object anotherBook) throws ClassCastException {
        if (!(anotherBook instanceof Book))
            throw new ClassCastException("A Book object expected.");
        int anotherBookYear = ((Book) anotherBook).getYearOfPublication();
        return this.yearOfPublication - anotherBookYear;
    }

    public void cloneBook(Book book) {
        this.yearOfPublication = book.yearOfPublication;
        this.numberISBN = book.numberISBN;
        this.title = book.title;
    }

    public String toString() {
        return "Tytuł : \'" + getTitle() + '\'' +
                "   Rok publikacji : " + getYearOfPublication() +
                "   ISBN : " + getNumberISBN()+ "  Okładka : "+ getCover()+" Autor : "+ authorsPrintList() + " Kategoria : "+ category.getCategoryName();
    }

    private StringBuilder authorsPrintList(){
        StringBuilder authors = new StringBuilder();
        for (BookAuthor author : authorsList){
            authors.append(author.getAuthorNameFamilyName() + " / ");
        }
        return authors.delete(authors.length()-3, authors.length()-1);
    }

    public char getCover() {
        return cover;
    }

    public List<BookAuthor> getAuthorsList() {
        return authorsList;
    }

    public BookCategory getCategory() {
        return category;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
