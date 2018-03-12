package lesson12.test;

import lesson12.*;

public class DemoUkrainianBankSystemTestClass {
    public static void main(String[] args) {
        Bank usBank1 = new USBank(1222, "Sweden", Currency.EUR, 100, 1400, 4, 444343434);
        Bank euBank1 = new EUBank(1202, "Spain", Currency.EUR, 100, 1000, 5, 434343400);
        Bank euBank2 = new EUBank(1202, "Spain", Currency.USD, 100, 1000, 5, 434343400);
        Bank chinaBank1 = new ChinaBank(125865, "China", Currency.EUR, 300, 2000, 6, 894689645);
        Bank chinaBank2 = new ChinaBank(125865, "China", Currency.USD, 300, 2000, 6, 894689645);

        User userOfUSBank1 = new User(1001, "Denis", 2000, 40, "GMD", 1500, usBank1);
        User userOfEUBank1 = new User(123, "Jack", 15000, 12, "Ubisoft", 700, euBank1);
        User userOfEUBank2 = new User(124, "Jack1", 7000, 13, "Ubisoft1", 800, euBank2);
        User userOfChinaBank1 = new User(1, "Vika", 150, 60, "HJR", 5000, chinaBank1);
        User userOfChinaBank2 = new User(2, "Vika1", 1000000, 100, "HJR1", 5000, chinaBank2);


        BankSystem bankSystem = new UkrainianBankSystem();

        //withdraw(User user, int amount)
        //снимает средства со счета +
        //если юзер равен null +
        //если суммы с учетом коммиссии не достаточно для снятия +
        //если сумма отрицательная +
        //если сумма больше лимита указаного банком +

        System.out.println("Before\n" + userOfChinaBank1.toString());
        bankSystem.withdraw(userOfChinaBank1, 100);
        System.out.println("After\n" + userOfChinaBank1.toString());

        bankSystem.withdraw(null, 100);

        System.out.println("Before\n" + userOfChinaBank1.toString());
        bankSystem.withdraw(userOfChinaBank1, 100);
        System.out.println("After\n" + userOfChinaBank1.toString());

        System.out.println("Before\n" + userOfChinaBank2.toString());
        bankSystem.withdraw(userOfChinaBank2, -50);
        System.out.println("After\n" + userOfChinaBank2.toString());

        System.out.println("Before\n" + userOfChinaBank2.toString());
        bankSystem.withdraw(userOfChinaBank2, 1000);
        System.out.println("After\n" + userOfChinaBank2.toString());

        System.out.println("\n\n");

        //fund(User user, int amount)
        //пополняет счет на указаную сумму +
        //если сумма больше лимита указаного банком +
        //если юзер равен null +
        //если сумма отрицательная +

        System.out.println("Before\n" + userOfEUBank1.toString());
        bankSystem.fund(userOfEUBank1, 1000);
        System.out.println("After\n" + userOfEUBank1.toString());

        System.out.println("Before\n" + userOfEUBank1.toString());
        bankSystem.fund(userOfEUBank1, 100000);
        System.out.println("After\n" + userOfEUBank1.toString());

        bankSystem.fund(null, 100000);

        System.out.println("Before\n" + userOfEUBank1.toString());
        bankSystem.fund(userOfEUBank1, -1000);
        System.out.println("After\n" + userOfEUBank1.toString());

        System.out.println("\n\n");

        //transferMoney(User fromUser, User toUser, int amount)
        //переводит средства со счета одного юзера на счет второго +
        //если один из юзеров равен null +
        //если сумма отрицательная +
        //если валюты банков разные +
        //если на счете fromUser недостаточно средств для перевода с учетом коммиссии +
        //если fromUser превысил лимит снятия +
        //если toUser превысил лимит пополнения +

        System.out.println("Before fromUser\n" + userOfUSBank1.toString());
        System.out.println("Before toUser\n" + userOfEUBank1.toString());
        bankSystem.transferMoney(userOfUSBank1, userOfEUBank1, 500);
        System.out.println("After fromUser\n" + userOfUSBank1.toString());
        System.out.println("After toUser\n" + userOfEUBank1.toString());

        System.out.println("Before fromUser\n" + userOfUSBank1.toString());
        bankSystem.transferMoney(userOfUSBank1, null, 500);
        System.out.println("After fromUser\n" + userOfUSBank1.toString());

        System.out.println("Before fromUser\n" + userOfUSBank1.toString());
        System.out.println("Before toUser\n" + userOfEUBank1.toString());
        bankSystem.transferMoney(userOfUSBank1, userOfEUBank1, -500);
        System.out.println("After fromUser\n" + userOfUSBank1.toString());
        System.out.println("After toUser\n" + userOfEUBank1.toString());

        bankSystem.transferMoney(userOfUSBank1, userOfEUBank2, 500);

        System.out.println("Before fromUser\n" + userOfUSBank1.toString());
        System.out.println("Before toUser\n" + userOfEUBank1.toString());
        bankSystem.transferMoney(userOfUSBank1, userOfEUBank1, 1000);
        System.out.println("After fromUser\n" + userOfUSBank1.toString());
        System.out.println("After toUser\n" + userOfEUBank1.toString());


        System.out.println("Before fromUser\n" + userOfEUBank1.toString());
        System.out.println("Before toUser\n" + userOfUSBank1.toString());
        bankSystem.transferMoney(userOfEUBank1, userOfUSBank1, 5000);
        System.out.println("After fromUser\n" + userOfEUBank1.toString());
        System.out.println("After toUser\n" + userOfUSBank1.toString());

        userOfUSBank1.setBalance(10000000);
        System.out.println("Before fromUser\n" + userOfUSBank1.toString());
        System.out.println("Before toUser\n" + userOfEUBank1.toString());
        bankSystem.transferMoney(userOfUSBank1, userOfEUBank1, 100000);
        System.out.println("After fromUser\n" + userOfUSBank1.toString());
        System.out.println("After toUser\n" + userOfEUBank1.toString());

        System.out.println("\n\n");

        //paySalary(User user)
        //пополняет счет на сумму зарплаты +

        System.out.println("Before\n" + userOfEUBank1.toString());
        bankSystem.paySalary(userOfEUBank1);
        System.out.println("After\n" + userOfEUBank1.toString());
    }

}
