package app.book;

import interfaces.Loanable;

public class BookForLoan extends Book implements Loanable {
    double bookLoanPrice;
    int stock;

    public BookForLoan(String bookID, String title, String author, double bookPrice, int stock) {
        super(bookID, title, author, bookPrice);
        calculateBookLoanPrice();
        this.stock = stock;
    }

    @Override
    public void calculateBookLoanPrice() {
        double rateStockPercentage = 0.0;
        
        if (stock >= 10) {
            rateStockPercentage = 0.03;
        }
        else {
            rateStockPercentage = 0.05;
        }
        double resultCalculate = (rateStockPercentage + getRateBookType()) * bookPrice;
        // return;
        setBookLoanPrice(resultCalculate);
    }

    // Getter methods for BookForLoan attributes
    public double getBookLoanPrice() {
        return bookLoanPrice;
    }

    public int getStock() {
        return stock;
    }

    // Setter methods for BookForLoan attributes
    public void setBookLoanPrice(double bookLoanPrice) {
        this.bookLoanPrice = bookLoanPrice;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    // This method should be overridden by subclasses
    protected double getRateBookType() {
        return 0.0;
    }

    @Override
    public String toString() {
        return "BookForLoan{" +
                "bookID='" + bookID + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", bookPrice=" + bookPrice +
                ", bookLoanPrice=" + bookLoanPrice +
                ", stock=" + stock +
                '}';
    }

}
