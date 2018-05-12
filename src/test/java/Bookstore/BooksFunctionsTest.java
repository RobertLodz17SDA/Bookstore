package Bookstore;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
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
        assertEquals("0134685997", BooksFunctions.findBookByISBN(books, "0134685997").getNumberISBN());
        assertEquals("0321127420", BooksFunctions.findBookByISBN(books, "0321127420").getNumberISBN());
        assertEquals("0596007124", BooksFunctions.findBookByISBN(books, "0596007124").getNumberISBN());
//        assertEquals(new Book(), BooksFunctions.findBookByISBN(books, "0596073734"));
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

    @Test
    public void testsortBooksByYearDescending() {
        List<Book> list = new ArrayList<>();
        list.add(new Book("Effective Java", "0134685997", 2018));
        list.add(new Book("Clean Code", "0132350882", 2008));
        list.add(new Book("Head First Design Patterns", "0596007124", 2004));
        list.add(new Book("Test Driven Development", "0321146530", 2003));
        list.add(new Book("Patterns of Enterprise Application Architecture", "0321127420", 2002));

        assertEquals(list.toString(), booksFunctions.sortBooksByYearDescending(books).toString());
    }

    @Test
    public void testGetEarliestPublishedBook() {
        assertEquals("0321127420", booksFunctions.getEarliestPublishedBook(books).getNumberISBN());
    }

    @Test
    public void testGetLatestPublishedBook() {
        assertEquals("0134685997", booksFunctions.getLatestPublishedBook(books).getNumberISBN());
    }

    @Test
    public void testSumOfYearsBooksWerePublished() {
        assertEquals(10035, booksFunctions.sumOfYearsBooksWerePublished(books));
    }

    @Test
    public void testNumberOfBooksPublishedAfter2007() {
        assertEquals(2, booksFunctions.numberOfBooksPublishedAfter2007(books));
    }

    @Test
    public void testAllBooksPublishedAfter2000() {
        assertEquals(true, booksFunctions.allBooksPublishedAfter2000(books));
        books.add(new Book("Lalalal", "0596007125", 1994));
        assertEquals(false, booksFunctions.allBooksPublishedAfter2000(books));

    }

    @Test
    public void testBookstoreAverageYearOfPublishing() {
        assertEquals(2007, booksFunctions.bookstoreAverageYearOfPublishing(books));
    }

    @Test
    public void testAnyBookPublishedBefore2000() {
        assertEquals(false, booksFunctions.anyBookPublishedBefore2000(books));
        books.add(new Book("Lalalal", "0596007125", 1994));
        assertEquals(true, booksFunctions.anyBookPublishedBefore2000(books));
    }

    @Test
    public void testAllTitlesStartWithTandPublishedAfter2009() {
        assertEquals(Collections.EMPTY_LIST, booksFunctions.allTitlesStartWithTandPublishedAfter2009(books));
        Book book = new Book("TheTestBook for Test purposes only", "0132350800", 2010);
        books.add(book);
        assertEquals(book.getNumberISBN(), booksFunctions.allTitlesStartWithTandPublishedAfter2009(books).get(0).getNumberISBN());

    }

    @Test
    public void testAdd100YearsToAllBooksPublishingYear(){
        booksFunctions.add100YearsToAllBooksPublishingYear(books);
        assertEquals(2108, books.get(0).getYearOfPublication());
        assertEquals(2118, books.get(1).getYearOfPublication());
        assertEquals(2103, books.get(2).getYearOfPublication());
        assertEquals(2102, books.get(3).getYearOfPublication());
        assertEquals(2104, books.get(4).getYearOfPublication());
    }

    @Test
    public void testReturnAllTitlesWhosePublishedYearIsMod2(){
        List<String> list = new ArrayList<>();
        list = booksFunctions.returnAllTitlesWhosePublishedYearIsMod2(books);
        assertEquals(books.get(0).getTitle(), list.get(0));
        assertEquals(books.get(1).getTitle(), list.get(1));
        assertEquals(books.get(3).getTitle(), list.get(2));
        assertEquals(books.get(4).getTitle(), list.get(3));
    }
}
