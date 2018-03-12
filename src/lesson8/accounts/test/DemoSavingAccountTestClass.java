package lesson8.accounts.test;

import lesson8.accounts.SavingAccount;

public class DemoSavingAccountTestClass {
    public static void main(String[] args) {
        SavingAccount savingAccount = new SavingAccount("SomeBank", "Denis", 1000, 50);

        //changeOwnerName(String newOwnerName)
        //меняет имя владельца только на "Jack" или "Ann", в другом случае выводит сообщение о неудаче +

        savingAccount.changeOwnerName("Jack");
        System.out.println(savingAccount.toString());

        savingAccount.changeOwnerName("Ann");
        System.out.println(savingAccount.toString());

        savingAccount.changeOwnerName("ewf");
        System.out.println(savingAccount.toString());
    }
}