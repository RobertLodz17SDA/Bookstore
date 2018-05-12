package Bookstore;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ImportAuthorsFromFile {

    public static BookAuthorList importFromCSV() {

        String csvAuthorFile = "authors.csv";
        String line = "";
        final String SEMICOLON = ";";

        BookAuthorList authorList = BookAuthorList.getBookAuthorListInstance();
        BufferedReader csvAuthorReader = new BufferedReader(new InputStreamReader(ClassLoader.getSystemResourceAsStream(csvAuthorFile)));
        try {
            line = csvAuthorReader.readLine();
        } catch (IOException e) {
            System.out.println("Błąd odczytu");
        }
        while (line != null) {
            String[] lineElements = line.split(SEMICOLON);
            BookAuthor bookAuthor = new BookAuthor(lineElements[0], lineElements[1], Integer.parseInt(lineElements[2]));
            authorList.addBookAuthor(bookAuthor);
            try {
                line = csvAuthorReader.readLine();
            } catch (IOException e) {
                System.out.println("Błąd odczytu");
            }
        }
        return authorList;
    }
}
