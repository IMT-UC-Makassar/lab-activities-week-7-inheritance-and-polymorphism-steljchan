package oop.lab;

public class BusinessAccount extends BankAccount implements OnlineService, LoanService {
    private static final double INTEREST_RATE = 0.03;
    private String loanStatus;

    public BusinessAccount(String accountNumber, String accountHolder, double balance) {
        super(accountNumber, accountHolder, balance);
        this.loanStatus = "None";
    }

    @Override
    public void calculateInterest() {
        double interest = balance * INTEREST_RATE;
        balance += interest;
    }

    @Override
    public void transferFunds(double amount, String targetAccount) {
        withdraw(amount);
    }

    @Override
    public void payBills(double amount) {
        withdraw(amount);
    }

    @Override
    public void applyForLoan(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Loan amount must be positive");
        }
        this.loanStatus = "Pending";
    }

    @Override
    public String checkLoanStatus() {
        return loanStatus;
    }
}