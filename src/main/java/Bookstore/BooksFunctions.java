package Bookstore;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class BooksFunctions {


    public Optional<Book> findBookByISBN(List<Book> bookList, String numberISBN) {

        Optional<Book> first = bookList.stream().filter(book -> book.getNumberISDN().equals(numberISBN)).findFirst();
        if (first.isPresent()) {
            return first;
        } else return null;
    }

    public List<Book> sortBooksByYearAscending(List<Book> bookList) {
        return bookList.stream().sorted().collect(Collectors.toList());
    }

    public List<Book> getTwoLastBooks(List<Book> bookList) {
        List<Book> list = new ArrayList<>();
        System.out.println(bookList.size());
        if (bookList.size() >= 2) {
            list.add(bookList.get(bookList.size() - 2));
            list.add(bookList.get(bookList.size()-1));
        } else if (bookList.size() == 1) {
            list.add(bookList.get(bookList.size()-1));
        } else list = null;
        return list;
    }

    public List<Book> sortBooksByYearDescending(List<Book> bookList) {

        List<Book> list1;
        List<Book> list2 = new ArrayList<>();
        list1 = bookList.stream().sorted().collect(Collectors.toList());
        for (int i = list1.size() - 1; i == 0; i--) {
            list2.add(list1.get(i));
        }
        return list2;
    }

    public Book getEarliestPublishedBook(List<Book> bookList) {
        Book book = bookList.get(0);
        for (Book book1 : bookList) {
            if (book1.getYearOfPublication() < book.getYearOfPublication()) {
                book = book1;
            }
        }
        return book;
    }

    public Book getLatestPublishedBook(List<Book> bookList) {
        Book book = bookList.get(0);
        for (Book book1 : bookList) {
            if (book1.getYearOfPublication() > book.getYearOfPublication()) {
                book = book1;
            }
        }
        return book;
    }

    public int sumOfYearsBooksWerePublished(List<Book> bookList) {
        int sumOfYearsPublished = 0;
        for (Book book : bookList) {
            sumOfYearsPublished = sumOfYearsPublished + book.getYearOfPublication();
        }
        return sumOfYearsPublished;
    }

    public long numberOfBooksPublishedAfter(List<Book> bookList) {
        return bookList.stream().filter(book -> book.getYearOfPublication() > 20007).count();
    }

    public boolean allBooksPublishedAfter2000(List<Book> bookList) {
        for (Book book : bookList) {
            if (book.getYearOfPublication() < 2000) {
                return false;
            }
        }
        return true;
    }

    public int bookstoreAverageYearOfPublishing(List<Book> bookList) {
        int sumOfYears = sumOfYearsBooksWerePublished(bookList);
        return sumOfYears / bookList.size();
    }

    public boolean anyBookPublishedAfter2000(List<Book> bookList) {
        for (Book book : bookList) {
            if (book.getYearOfPublication() < 2000) {
                return true;
            }
        }
        return false;
    }

    public List<Book> allTitlesStartWithTandPublishedAfter2009(List<Book> bookList) {
        return bookList
                .stream()
                .filter(book -> book.getYearOfPublication() > 2009)
                .filter(book -> book.getTitle().charAt(0) == 'T').collect(Collectors.toList());
    }

    public void add100YearsToAllBooksPublishingYear(List<Book> bookList) {
        for (Book book : bookList) {
            book.setYearOfPublication(book.getYearOfPublication() + 100);
        }
    }

    public List<String> returnAllTitlesWhosePublishedYearIsMod2(List<Book> bookList) {
        List<String> list = new ArrayList<>();
        for (Book book : bookList) {
            if (book.getYearOfPublication() % 2 == 0) {
                list.add(book.getTitle());
            }
        }
        return list;
    }

    public static void main(String[] args) {

        List<Book> books = new ArrayList<>();
        BooksFunctions functions = new BooksFunctions();

        books.add(new Book("Clean Code", "0132350882", 2008));
        books.add(new Book("Effective Java", "0134685997", 2018));
        books.add(new Book("Test Driven Development", "0321146530", 2003));
        books.add(new Book("Patterns of Enterprise Application Architecture", "0321127420", 2002));
        books.add(new Book("Head First Design Patterns", "0596007124", 2004));
        books = functions.sortBooksByYearAscending(books);
        System.out.println(functions.getTwoLastBooks(books).toString());
        System.out.println(books);
    }
}
