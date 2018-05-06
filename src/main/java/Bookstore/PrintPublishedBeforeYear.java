package Bookstore;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PublishedBeforeYear {

    private BookList bookList = BookList.getBookListInstance();

    public void getBooksListBeforeYear() {
        int year;
        Scanner scanner= new Scanner(System.in);
        while (true) {
            try {
                System.out.print("Podaj rok graniczny : ");
                year = scanner.nextInt();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Niepoprawna opcja. Spróbuj jeszcze raz.");
            }
        }
        System.out.println("Książki wydane przed rokiem " + year);
        int finalYear = year;
        List<Book> filteredBooks = bookList.getBookListItems()
                .stream()
                .filter(e -> e.getYearOfPublication() <= finalYear)
                .collect(Collectors.toList());

        if (filteredBooks.isEmpty()) {
            System.out.println("Nie znaleziono książek wydanych przed rokiem " + year);
        }else{
            filteredBooks.forEach(System.out::println);
        }
    }
}
