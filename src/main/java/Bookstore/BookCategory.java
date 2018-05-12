package Bookstore;

public class BookCategory {

    private String categoryID;
    private String categoryName;
    private int categoryPriority;

    public BookCategory(String categoryID, String categoryName, int categoryPriority) {
        this.categoryID = categoryID;
        this.categoryName = categoryName;
        this.categoryPriority = categoryPriority;
    }

    public BookCategory(){

    }

    public String toString(){
        return "Kategori : "+this.categoryID+ "  Nazwa : "+ this.categoryName+ "  Priorytet : "+ this.categoryPriority;
    }

    public String toString(char separator){
        return this.categoryID+ separator + this.categoryName+ separator+ this.categoryPriority;
    }

    public String getCategoryID() {
        return categoryID;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public int getCategoryPriority() {
        return categoryPriority;
    }
}
