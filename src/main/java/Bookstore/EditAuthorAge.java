package Bookstore;

public class EditAuthorAge {

    public static void editAuthorAge(){
        System.out.print("Wprowadż numer ID wybranego autora : ");
        String authorID = BookstoreApp.getStringInput(new PrintMenuNone());
        BookAuthor bookAuthor = BookAuthorList.getAuthorByID(authorID);
        System.out.println("Wprowadź nowy wiek autora : " + bookAuthor.toString());
        Integer newAge  = BookstoreApp.getIntegerInput(new PrintMenuNone());
        bookAuthor.setAuthorAge(newAge);
        updateAuthorRecord(bookAuthor);
    }

    private static void updateAuthorRecord(BookAuthor updateAuthor){
        int index;
        BookAuthorList bookAuthorList = BookAuthorList.getBookAuthorListInstance();
        for (BookAuthor bookAuthor : bookAuthorList.getBookAuthorItems()){
            index = bookAuthorList.getBookAuthorItems().indexOf(bookAuthor);
            if (bookAuthor.getAuthorID().equals(updateAuthor.getAuthorID())){
                bookAuthorList.getBookAuthorItems().set(index,bookAuthor);
            }
        }
    }
}
