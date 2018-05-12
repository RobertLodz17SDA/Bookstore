package Bookstore;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ImportBookFromFile {

    private ImportBookFromFile(){
    }

    public static BookList csvBookImport() {

        String csvFile = "books.csv";
        String line = "";
        final String SEMICOLON = ";";

        BookList bookList = BookList.getBookListInstance();
        BufferedReader csvReader = new BufferedReader(new InputStreamReader(ClassLoader.getSystemResourceAsStream(csvFile)));
        try {
            line = csvReader.readLine();
        } catch (IOException e) {
            System.out.println("Błąd odczytu");
        }
        while (line != null) {
            String[] lineElements = line.split(SEMICOLON);
            String[] lineAuthors = lineElements[4].split(",");
            List<BookAuthor> authorsList = new ArrayList<>();
            for (String authors : lineAuthors) {
                authorsList.add(BookAuthorList.getBookAuthorListInstance().getAuthorByID(authors));
            }
            BookCategoryList categoryList = BookCategoryList.getBookCategoryListInstance();
            BookCategory category = new BookCategory();
            if (categoryList.getBookCategoryItems()
                    .stream()
                    .anyMatch(catItem ->catItem.getCategoryID().equals(lineElements[5]))) {
                category = categoryList.getBookCategoryItems()
                        .stream()
                        .filter(catItem -> catItem.getCategoryID().equals(lineElements[5]))
                        .findFirst().get();
            }
            Book singleBook = new Book(lineElements[0], lineElements[1], Integer.parseInt(lineElements[2]), lineElements[3].charAt(0), authorsList, category);
            bookList.addBook(singleBook);
            try {
                line = csvReader.readLine();
            } catch (IOException e) {
                System.out.println("Błąd odczytu");
            }
        }
        return bookList;
    }
}