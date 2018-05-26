package gromcodemain.lesson5.test;

import gromcodemain.lesson5.BanksPractice;

import java.util.Arrays;

public class DemoBanksPracticeTestClass {
    public static void main(String[] args) {

        String[] names = {"Jack", "Ann", "Denis", "Andrey", "Nikolay", "Irina", "John"};
        int[] balances = {100, 500, 8432, -99, 12000, -54, 0};

        //withdraw(String[] clients, int[] balances, String client, int amount)
        //вычетает сумму из баланса юзера +
        //если сумма больше баланса +
        //если клиента нет +
        //если массивы юзеров и балансов пустые +
        //если массивы юзеров и/или балансов null +

        System.out.println(BanksPractice.withdraw(names, balances, "Ann", 100));

        System.out.println(BanksPractice.withdraw(names, balances, "Ann", 500));

        System.out.println(BanksPractice.withdraw(names, balances, "rewoh", 100));

        String[] names1 = new String[5];
        int[] balances1 = new int[5];

        System.out.println(BanksPractice.withdraw(names1, balances1, "Ann", 500));

        System.out.println(BanksPractice.withdraw(null, null, "Ann", 1));

        //findClientsByBalance(String[] clients, int[] balances, int n)
        //ищет всех юзеров с балансом больше указаного +
        //если массивы юзеров и балансов пустые +
        //если массивы юзеров и/или балансов null +

        System.out.println(Arrays.toString(BanksPractice.findClientsByBalance(names, balances, 100)));

        System.out.println(Arrays.toString(BanksPractice.findClientsByBalance(names1, balances1, 100)));

        System.out.println(BanksPractice.findClientsByBalance(null, null, 100));

        //findClientsWithNegativeBalance(String[] clients, int[] balances)
        //ищет юзеров с отрицательным балансом +
        //если массивы юзеров и балансов пустые +
        //если массивы юзеров и/или балансов null +

        System.out.println(Arrays.toString(BanksPractice.findClientsWithNegativeBalance(names, balances)));

        System.out.println(Arrays.toString(BanksPractice.findClientsWithNegativeBalance(names1, balances1)));

        System.out.println(BanksPractice.findClientsWithNegativeBalance(null, null));

        //depositMoney(String[] clients, int[] balances, String client, int money)
        //пополняет счет юзера на указаную сумму с учетом коммисии +
        //если юзера такого нет +
        //если массивы юзеров и балансов пустые +
        //если сумма пополнения отрицательная +
        //если массивы юзеров и/или балансов null +

        System.out.println("Before");
        System.out.println(Arrays.toString(names));
        System.out.println(Arrays.toString(balances));

        BanksPractice.depositMoney(names, balances, "Ann", 100);

        System.out.println("After");
        System.out.println(Arrays.toString(names));
        System.out.println(Arrays.toString(balances));

        System.out.println("Before");
        System.out.println(Arrays.toString(names));
        System.out.println(Arrays.toString(balances));

        BanksPractice.depositMoney(names, balances, "wkgjl", 100);

        System.out.println("After");
        System.out.println(Arrays.toString(names));
        System.out.println(Arrays.toString(balances));

        System.out.println("Before");
        System.out.println(Arrays.toString(names1));
        System.out.println(Arrays.toString(balances1));

        BanksPractice.depositMoney(names1, balances1, "Ann", 100);

        System.out.println("After");
        System.out.println(Arrays.toString(names1));
        System.out.println(Arrays.toString(balances1));

        System.out.println("Before");
        System.out.println(Arrays.toString(names));
        System.out.println(Arrays.toString(balances));

        BanksPractice.depositMoney(names, balances, "Ann", -300);

        System.out.println("After");
        System.out.println(Arrays.toString(names));
        System.out.println(Arrays.toString(balances));

        BanksPractice.depositMoney(null, null, "Ann", 100);

        //calculateDepositAmountAfterCommission(int money)
        //считает количество денег на которые пополняется счет после учета коммисии +
        //если сумма отрицательная +

        System.out.println(BanksPractice.calculateDepositAmountAfterCommission(100));

        System.out.println(BanksPractice.calculateDepositAmountAfterCommission(-100));

        //findClientIndexByName(String[] clients, String client)
        //ищет юзера по имени +
        //если юзера такого нет +
        //если массив юзеров пустой +
        //если массив юзеров null +

        System.out.println(BanksPractice.findClientIndexByName(names, "Ann"));

        System.out.println(BanksPractice.findClientIndexByName(names, "rwjgo"));

        System.out.println(BanksPractice.findClientIndexByName(names1, "Ann"));

        System.out.println(BanksPractice.findClientIndexByName(null, "Ann"));
    }
}
