package gromcodemain.lesson8.accounts;

public class CheckingAccount extends Account {
    int limitOFExpenses;

    public CheckingAccount(String bankName, String ownerName, int moneyAmount, int limitOFExpenses) {
        super(bankName, ownerName, moneyAmount);
        this.limitOFExpenses = limitOFExpenses;
    }

    public void withdraw(int amount) {
        if (amount > limitOFExpenses || amount < 0)
            return;
        moneyAmount -= amount;
    }
}
