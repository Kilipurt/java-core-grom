package gromcodemain.lesson8.accounts.test;

import gromcodemain.lesson8.accounts.Account;

public class DemoAccountTestClass {

    public static void main(String[] args) {
        Account account = new Account("euBank", "Ann", 100);

        //depositMoney(int amount)
        //добавляет на счет указаную сумму +
        //если сумма отрицательная +

        account.depositMoney(100);

        System.out.println(account.toString());

        account.depositMoney(-100);

        System.out.println(account.toString());

        //depositMoney()
        //добавляет на счет 1000 +
        //выводит сообщение об успешности +

        account.depositMoney();

        System.out.println(account.toString());

        //changeOwnerName(String newOwnerName)
        //меняет имя владельца +
        //если имя null +

        account.changeOwnerName("Jack");

        System.out.println(account.toString());

        account.changeOwnerName(null);

        System.out.println(account.toString());
    }
}
