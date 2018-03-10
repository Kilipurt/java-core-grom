package lesson5;

import java.util.Arrays;

public class BanksPractice {
    public static void main(String[] args) {
        String[] names = {"Jack", "Ann", "Denis", "Andrey", "Nikolay", "Irina", "John"};
        int[] balances = {100, 500, 8432, -99, 12000, -54, 0};

        System.out.println(Arrays.toString(findClientsByBalance(names, balances, -100)));
        System.out.println(Arrays.toString(findClientsWithNegativeBalance(names, balances)));

        depositMoney(names, balances, "Ann", 2000);
        System.out.println(Arrays.toString(balances));

        System.out.println(withdraw(names, balances, "Andrey", 300));
    }

    public static int withdraw(String[] clients, int[] balances, String client, int amount) {
        int clientIndex = 0;
        for (String cl : clients) {
            if (cl == client) {
                break;
            }
            clientIndex++;
        }
        if (clientIndex >= clients.length)
            return -1;
        if (balances[clientIndex] >= amount) {
            balances[clientIndex] -= amount;
            return balances[clientIndex];
        } else {
            return -1;
        }
    }

    public static String[] findClientsByBalance(String[] clients, int[] balances, int n) {

        int count = 0;
        for (int balance : balances) {
            if (balance >= n)
                count++;
        }

        String[] results = new String[count];

        int index = 0;
        int resIndex = 0;
        for (int balance : balances) {
            if (balance >= n) {
                results[resIndex] = clients[index];
                resIndex++;
            }
            index++;
        }
        return results;
    }

    public static String[] findClientsWithNegativeBalance(String[] clients, int[] balances) {

        int count = 0;
        for (int balance : balances) {
            if (balance < 0)
                count++;
        }

        String[] results = new String[count];

        int index = 0;
        int resIndex = 0;
        for (int balance : balances) {
            if (balance < 0) {
                results[resIndex] = clients[index];
                resIndex++;
            }
            index++;
        }
        return results;
    }

    public static void depositMoney(String[] clients, int[] balances, String client, int money) {
        if (findClientIndexByName(clients, client) == -1 || money <= 0)
            return;
        balances[findClientIndexByName(clients, client)] += calculateDepositAmountAfterCommission(money);
    }

    public static int findClientIndexByName(String[] clients, String client) {
        boolean k = false;
        int clientIndex = 0;
        for (String cl : clients) {
            if (cl == client) {
                k = true;
                break;
            }
            clientIndex++;
        }
        if (!k)
            return -1;
        return clientIndex;
    }

    public static int calculateDepositAmountAfterCommission(int money) {
        return money <= 100 ? (int) (money - money * 0.02) : (int) (money - money * 0.01);
    }
}
