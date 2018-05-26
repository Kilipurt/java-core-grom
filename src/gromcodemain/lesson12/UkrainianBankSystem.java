package gromcodemain.lesson12;

public class UkrainianBankSystem implements BankSystem {

    @Override
    public void withdraw(User user, int amount) {
        if (user == null || amount < 0)
            return;
        if (!(checkWithdrawLimits(user, amount, user.getBank().getLimitOfWithdrawal()) &&
                checkWithdrawLimits(user, amount, user.getBalance())))
            return;

        user.setBalance(user.getBalance() - amount - amount * user.getBank().getCommission(amount));
    }

    @Override
    public void fund(User user, int amount) {
        if (user == null || amount < 0)
            return;
        if (!checkFund(user, amount))
            return;

        user.setBalance(user.getBalance() + amount);
    }

    @Override
    public void transferMoney(User fromUser, User toUser, int amount) {
        if (fromUser == null || toUser == null || amount < 0)
            return;
        if (!(checkWithdrawLimits(fromUser, amount, fromUser.getBank().getLimitOfWithdrawal()) &&
                checkWithdrawLimits(fromUser, amount, fromUser.getBalance())) || !checkFund(toUser, amount)
                || fromUser.getBank().getCurrency() != toUser.getBank().getCurrency()) {
            System.err.println("Can't transfer money " + amount + " from user " + fromUser.toString() + " to user " + toUser.toString());
            return;
        }

        fromUser.setBalance(fromUser.getBalance() - amount - amount * fromUser.getBank().getCommission(amount));
        toUser.setBalance(toUser.getBalance() + amount);
    }

    @Override
    public void paySalary(User user) {
        fund(user, user.getSalary());
    }

    private boolean checkWithdrawLimits(User user, int amount, double limit) {
        if (amount + user.getBank().getCommission(amount) > limit) {
            System.err.println("Can't withdraw money " + amount + " from user " + user.toString());
            return false;
        }
        return true;
    }

    private boolean checkFund(User user, int amount) {
        if (amount > user.getBank().getLimitOfFunding()) {
            System.err.println("Can't fund money " + amount + " to user " + user.toString());
            return false;
        }
        return true;
    }
}
