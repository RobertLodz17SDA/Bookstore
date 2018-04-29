package Bookstore;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class BooksFunctionsTest {

    private BooksFunctions booksFunctions = new BooksFunctions();

    private List<Book> books = new ArrayList<>();

    @Before
    public void init() {
        books.add(new Book("Clean Code", "0132350882", 2008));
        books.add(new Book("Effective Java", "0134685997", 2018));
        books.add(new Book("Test Driven Development", "0321146530", 2003));
        books.add(new Book("Patterns of Enterprise Application Architecture", "0321127420", 2002));
        books.add(new Book("Head First Design Patterns", "0596007124", 2004));
    }

    @Test
    public void testFindBookByISBN() {
        assertEquals("0134685997", booksFunctions.findBookByISBN(books, "0134685997").get().getNumberISDN());
        assertEquals("0321127420", booksFunctions.findBookByISBN(books, "0321127420").get().getNumberISDN());
        assertEquals("0596007124", booksFunctions.findBookByISBN(books, "0596007124").get().getNumberISDN());
    }

    @Test
    public void testSortBooksByYearAscending() {
        List<Book> list = new ArrayList<>();
        list.add(new Book("Patterns of Enterprise Application Architecture", "0321127420", 2002));
        list.add(new Book("Test Driven Development", "0321146530", 2003));
        list.add(new Book("Head First Design Patterns", "0596007124", 2004));
        list.add(new Book("Clean Code", "0132350882", 2008));
        list.add(new Book("Effective Java", "0134685997", 2018));

        assertEquals(list.toString(), booksFunctions.sortBooksByYearAscending(books).toString());
//        assertThat(list,is(booksFunctions.sortBooksByYearAscending(books)));
//        System.out.println(list.equals(booksFunctions.sortBooksByYearAscending(books)));
    }

    @Test
    public void testGetTwoLastBooks() {
        List<Book> list = new ArrayList<>();
        list.add(new Book("Patterns of Enterprise Application Architecture", "0321127420", 2002));
        list.add(new Book("Head First Design Patterns", "0596007124", 2004));
        assertEquals(list.toString(), booksFunctions.getTwoLastBooks(books).toString());
    }
}
