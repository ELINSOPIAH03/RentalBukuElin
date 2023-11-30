package app.repository;

import app.order.LoanBookOrder;

import java.util.ArrayList;
import java.util.List;

public class RepositoryLoanBookOrder {
    private static List<LoanBookOrder> allLoanBookOrders = new ArrayList<>();

    public static List<LoanBookOrder> getAllLoanBookOrders() {
        return allLoanBookOrders;
    }

    public static void addLoanOrder(LoanBookOrder loanOrder) {
        allLoanBookOrders.add(loanOrder);
    }

    public static void removeLoanOrder(LoanBookOrder loanOrder) {
        allLoanBookOrders.remove(loanOrder);
    }

    public static LoanBookOrder findLoanOrderById(String loanID) {
        for (LoanBookOrder loanOrder : allLoanBookOrders) {
            if (loanOrder.getLoanID().equals(loanID)) {
                return loanOrder;
            }
        }
        return null;
    }

    
}
