package Bookstore;

import java.util.Optional;

public class PrintBooksByAuthor {

    private PrintBooksByAuthor(){
    }

    public static void printByAuthorsID() {
        System.out.print("Wprowadż numer ID wybranego autora : ");
        String authorID = BookstoreApp.getStringInput(new PrintMenuNone());
        Optional<BookAuthor> bookAuthor = BookAuthorList
                .getBookAuthorListInstance()
                .getBookAuthorItems()
                .stream()
                .filter(author -> author.getAuthorID().equals(authorID))
                .findFirst();
        if (bookAuthor.isPresent()){
            System.out.print("Lista książek autora : ");
            System.out.println(bookAuthor.get().getAuthorNameFamilyName());
            for (Book book : BookList.getBookListInstance().getBookListItems()) {
                if (book.getAuthorsList().stream().anyMatch(author -> author.getAuthorID().equals(authorID))) {
                    System.out.println("   -  " + book.getTitle());
                }
            }
        } else {
            System.out.println("Nie znaleziono autora !!");
        }
    }
}