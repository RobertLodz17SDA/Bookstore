package Bookstore;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BookCategoryList {

    private static List<BookCategory> bookCategoryItems = new ArrayList<>();

    public List<BookCategory> getBookCategoryItems() {
        return bookCategoryItems;
    }

    public static void setBookCategoryList(List<BookCategory> bookCategoryItems) {
        BookCategoryList.bookCategoryItems = bookCategoryItems;
    }

    private static BookCategoryList bookCategoryList = null;

    public static BookCategoryList getBookCategoryListInstance() {
        if (bookCategoryList == null) {
            return new BookCategoryList();
        } else {
            return bookCategoryList;
        }
    }

    private BookCategoryList() {
    }

    public void printCategoryList() {
        System.out.println("Lista kategorii książek dostępnych w księgarni : ");
        for (BookCategory k : bookCategoryItems) {
            System.out.println(k.toString());
        }
    }

    public void addBookCategory(BookCategory bookCategory) {
        bookCategoryItems.add(bookCategory);
    }
}
