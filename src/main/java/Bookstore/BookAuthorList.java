package Bookstore;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookAuthorList {

    private static List<BookAuthor> bookAuthorItems = new ArrayList<>();

    public List<BookAuthor> getBookAuthorItems() {
        return bookAuthorItems;
    }

    public static void setBookAuthorList(List<BookAuthor> bookAuthorItems) {
        BookAuthorList.bookAuthorItems = bookAuthorItems;
    }

    private static BookAuthorList bookAuthorList = null;

    public static BookAuthorList getBookAuthorListInstance() {
        if (bookAuthorList == null) {
            return new BookAuthorList();
        } else {
            return bookAuthorList;
        }
    }

    private BookAuthorList() {
    }

    public void printBookAurhorList() {

        System.out.println("Lista autorów książek dostępnych w księgarni : ");
        for (BookAuthor k : bookAuthorItems) {
            System.out.println(k.toString());
        }
    }

    public void addBookAuthor(BookAuthor bookAuthor) {
        bookAuthorItems.add(bookAuthor);
    }

    public void addNewAuthor(){
        String authorID;
        String authorNameFamilyName;
        int authorAge;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Podaj identyfikator autora : ");
        authorID = BookstoreApp.getStringInput(new PrintMenuNone());
        System.out.print("Podaj imię i nazwisko autora : ");
        authorNameFamilyName = BookstoreApp.getStringInput(new PrintMenuNone());
        System.out.print("Podaj wiek autora : ");
        authorAge = BookstoreApp.getIntegerInput(new PrintMenuNone());
        BookAuthor newAuthor = new BookAuthor(authorID, authorNameFamilyName, authorAge);
        addBookAuthor(newAuthor);
    }

    public static BookAuthor getAuthorByID(String authorID){
        return bookAuthorItems.stream().filter(bookAuthor -> bookAuthor.getAuthorID().equals(authorID)).findFirst().get();
    }

}
