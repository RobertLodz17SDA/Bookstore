package Bookstore;

import java.io.FileWriter;
import java.io.IOException;

class WriteAuthorFileToCSV {

    static void authorWriterToCSV() throws IOException {

        String cSVFileName = "C:/Users/Robert/Ksiegarnia/src/main/resources/authors.csv";
        char separator = ';';
        String lineToWrite;

        try (FileWriter fileWriter = new FileWriter(cSVFileName)) {
            for (BookAuthor bookAuthor : BookAuthorList
                    .getBookAuthorListInstance().getBookAuthorItems()) {
                lineToWrite = bookAuthor.toString(separator) + "\n";
                fileWriter.append(lineToWrite);
            }
            fileWriter.flush();
        }
    }
}
