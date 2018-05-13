package Bookstore;

import java.io.FileWriter;
import java.io.IOException;

public class WriteBooksToCSV {

    public static void booksWriterToCSV() throws IOException {

        String cSVFileName = "C:/Users/Robert/Ksiegarnia/src/main/resources/books.csv";
        char separator = ';';
        String lineToWrite;

        try (FileWriter fileWriter = new FileWriter(cSVFileName)) {
            for (Book book : BookList.getBookListInstance().getBookListItems()){
                lineToWrite = book.toString(separator) + "\n";
                fileWriter.append(lineToWrite);
            }
            fileWriter.flush();
        }
    }
}
