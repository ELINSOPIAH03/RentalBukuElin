package app.book;

public class Comic extends BookForLoan {
    String genre;

    public Comic(String bookID, String title, String author, double bookPrice, int stock, String genre) {
        super(bookID, title, author, bookPrice, stock);
        calculateBookLoanPrice();
        this.genre = genre;
    }

    @Override
    protected double getRateBookType() {
        return 0.1;
    }

    // Getter method for Comic attribute
    public String getGenre() {
        return genre;
    }

    // Setter method for Comic attribute
    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "Comic{" +
                "bookID='" + bookID + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", bookPrice=" + bookPrice +
                ", bookLoanPrice=" + bookLoanPrice +
                ", stock=" + stock +
                ", genre='" + genre + '\'' +
                '}';
    }
}
