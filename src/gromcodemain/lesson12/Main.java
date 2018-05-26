package gromcodemain.lesson12;

public class Main {
    public static void main(String[] args) {
        Bank usBank = new USBank(1222, "Sweden", Currency.EUR, 100, 1400, 4, 444343434);
        Bank euBank = new EUBank(1202, "Spain", Currency.USD, 100, 1000, 5, 434343400);
        Bank chinaBank = new ChinaBank(125865, "China", Currency.USD, 300, 2000, 6, 894689645);

        User userOfUSBank1 = new User(1001, "Denis", 12000, 40, "GMD", 1500, usBank);
        User userOfUSBank2 = new User(1002, "Denis1", 10000, 35, "GMD1", 1700, usBank);
        User userOfEUBank1 = new User(123, "Jack", 15000, 12, "Ubisoft", 700, euBank);
        User userOfEUBank2 = new User(124, "Jack1", 7000, 13, "Ubisoft1", 800, euBank);
        User userOfChinaBank1 = new User(1, "Vika", 10000, 60, "HJR", 5000, chinaBank);
        User userOfChinaBank2 = new User(2, "Vika1", 1000000, 100, "HJR1", 5000, chinaBank);


        BankSystem bankSystem = new UkrainianBankSystem();

        operationsWithUser(bankSystem, userOfUSBank1, userOfUSBank2, 500, 1000, 500);
        operationsWithUser(bankSystem, userOfUSBank2, userOfUSBank1, 1150, 1000, 500);
        operationsWithUser(bankSystem, userOfEUBank1, userOfEUBank2, 1000, 1000, 500);
        operationsWithUser(bankSystem, userOfEUBank2, userOfEUBank1, 500, 1000, 500);
        operationsWithUser(bankSystem, userOfChinaBank1, userOfChinaBank2, 50, 1000, 50);
        operationsWithUser(bankSystem, userOfChinaBank2, userOfChinaBank1, 40, 1000, 40);
    }

    private static void operationsWithUser(BankSystem bankSystem, User fromUser, User toUser, int amountOfWithdraw, int amountOfFund, int amountOfTransfer) {
        bankSystem.withdraw(fromUser, amountOfWithdraw);
        bankSystem.fund(fromUser, amountOfFund);
        bankSystem.paySalary(fromUser);
        bankSystem.transferMoney(fromUser, toUser, amountOfTransfer);
        System.out.println(fromUser.toString());
    }
}

