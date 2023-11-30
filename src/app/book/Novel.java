package app.book;

public class Novel extends BookForLoan {
    boolean isASeries;

    public Novel(String bookID, String title, String author, double bookPrice, int stock, boolean isASeries) {
        super(bookID, title, author, bookPrice, stock);
        calculateBookLoanPrice();
        this.isASeries = isASeries;
    }

    @Override
    protected double getRateBookType() {
        return 0.05;
    }

    // Getter method for Novel attribute
    public boolean isASeries() {
        return isASeries;
    }

    // Setter method for Novel attribute
    public void setASeries(boolean isASeries) {
        this.isASeries = isASeries;
    }

    @Override
    public String toString() {
        return "Novel{" +
                "bookID='" + bookID + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", bookPrice=" + bookPrice +
                ", bookLoanPrice=" + bookLoanPrice +
                ", stock=" + stock +
                ", isASeries=" + isASeries +
                '}';
    }
}
