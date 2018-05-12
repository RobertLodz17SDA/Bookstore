package Bookstore;

import java.util.List;

public class PrintBooksYTI implements PrintBooksChoices {

    public void printBookList(List<Book> bookList) {

        bookList.forEach(book -> System.out.println("Rok publikacji : " + book.getYearOfPublication() + "   Tytuł : \'" + book.getTitle() + '\'' +
                "   ISBN : " + book.getNumberISBN()));
    }
}
