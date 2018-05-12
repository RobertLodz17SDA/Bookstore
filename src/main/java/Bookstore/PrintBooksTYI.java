package Bookstore;

import java.util.List;

public class PrintBooksTYI implements PrintBooksChoices {

    public void printBookList(List<Book> bookList) {

        bookList.forEach(book -> System.out.println("Tytuł : \'" + book.getTitle() + '\'' +
                "   Rok publikacji : " + book.getYearOfPublication() +
                "   ISBN : " + book.getNumberISBN()));
    }
}