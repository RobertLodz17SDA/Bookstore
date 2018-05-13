package Bookstore;

public class AddNewCategory {

    public static BookCategory enterNewCategory() {
        System.out.print("Podaj unikalny identyfikator kategorii : ");
        String categoryID = BookstoreApp.getStringInput(new PrintMenuNone());
        if (BookCategoryList
                .getBookCategoryListInstance()
                .getBookCategoryItems()
                .stream()
                .anyMatch(category -> category.getCategoryID().equals(categoryID))) {
            System.out.println("Podana kategoria już istnieje. Nie można utworzyć nowej kategorii.");
            return null;
        } else {
            System.out.print("Podaj nazwę kategorii : ");
            String categoryName = BookstoreApp.getStringInput(new PrintMenuNone());
            System.out.print("podaj priorytet kategorii :");
            int categoryPriority = BookstoreApp.getIntegerInput(new PrintMenuNone());
            BookCategory newCategory = new BookCategory(categoryID, categoryName, categoryPriority);
            return newCategory;
        }
    }

    public static void putCategoryToList(BookCategory newCategory) {
        if (newCategory != null) {
            BookCategoryList
                    .getBookCategoryListInstance()
                    .getBookCategoryItems()
                    .add(newCategory);
        }
    }
}
