package gromcodemain.lesson8.accounts.test;

import gromcodemain.lesson8.accounts.SavingAccount;

public class DemoSavingAccountTestClass {
    public static void main(String[] args) {
        SavingAccount savingAccount = new SavingAccount("SomeBank", "Denis", 1000, 50);

        //changeOwnerName(String newOwnerName)
        //меняет имя владельца +
        //если имя не "Jack" или "Ann" +

        savingAccount.changeOwnerName("Jack");
        System.out.println(savingAccount.toString());

        savingAccount.changeOwnerName("Ann");
        System.out.println(savingAccount.toString());

        savingAccount.changeOwnerName("ewf");
        System.out.println(savingAccount.toString());
    }
}
