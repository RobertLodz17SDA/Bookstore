package Bookstore;

import java.io.FileWriter;
import java.io.IOException;

class WriteCategoriesToCSV {

    static void categoriesWriterToCSV() throws IOException {

        String cSVFileName = "C:/Users/Robert/Ksiegarnia/src/main/resources/categories.csv";
        char separator = ';';
        String lineToWrite;

        try (
                FileWriter fileWriter = new FileWriter(cSVFileName)) {
            for (BookCategory bookCategory : BookCategoryList.getBookCategoryListInstance().getBookCategoryItems()) {
                lineToWrite = bookCategory.toString(separator) + "\n";
                fileWriter.append(lineToWrite);
            }
            fileWriter.flush();
        }
    }
}


