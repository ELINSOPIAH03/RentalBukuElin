    package app.order;

    import app.member.Member;
    import app.book.BookForLoan;

    public class LoanBookOrder {
        String loanID;
        Member member;
        BookForLoan loanBook;
        int loanDuration;
        double currentLoanBookPrice;

        public LoanBookOrder(String loanID, Member member, BookForLoan loanBook, int loanDuration) {
            this.loanID = loanID;
            this.member = member;
            this.loanBook = loanBook;
            this.loanDuration = loanDuration;
            this.currentLoanBookPrice = loanBook.getBookLoanPrice();
        }

        public double calculateLoanFee() {
            return loanDuration * currentLoanBookPrice;
        }

        // Getter methods for LoanBookOrder attributes
        public String getLoanID() {
            return loanID;
        }

        public Member getMember() {
            return member;
        }

        public BookForLoan getLoanBook() {
            return loanBook;
        }

        public int getLoanDuration() {
            return loanDuration;
        }

        public double getCurrentLoanBookPrice(){
            return currentLoanBookPrice;
        }

        // Setter methods for LoanBookOrder attributes
        public void setLoanID(String loanID) {
            this.loanID = loanID;
        }

        public void setMember(Member member) {
            this.member = member;
        }

        public void setLoanBook(BookForLoan loanBook) {
            this.loanBook = loanBook;
        }

        public void setLoanDuration(int loanDuration) {
            this.loanDuration = loanDuration;
        }

        @Override
        public String toString() {
            return "LoanBookOrder{" +
                    "loanID='" + loanID + '\'' +
                    ", member=" + member +
                    ", loanBook=" + loanBook +
                    ", loanDuration=" + loanDuration +
                    '}';
        }
    }
