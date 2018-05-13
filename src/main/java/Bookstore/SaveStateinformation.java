package Bookstore;

import java.io.IOException;

import static Bookstore.WriteAuthorFileToCSV.authorWriterToCSV;

public class SaveStateinformation {

    public static void saveStateInfo() {

        try {
            authorWriterToCSV();
        } catch (IOException e) {
            System.out.print("Plik autorów nie zapisany z powodu błędu : ");
            e.printStackTrace();
        }
        try {
            WriteCategoriesToCSV.categoriesWriterToCSV();
        } catch (IOException e) {
            System.out.print("Plik kategorii nie zapisany z powodu błędu : ");
            e.printStackTrace();
        }
        try {
            WriteBooksToCSV.booksWriterToCSV();
        } catch (IOException e) {
            System.out.print("Plik książek nie zapisany z powodu błędu : ");
            e.printStackTrace();
        }
    }
}
