package Bookstore;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class BookstoreApp {

    public static void main(String[] args) {

        BookList bookList;
        ImportBookFromFile importBookFromFile = new ImportBookFromFile();
        bookList = importBookFromFile.csvReader();

        Scanner scanner = new Scanner(System.in);
        int input = getInput(scanner);
        while (input != 1) {
            switch (input) {
                case 1:
                    System.out.println("Dziękujemy za korzystanie z Księgarni :-)");
                    break;
                case 2:
                    bookList.printBookList();
                    break;
                default:
                    System.out.println("Niewłaściwa opcja. Wybierz jeszcze raz");
                    System.out.println();
                    break;
            }
            input = getInput(scanner);
        }
    }

    private static int getInput(Scanner scanner) {

        int option;
        while (true) {
            printMenu();
            try {
                scanner = new Scanner(System.in);
                option = scanner.nextInt();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Niepoprawna opcja. Spróbuj jeszcze raz.");
            }
        }
        return option;
    }

    public static void printMenu() {
        System.out.println("Księgarnia SDA");
        System.out.println("ul. Książkowa 12");
        System.out.println("email : ksiegarnia@sda.pl");
        System.out.println();
        System.out.print("Wybierz opcję programu : ");
        System.out.print("1-Wyjście z programu  ");
        System.out.print("2-Lista dostępnych pozycji  ");
        System.out.println();
    }
}
