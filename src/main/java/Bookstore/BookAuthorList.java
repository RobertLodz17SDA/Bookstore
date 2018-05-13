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
        System.out.println();
        for (BookAuthor k : bookAuthorItems) {
            System.out.println(k.toString());
        }
    }

    public void addBookAuthor(BookAuthor bookAuthor) {
        bookAuthorItems.add(bookAuthor);
    }

    public void addNewAuthor() {

        System.out.print("Podaj identyfikator autora : ");
        String authorID = BookstoreApp.getStringInput(new PrintMenuNone());
        while (authorExists(authorID)) {
            System.out.print("Podany identyfikator autora już istnieje. podaj inny : ");
            authorID = BookstoreApp.getStringInput(new PrintMenuNone());
        }
        System.out.print("Podaj imię i nazwisko autora : ");
        String authorNameFamilyName = BookstoreApp.getStringInput(new PrintMenuNone());
        System.out.print("Podaj wiek autora : ");
        int authorAge = BookstoreApp.getIntegerInput(new PrintMenuNone());
        BookAuthor newAuthor = new BookAuthor(authorID, authorNameFamilyName, authorAge);
        addBookAuthor(newAuthor);
    }

    public static BookAuthor getAuthorByID(String authorID) {
        if (authorExists(authorID)) {
            return bookAuthorItems
                    .stream()
                    .filter(bookAuthor -> bookAuthor.getAuthorID().equals(authorID))
                    .findFirst().get();
        } else return null;
    }

    public static boolean authorExists(String author) {
        if (BookAuthorList
                .getBookAuthorListInstance()
                .getBookAuthorItems()
                .stream()
                .anyMatch(author1 -> author1.getAuthorID().equals(author))) {
            return true;
        }
        return false;
    }
}
