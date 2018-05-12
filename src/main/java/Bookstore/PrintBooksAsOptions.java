package Bookstore;

import java.util.List;
import java.util.Scanner;

public class PrintBooksAsOptions {

    public static void printBooks(List<Book> bookList) {

        System.out.println("Wybierz opcjędrukowania listy książek : ");
        System.out.println("0 - Wyjście   " + "1 - Rok, Tytuł, ISBN   " + "2 - Tytuł, Rok, ISBN   " + "3 - ISBN, Tytuł, Rok");
        PrintBooksChoices printToString = new PrintBooksYTI();
        int optionNumber;
        Scanner scanner = new Scanner(System.in);
        optionNumber = scanner.nextInt();
        while (optionNumber != 0) {
            switch (optionNumber) {
                case 0:
                    return;
                case 1:
                    break;
                case 2:
                    printToString = new PrintBooksTYI();
                    break;
                case 3 :
                    printToString = new PrintBooksITY();
                    break;
                default:
                    System.out.println("Niewłaściwa opcja. Wybierz jeszcze raz");
                    System.out.println();
                    break;
            }
            printToString.printBookList(bookList);
            System.out.println("Wybierz opcję drukowania listy książek : ");
            System.out.println("0-Wyjście   " + "1-Rok, Tytuł, ISBN   " + "2-Tytuł, Rok, ISBN   " + "3-ISBN, Tytuł, Rok");
            optionNumber = scanner.nextInt();
        }

    }
}
