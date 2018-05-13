package Bookstore;

import java.util.ArrayList;
import java.util.List;

public class BookList {

    public List<Book> getBookListItems() {
        return bookListItems;
    }

    public static void setBookListItems(List<Book> bookListItems) {
        BookList.bookListItems = bookListItems;
    }

    private static List<Book> bookListItems = new ArrayList<Book>();

    private static BookList bookList = null;

    public static BookList getBookListInstance() {
        if (bookList == null) {
            return new BookList();
        } else {
            return bookList;
        }
    }

    private BookList() {
    }

    public void printBookList() {

        System.out.println("Lista książek dostępnych w księgarni : ");
        System.out.println();
        for (Book k : bookListItems) {
            System.out.println(k.toString());
        }
    }

    public void addBook(Book book) {
        bookListItems.add(book);
    }
}
