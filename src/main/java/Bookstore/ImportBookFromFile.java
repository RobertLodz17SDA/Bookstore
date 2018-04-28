package Bookstore;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ImportBookFromFile {

    private String csvFile = "books.csv";
    private String line = "";
    private static final String SEMICOLON = ";";


    public BookList csvReader() {

        BookList bookList = BookList.getBookListInstance();
        BufferedReader csvReader = new BufferedReader(new InputStreamReader(ClassLoader.getSystemResourceAsStream(csvFile)));
        try {
            line = csvReader.readLine();
            System.out.println(line);
        } catch (IOException e) {
            System.out.println("bład odczytu");
        }

        while (line != null) {
            String[] lineElements = line.split(SEMICOLON);
            Book ksiazka = new Book(lineElements[0], Integer.parseInt(lineElements[1]), Integer.parseInt(lineElements[2]));
            bookList.addBook(ksiazka);
            try {
                line = csvReader.readLine();
            } catch (IOException e) {
                System.out.println("bład odczytu");
            }
        }
        return bookList;
    }
}