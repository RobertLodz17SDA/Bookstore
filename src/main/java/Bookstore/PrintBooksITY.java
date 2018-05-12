package Bookstore;

import java.util.List;

public class PrintBooksITY implements PrintBooksChoices {

    public void printBookList(List<Book> bookList) {
        bookList.forEach(book -> System.out.println("ISBN : " + book.getNumberISBN() + "   Tytuł : \'" + book.getTitle() + '\'' +
                "   Rok publikacji : " + book.getYearOfPublication()));
    }
}