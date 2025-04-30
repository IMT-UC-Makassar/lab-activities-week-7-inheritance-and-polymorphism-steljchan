package oop.lab;

public class SavingsAccount extends BankAccount implements OnlineService {
    private static final double INTEREST_RATE = 0.05; // 5% annual interest

    public SavingsAccount(String accountNumber, String accountHolder, double balance) {
        super(accountNumber, accountHolder, balance);
    }

    @Override
    public void calculateInterest() {
        double monthlyInterest = balance * (INTEREST_RATE / 12);
        balance += monthlyInterest;
    }

    @Override
    public void transferFunds(double amount, String targetAccountNumber) {
        withdraw(amount);
        // In a real system, we would actually transfer to the target account
        System.out.println("Transferred $" + amount + " to account " + targetAccountNumber);
    }

    @Override
    public void payBills(double amount) {
        withdraw(amount);
        System.out.println("Paid bills amounting to $" + amount);
    }
}