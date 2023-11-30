package app.repository;

import app.book.BookForLoan;
import app.book.Comic;
import app.book.Novel;
import java.util.ArrayList;
import java.util.List;

public class RepositoryBookForLoan {
    private static List<BookForLoan> allBookForLoan = new ArrayList<>();

    public static List<BookForLoan> getAllBookForLoan() {
        return allBookForLoan;
    }

    // Metode tambahan untuk menambahkan buku ke daftar
    public static void addBookForLoan(BookForLoan book) {
        allBookForLoan.add(book);
    }

    // Metode tambahan untuk menghapus buku dari daftar
    public static void removeBookForLoan(BookForLoan book) {
        allBookForLoan.remove(book);
    }

    // Metode tambahan untuk mencari buku berdasarkan ID
    public static BookForLoan findBookForLoanById(String bookID) {
        for (BookForLoan book : allBookForLoan) {
            if (book.getBookID().equals(bookID)) {
                return book;
            }
        }
        return null;
    }

    public static List<Comic> getAllComicBooks() {
        List<Comic> comicBooks = new ArrayList<>();
        // Tambahkan data comic dummy
        comicBooks.add(new Comic("Comic-001", "Uzumaki Naruto", "Masashi Kisimoto", 55000, 10, "Shounen"));
        comicBooks.add(new Comic("Comic-002", "The Worst Client", "Masashi Kisimoto", 35000, 20, "Shounen"));
        comicBooks.add(new Comic("Comic-003", "For the Sake of Dreams...!!", "Masashi Kisimoto", 35000, 15, "Shounen"));
        comicBooks.add(new Comic("Comic-004", "Hunter X Hunter : The Day of Departure", "Yoshihiro Togashi", 50000, 15,
                "Fantasy"));
        comicBooks.add(new Comic("Comic-005", "Hunter X Hunter : A Struggle in the Mist", "Yoshihiro Togashi", 80000,
                25, "Fantasy"));
        return comicBooks;
    }

    public static List<Novel> getAllNovelBooks() {
        List<Novel> novelBooks = new ArrayList<>();
        // Tambahkan data novel dummy
        novelBooks.add(
                new Novel("Novel-001", "Harry Potter and the Philosopher's Stone", "J.K Rowling", 150000, 10, true));
        novelBooks.add(
                new Novel("Novel-002", "Harry Potter and the Chamber of Secrets", "J.K Rowling", 150000, 10, true));
        novelBooks.add(
                new Novel("Novel-003", "Harry Potter and the Prisoner of Azkaban", "J.K Rowling", 200000, 15, true));
        novelBooks.add(new Novel("Novel-004", "Ayah Aku Berbeda", "Tere Liye", 35000, 15, false));
        novelBooks.add(new Novel("Novel-005", "Madre", "Dee Lestari", 80000, 10, false));
        return novelBooks;
    }

    public static void addDummyBooksToRepository() {
        List<Comic> comicBooks = getAllComicBooks();
        List<Novel> novelBooks = getAllNovelBooks();

        for (Comic comic : comicBooks) {
            addBookForLoan(comic);
        }

        for (Novel novel : novelBooks) {
            addBookForLoan(novel);
        }
    }     

    // Metode untuk mengurangi stok buku setelah peminjaman
    public static void reduceStockAfterLoan(BookForLoan book) {
        book.setStock(book.getStock() - 1);
    }

    // Metode untuk menambahkan stok buku setelah pengembalian
    public static void increaseStockAfterReturn(BookForLoan book) {
        book.setStock(book.getStock() + 1);
    }

}
