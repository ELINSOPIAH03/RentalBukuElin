package app.info;

import app.book.BookForLoan;

public class LoanableBookInfo {
    private BookForLoan book;
    private int availableStock;

    public LoanableBookInfo(BookForLoan book) {
        this.book = book;
        this.availableStock = book.getStock();
    }

    public BookForLoan getBook() {
        return book;
    }

    public int getAvailableStock() {
        return availableStock;
    }

    public void reduceStock() {
        if (availableStock > 0) {
            availableStock--;
        }
    }

    public void increaseStock() {
        availableStock++;
    }

    public double calculateBookLoanPrice() {
        return 0;
    }

    // public double getBookLoanPrice() {
    //     double rateStockPercentage = (availableStock >= 10) ? 0.03 : 0.05;
    //     return (1 + rateStockPercentage + book.getRateBookType()) * book.getBookPrice();
    // }
}
