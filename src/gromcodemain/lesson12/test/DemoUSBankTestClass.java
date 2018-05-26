package gromcodemain.lesson12.test;

import gromcodemain.lesson12.Bank;
import gromcodemain.lesson12.Currency;
import gromcodemain.lesson12.USBank;

public class DemoUSBankTestClass {
    public static void main(String[] args) {

        Bank usBank1 = new USBank(125865, "China", Currency.USD, 300, 2000, 6, 894689645);
        Bank usBank2 = new USBank(125865, "China", Currency.EUR, 300, 2000, 6, 894689645);

        //getLimitOfWithdrawal()
        //возвращает лимит на снятие +
        //если валюта USD +
        //если валюта EUR +

        System.out.println(usBank1.getLimitOfWithdrawal());

        System.out.println(usBank2.getLimitOfWithdrawal());

        System.out.println();

        //getLimitOfFunding()
        //возвращает лимит на пополнение +
        //если валюта USD +
        //если валюта EUR +

        System.out.println(usBank1.getLimitOfFunding());

        System.out.println(usBank2.getLimitOfFunding());

        System.out.println();

        //getMonthlyRate()
        //возвращает процент от депозита +
        //если валюта USD +
        //если валюта EUR +

        System.out.println(usBank1.getMonthlyRate());

        System.out.println(usBank2.getMonthlyRate());

        System.out.println();

        //getCommission(int amount)
        //возвращает коммиссию на снятие со счета +
        //если валюта USD +
        //если сумма меньше 1000 +
        //если сумма больше 1000 +
        //если валюта EUR +
        //если сумма меньше 1000 +
        //если сумма больше 1000 +

        System.out.println(usBank1.getCommission(200));

        System.out.println(usBank1.getCommission(1100));

        System.out.println(usBank2.getCommission(200));

        System.out.println(usBank1.getCommission(1100));

        System.out.println();

        //moneyPaidMonthlyForSalary()
        //возвращает сумму которая выплачивается работникам банка +

        System.out.println(usBank1.moneyPaidMonthlyForSalary());
    }
}
