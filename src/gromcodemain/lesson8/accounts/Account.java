package gromcodemain.lesson8.accounts;

public class Account {
    String bankName;
    String ownerName;
    int moneyAmount;

    public Account(String bankName, String ownerName, int moneyAmount) {
        this.bankName = bankName;
        this.ownerName = ownerName;
        this.moneyAmount = moneyAmount;
    }

    public void depositMoney(int amount) {
        if (amount >= 0)
            moneyAmount += amount;
    }

    public void depositMoney() {
        moneyAmount += 1000;
        System.out.println("deposit was successful");
    }

    public void changeOwnerName(String newOwnerName) {
        if (newOwnerName != null)
            ownerName = newOwnerName;
    }

    @Override
    public String toString() {
        return "Account{" +
                "bankName='" + bankName + '\'' +
                ", ownerName='" + ownerName + '\'' +
                ", moneyAmount=" + moneyAmount +
                '}';
    }
}
