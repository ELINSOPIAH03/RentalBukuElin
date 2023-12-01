package app;

import app.book.BookForLoan;
import app.member.Member;
import app.order.LoanBookOrder;
import app.repository.RepositoryBookForLoan;
import app.repository.RepositoryLoanBookOrder;
import app.repository.RepositoryMember;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static List<BookForLoan> temporaryBookList = new ArrayList<>();

    private static void addToTemporaryBookList(BookForLoan book) {
        temporaryBookList.add(book);
    }

    public static void main(String[] args) {
        RepositoryBookForLoan.addDummyBooksToRepository();
        int choice;
        do {
            displayMainMenu();
            System.out.print("Pilih menu: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Clear the newline character

            switch (choice) {
                case 1:
                    displayAllBookForLoan();
                    break;
                case 2:
                    performLoan();
                    break;
                case 3:
                    performReturn();
                    break;
                case 4:
                    displayAllLoanBookOrder();
                    break;
                case 0:
                    System.out.println("Terima kasih telah menggunakan aplikasi ini. Sampai jumpa!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan pilih lagi.");
            }
        } while (choice != 0);
    }

    private static void displayMainMenu() {
        System.out.println("Aplikasi Rental Buku Cucux");
        System.out.println("\n1. Data All Book For Loan");
        System.out.println("2. Loan");
        System.out.println("3. Return");
        System.out.println("4. Data All Loan Book Order");
        System.out.println("0. Exit");
        System.out.println("\n");
    }

    /**
     * This function to display all data for loan if you wanna see this output
     * choose option 2 or 1
     */
    private static void displayAllBookForLoan() {
        List<BookForLoan> allBooks = RepositoryBookForLoan.getAllBookForLoan();
        System.out.println("\nData All Book For Loan");
        System.out.println(
                "==============================================================================================");
        System.out.printf("%-4s%-15s%-50s%-20s%-6s\n", "No", "Book ID", "Title", "Author", "Stock");
        System.out.println(
                "==============================================================================================");

        int index = 1;
        for (BookForLoan book : allBooks) {
            System.out.printf("%-4s%-15s%-50s%-20s%-6s\n",
                    index++, book.getBookID(), book.getTitle(), book.getAuthor(), book.getStock());
        }

        System.out.println("\n0. Kembali Ke Main Menu\n");
    }

    private static void performLoan() {
        displayAllBookForLoan();
        System.out.print("Masukkan Member ID: ");
        String memberID = scanner.nextLine();
        System.out.print("Masukkan Book ID: ");
        String bookID = scanner.nextLine();
        System.out.print("Masukkan Lama Peminjaman: ");
        int loanDuration = scanner.nextInt();

        Member member = findMemberById(memberID);
        BookForLoan book = findBookForLoanById(bookID);

        if (member != null && book != null) {
            // Constructor
            book.calculateBookLoanPrice();
            LoanBookOrder loanOrder = new LoanBookOrder(generateLoanID(), member, book, loanDuration);
            RepositoryLoanBookOrder.addLoanOrder(loanOrder);
            System.out.println("\nLoan Success!\n");

            // Panggil metode untuk mengurangi stok buku setelah peminjaman
            RepositoryBookForLoan.reduceStockAfterLoan(book);

            // Tambahkan buku yang dipinjam ke temporaryBookList
            addToTemporaryBookList(book);
        } else {
            System.out.println("\nMember atau buku tidak ditemukan. Silakan coba lagi.\n");
        }
    }

    private static void performReturn() {
        displayAllLoanBookOrder();
        System.out.print("Masukkan Loan ID: ");
        String loanID = scanner.nextLine();

        LoanBookOrder loanOrder = RepositoryLoanBookOrder.findLoanOrderById(loanID);

        if (loanOrder != null) {
            RepositoryLoanBookOrder.removeLoanOrder(loanOrder);
            System.out.println("Return Book Success!");

            // Panggil metode untuk menambahkan stok buku setelah pengembalian
            RepositoryBookForLoan.increaseStockAfterReturn(loanOrder.getLoanBook());
        } else {
            System.out.println("\nLoan Order tidak ditemukan. Silakan coba lagi.\n");
        }
    }

    private static void displayAllLoanBookOrder() {
        List<LoanBookOrder> allLoanOrders = RepositoryLoanBookOrder.getAllLoanBookOrders();
        System.out.println("\nData All Loan Book Order");
        System.out.println(
                "=====================================================================================================================================");
        System.out.printf("%-4s%-10s%-20s%-10s%-40s%-20s%-15s%-10s\n",
                "No", "Loan ID", "Member Name", "Book ID", "Title", "Loan Book Price", "Loan Duration", "Loan Fee");
        System.out.println(
                "=====================================================================================================================================");

        int index = 1;
        for (LoanBookOrder loanOrder : allLoanOrders) {
            System.out.printf("%-4d%-10s%-20s%-10s%-40s%-,20.2f%-15d%-,10.2f\n",
                    index++, // This is Index of table
                    loanOrder.getLoanID(), // this isload id
                    loanOrder.getMember().getMemberName(), // member name
                    loanOrder.getLoanBook().getBookID(), // book id
                    loanOrder.getLoanBook().getTitle(), // title of book
                    loanOrder.getCurrentLoanBookPrice(),// loan book price
                    loanOrder.getLoanDuration(), // duration book
                    loanOrder.calculateLoanFee()); // final total fee
        }

        System.out.println("\n0. Kembali Ke Main Menu\n");
    }

    private static Member findMemberById(String memberID) {
        List<Member> allMembers = RepositoryMember.getAllMembers();
        for (Member member : allMembers) {
            if (member.getMemberID().equals(memberID)) {
                return member;
            }
        }
        return null;
    }

    public static BookForLoan findBookForLoanById(String bookID) {
        List<BookForLoan> allBooks = RepositoryBookForLoan.getAllBookForLoan();
        for (BookForLoan book : allBooks) {
            if (book.getBookID().equals(bookID)) {
                return book;
            }
        }
        return null;
    }

    private static String generateLoanID() {
        return "Ord-" + (RepositoryLoanBookOrder.getAllLoanBookOrders().size() + 1);
    }
}
