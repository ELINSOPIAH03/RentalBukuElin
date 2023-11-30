package app.book;


/**
 * Book
 */
public class Book {
    String bookID;
    String title;
    String author;
    double bookPrice;

    public Book(String bookID, String title, String author, double bookPrice) {
        this.bookID = bookID;
        this.title = title;
        this.author = author;
        this.bookPrice = bookPrice;
    }

    // Getter methods (add more if needed)
    public String getBookID() {
        return bookID;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public double getBookPrice() {
        return bookPrice;
    }

    // Setter methods (add more if needed)
    public void setBookID(String bookID) {
        this.bookID = bookID;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setBookPrice(double bookPrice) {
        this.bookPrice = bookPrice;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookID='" + bookID + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", bookPrice=" + bookPrice +
                '}';
    }
    
}