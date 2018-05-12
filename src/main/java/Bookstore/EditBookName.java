package Bookstore;

public class EditBookName {

    public static void editBookName(){
        System.out.print("Wprowadż numer ISBN książki do zmiany nazwy : ");
        String numberISBN = BookstoreApp.getStringInput(new PrintMenuNone());
        Book bookToEditName = BooksFunctions.findBookByISBN(BookList.getBookListInstance().getBookListItems(),numberISBN);
        System.out.print("Wprowadż nowy tytuł książki : ");
        String newTitle  = BookstoreApp.getStringInput(new PrintMenuNone());
        bookToEditName.setTitle(newTitle);
        replaceBookRecord(bookToEditName);
    }

    private static void replaceBookRecord(Book newBook){
        int index;
        BookList bookList = BookList.getBookListInstance();
        for (Book book : bookList.getBookListItems()){
            index = bookList.getBookListItems().indexOf(book);
            if (book.getNumberISBN().equals(newBook.getNumberISBN())){
                bookList.getBookListItems().set(index,newBook);
            }
        }
    }
}
