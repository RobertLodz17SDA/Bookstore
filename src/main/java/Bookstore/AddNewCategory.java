package Bookstore;

public class AddNewCategory {

    public static void enterNewCategory(){
        System.out.print("Podaj unikalny identyfikator kategorii : ");
        String categoryID = BookstoreApp.getStringInput(new PrintMenuNone());
        if (BookCategoryList
                .getBookCategoryListInstance()
                .getBookCategoryItems()
                .stream()
                .anyMatch(category ->category.getCategoryID().equals(categoryID))) {
            System.out.println("Podana kategoria już istnieje. Nie można utworzyć nowej kategorii.");
        } else {
            System.out.print("Podaj nazwę kategorii : ");
            String categoryName = BookstoreApp.getStringInput(new PrintMenuNone());
            System.out.print("podaj priorytet kategorii :");
            int categoryPriority = BookstoreApp.getIntegerInput(new PrintMenuNone());
            BookCategory newCategory = new BookCategory(categoryID, categoryName, categoryPriority);
            BookCategoryList
                    .getBookCategoryListInstance()
                    .getBookCategoryItems()
                    .add(newCategory);
        }
    }
}
