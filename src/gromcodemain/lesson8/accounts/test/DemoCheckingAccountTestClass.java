package gromcodemain.lesson8.accounts.test;

import gromcodemain.lesson8.accounts.CheckingAccount;

public class DemoCheckingAccountTestClass {
    public static void main(String[] args) {

        CheckingAccount checkingAccount = new CheckingAccount("euBank", "Ann", 1000, 500);

        //withdraw(int amount)
        //снимает средства со счета +
        //если сумма превышает лимит +
        //если сумма отрицательная +

        checkingAccount.withdraw(100);
        System.out.println(checkingAccount.toString());

        checkingAccount.withdraw(600);
        System.out.println(checkingAccount.toString());

        checkingAccount.withdraw(-100);
        System.out.println(checkingAccount.toString());
    }
}
