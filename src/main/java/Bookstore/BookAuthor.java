package Bookstore;

public class BookAuthor {

    private String authorID;
    private String authorNameFamilyName;

    public void setAuthorAge(int authorAge) {
        this.authorAge = authorAge;
    }

    private int authorAge;

    public BookAuthor(String authorID, String authorName, int authorAge) {
        this.authorID = authorID;
        this.authorNameFamilyName = authorName;
        this.authorAge = authorAge;
    }

    public BookAuthor(){

    }

    public String toString(){
        return "ID : "+this.authorID+ "  Imię i Nazwisko : "+ this.authorNameFamilyName + "   Wiek :" + this.authorAge;
    }

    public String toString(char separator){
        return this.getAuthorID() + separator + this.getAuthorNameFamilyName() + separator + this.getAuthorAge();
    }
    public String getAuthorID() {
        return authorID;
    }

    public String getAuthorNameFamilyName() {

        return authorNameFamilyName;
    }

    public int getAuthorAge() {

        return authorAge;
    }
}
