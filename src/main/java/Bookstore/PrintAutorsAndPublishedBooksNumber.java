package Bookstore;

import java.util.List;

public class PrintAutorsAndPublishedBooksNumber {

    private PrintAutorsAndPublishedBooksNumber(){
    }

    public static void printAutorsAndNumbers() {
        BookAuthorList bookAuthorList = BookAuthorList.getBookAuthorListInstance();
        for (BookAuthor author : bookAuthorList.getBookAuthorItems()){
            System.out.println(author.getAuthorNameFamilyName()+
                    " opublikował(a) "+
                    numberOfBooksPublishedByAuthor(BookList.getBookListInstance(),author)+
            " książki(ek)");
        }
    }

    private static int numberOfBooksPublishedByAuthor(BookList bookList, BookAuthor author){
        int count=0;
        for (Book book : bookList.getBookListItems()){
            if (book.getAuthorsList().stream().anyMatch(a->a.getAuthorID().equals(author.getAuthorID()))){
                count++;
            }
        }
     return count;
    }


}
