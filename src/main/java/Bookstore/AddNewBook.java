package Bookstore;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddNewBook {

    public static void enterNewBook() {

        PrintMenuNone printMenuNone = new PrintMenuNone();
        System.out.print("Podaj unikalny ISBN książki : ");
        String bookISBN = BookstoreApp.getStringInput(printMenuNone);
        if (BookList.getBookListInstance().getBookListItems().stream().anyMatch(book -> book.getNumberISBN().equals(bookISBN))) {
            System.out.println("Podana o tym numerze ISBN już istnieje. Nie można utworzyć nowej książki.");
        } else {
            System.out.print("Podaj tytuł książki :");
            String title = BookstoreApp.getStringInput(printMenuNone);
            System.out.print("Podaj rok publikacji :");
            int year = BookstoreApp.getIntegerInput(printMenuNone);
            System.out.print("Podaj rodzaj okładki :");
            char cover = BookstoreApp.getStringInput(printMenuNone).charAt(0);
            System.out.print("Podaj identyfikator autora ( ENTER - wyjście ) :");
            String autorInput = BookstoreApp.getStringInput(printMenuNone);
            List<BookAuthor> authors = new ArrayList();
            while (autorInput != "") {
                if (BookAuthorList.authorExists(autorInput)) {
                    String finalAutorInput = autorInput;
                    BookAuthor bookAuthor = BookAuthorList
                            .getBookAuthorListInstance()
                            .getBookAuthorItems()
                            .stream()
                            .filter(aut -> finalAutorInput.equals(aut.getAuthorID())).findFirst().get();
                    authors.add(bookAuthor);
                    System.out.print("Podaj identyfikator autora ( ENTER - wyjście ) :");
                    autorInput = BookstoreApp.getStringInput(printMenuNone);
                } else {
                    System.out.println("Autor nieznany. Wprowadż autora do bazy ");
                }
                autorInput = BookstoreApp.getStringInput(printMenuNone);
            }
            System.out.print("Podaj numer kategorii książki :");
            String categoryID = BookstoreApp.getStringInput(printMenuNone);
            BookCategory category;
            if (BookCategoryList.getBookCategoryListInstance().getBookCategoryItems().stream().anyMatch(cat -> cat.getCategoryID().equals(categoryID))) {
                category = BookCategoryList
                        .getBookCategoryListInstance()
                        .getBookCategoryItems()
                        .stream()
                        .filter(category1 -> category1.getCategoryID().equals(categoryID))
                        .findFirst()
                        .get();
            } else {
                category = AddNewCategory.enterNewCategory();
            }
            Book newBook = new Book(title, bookISBN, year, cover, authors, category);
            BookList.getBookListInstance().addBook(newBook);
        }
    }
}
