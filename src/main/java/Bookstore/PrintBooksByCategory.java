package Bookstore;

import java.util.Optional;

public class PrintBooksByCategory {

    private PrintBooksByCategory(){
    }

    public static void printByCategoryID() {
        System.out.print("Wprowadż numer ID wybranej kategorii : ");
        String categoryID = BookstoreApp.getStringInput(new PrintMenuNone());
        Optional<BookCategory> bookCategory = BookCategoryList
                .getBookCategoryListInstance()
                .getBookCategoryItems()
                .stream()
                .filter(category -> category.getCategoryID().equals(categoryID))
                .findFirst();
        if (bookCategory.isPresent()){
            System.out.print("Lista książek dla kategorii : ");
            System.out.println(bookCategory.get().getCategoryName());
            for (Book book : BookList.getBookListInstance().getBookListItems()) {
                if (book.getCategory().getCategoryID().equals(categoryID)) {
                    System.out.println("   -  " + book.getTitle());
                }
            }
        } else {
            System.out.println("Nie znaleziono kategorii !!");
        }
    }
}
