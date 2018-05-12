package Bookstore;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ImportCategoriesFromFile {

    private ImportCategoriesFromFile() {
    }

    public static BookCategoryList importFromCSV() {

        String csvCategoryFile = "categories.csv";
        String line = "";
        final String SEMICOLON = ";";

        BookCategoryList categoryList = BookCategoryList.getBookCategoryListInstance();
        BufferedReader csvCategoryReader = new BufferedReader(new InputStreamReader(ClassLoader.getSystemResourceAsStream(csvCategoryFile)));
        try {
            line = csvCategoryReader.readLine();
        } catch (IOException e) {
            System.out.println("Błąd odczytu");
        }

        while (line != null) {
            String[] lineElements = line.split(SEMICOLON);
            BookCategory bookCategory = new BookCategory(lineElements[0], lineElements[1], Integer.parseInt(lineElements[2]));
            categoryList.addBookCategory(bookCategory);
            try {
                line = csvCategoryReader.readLine();
            } catch (IOException e) {
                System.out.println("Błąd odczytu");
            }
        }
        return categoryList;
    }
}
