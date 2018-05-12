package Bookstore;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import static Bookstore.WriteAuthorFileToCSV.authorWriterToCSV;

public class BookstoreApp {

    public static void main(String[] args) {

        BookAuthorList bookAuthorList = ImportAuthorsFromFile.importFromCSV();
        BookCategoryList bookCategoryList = ImportCategoriesFromFile.importFromCSV();
        BookList bookList = ImportBookFromFile.csvBookImport();
        BooksFunctions bookFunctions = new BooksFunctions();

        bookstoreMenu(bookAuthorList, bookCategoryList, bookList, bookFunctions);
        System.out.println("Dziękujemy za korzystanie z Księgarni :-)");
    }

    private static void bookstoreMenu(BookAuthorList bookAuthorList,
                                      BookCategoryList bookCategoryList,
                                      BookList bookList,
                                      BooksFunctions bookFunctions) {
        int input = getIntegerInput(new PrintMenuMain());
        while (input != 0) {
            switch (input) {
                case 1:
                    System.out.println("Lista dostępnych książek : ");
                    bookList.printBookList();
                    break;
                case 2:
                    System.out.println("Lista dostępnych autorów : ");
                    bookAuthorList.printBookAurhorList();
                    break;
                case 3:
                    System.out.println("Lista dostępnych kategorii : ");
                    bookCategoryList.printCategoryList();
                    break;
                case 4:
                    System.out.println("Najwcześniej publikowana książka to : ");
                    System.out.println(bookFunctions
                            .getEarliestPublishedBook(bookList.getBookListItems())
                            .getTitle());
                    break;
                case 5 :
                    System.out.println("Ilość książek publikowanych przed 2007 rokiem :" );
                    System.out.println(bookFunctions
                            .numberOfBooksPublishedAfter2007(bookList.getBookListItems()));
                    break;
                case 6 :
                    System.out.println("Lista tytułów publikowanych w latach parzystych : ");
                    System.out.println(bookFunctions
                            .returnAllTitlesWhosePublishedYearIsMod2(bookList.getBookListItems()));
                    break;
                case 7 :
                    System.out.println("Lista tytułów publikowanych przed rokiem "+PrintPublishedBeforeYear.printBooksListPublishedBeforeYear());
                    break;
                case 8 :
                    PrintBooksAsOptions.printBooks(bookList.getBookListItems());
                    break;
                case 9:
                    System.out.println("Lista tytułów w kategorii wzorce projektowe :");
                    bookList.getBookListItems()
                            .stream()
                            .filter(book -> book.getCategory().getCategoryID().equals("2"))
                            .forEach(System.out::println);
                    break;
                case 10:
                    bookAuthorList.addNewAuthor();
                    break;
                case 11:
                    PrintAutorsAndPublishedBooksNumber.printAutorsAndNumbers();
                    break;
                case 12 :
                    EditBookName.editBookName();
                    break;
                case 13 :
                    try {
                        authorWriterToCSV();
                    } catch (IOException e) {
                        System.out.print("Plik nie zapisany z powodu błędu : ");
                        e.printStackTrace();
                    }
                    break;
                case 14 :
                    System.out.print("Podaj numer ISBN książki do druku : ");
                    OrderBookPrint.chooseAndPrintBookByISBN(getStringInput(new PrintMenuNone()));
                    break;
                case 15 :
                    EditAuthorAge.editAuthorAge();
                    break;
                case 16 :
                    try {
                        WriteCategoriesToCSV.categoriesWriterToCSV();
                    } catch (IOException e) {
                        System.out.print("Plik nie zapisany z powodu błędu : ");
                        e.printStackTrace();
                    }
                    break;
                case 17 :
                    PrintBooksByAuthor.printByAuthorsID();
                    break;
                case 18 :
                    AddNewCategory.enterNewCategory();
                    break;
                case 19 :
                    PrintBooksByCategory.printByCategoryID();
                    break;
                default:
                    System.out.println("Niewłaściwa opcja. Wybierz jeszcze raz");
                    System.out.println();
                    break;
            }
            input = getIntegerInput(new PrintMenuMain());
        }
    }

    public static int getIntegerInput(PrintMenuChoice printMenuChoice) {
        int option;
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println();
            printMenuChoice.printMenu();
            try {
                option = scanner.nextInt();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Niepoprawna opcja. Spróbuj jeszcze raz.");
            }
        }
        return option;
    }

    public static String getStringInput(PrintMenuChoice printMenuChoice) {
        String option;
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println();
            printMenuChoice.printMenu();
            try {
                option = scanner.nextLine();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Niepoprawna opcja. Spróbuj jeszcze raz.");
            }
        }
        return option;
    }


}
