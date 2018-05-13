package Bookstore;

import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import static Bookstore.WriteAuthorFileToCSV.authorWriterToCSV;

public class BookstoreApp {

    private static final PrintMenuMain printMenuMain = new PrintMenuMain();
    private static final PrintMenuNone printMenuNone = new PrintMenuNone();

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
        int input = getIntegerInput(printMenuMain);
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
                case 5:
                    System.out.println("Ilość książek publikowanych przed 2007 rokiem :");
                    System.out.println(bookFunctions
                            .numberOfBooksPublishedAfter2007(bookList.getBookListItems()));
                    break;
                case 6:
                    System.out.println("Lista tytułów publikowanych w latach parzystych : ");
                    System.out.println(bookFunctions
                            .returnAllTitlesWhosePublishedYearIsMod2(bookList.getBookListItems()));
                    break;
                case 7:
                    System.out.println("Lista tytułów publikowanych przed rokiem " + PrintPublishedBeforeYear.printBooksListPublishedBeforeYear());
                    break;
                case 8:
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
                case 12:
                    EditBookName.editBookName();
                    break;
                case 13:
                    try {
                        authorWriterToCSV();
                    } catch (IOException e) {
                        System.out.print("Plik nie zapisany z powodu błędu : ");
                        e.printStackTrace();
                    }
                    break;
                case 14:
                    System.out.print("Podaj numer ISBN książki do druku : ");
                    OrderBookPrint.chooseAndPrintBookByISBN(getStringInput(printMenuNone));
                    break;
                case 15:
                    EditAuthorAge.editAuthorAge();
                    break;
                case 16:
                    try {
                        WriteCategoriesToCSV.categoriesWriterToCSV();
                    } catch (IOException e) {
                        System.out.print("Plik nie zapisany z powodu błędu : ");
                        e.printStackTrace();
                    }
                    break;
                case 17:
                    PrintBooksByAuthor.printByAuthorsID();
                    break;
                case 18:
                    AddNewCategory.enterNewCategory();
                    break;
                case 19:
                    PrintBooksByCategory.printByCategoryID();
                    break;
                case 20:
                    printSalaries(setEmployees());
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

    public static List<BookstoreEmpoyee> setEmployees() {

        List<BookstoreEmpoyee> bookstoreEmpoyees = new ArrayList<>();

        bookstoreEmpoyees.add(new BookstoreManager("Zenon", "Laskowski", "zenonlaskowski@gmail.com", 34, 'M', 600347222, 21));
        bookstoreEmpoyees.add(new BookstoreManager("Alicja", "kowalska", "alicjakowalska@gmail.com", 24, 'F', 600347223, 20));
        bookstoreEmpoyees.add(new BookstoreSalesPerson("Alicja", "Jóźwiak", "alicjajozwiak@gmail.com", 40, 'F', 2800));
        bookstoreEmpoyees.add(new BookstoreSalesPerson("Marek", "Stachowiak", "marekstachowiak@gmail.com", 29, 'M', 2800));
        bookstoreEmpoyees.add(new BookstoreSalesPerson("Stanisław", "Rybak", "stanislawrybak@gmail.com", 36, 'M', 3100));
        bookstoreEmpoyees.add(new BookstoreSalesPerson("Zofia", "Stachura", "zofiastachura@gmail.com", 32, 'F', 2500));
        bookstoreEmpoyees.add(new BookstoreIntern("Katarzyna", "Stachurska", "katarzynastachurska@gmail.com", 23, 'F', 12));
        bookstoreEmpoyees.add(new BookstoreIntern("Ryszard", "Lubecki", "ryszardlubecki@gmail.com", 22, 'M', 12));

        return bookstoreEmpoyees;
    }

    public static void printSalaries(List<BookstoreEmpoyee> bookstoreEmpoyees) {
        bookstoreEmpoyees.stream()
                .forEach(bookstoreEmpoyee -> System.out.println(bookstoreEmpoyee.getFirstName() + " " + bookstoreEmpoyee.getFamilyName() + " wypłata " + bookstoreEmpoyee.getSalaryInformation(160)));

    }
}
