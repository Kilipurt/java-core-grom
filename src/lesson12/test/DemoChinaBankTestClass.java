package lesson12.test;

import lesson12.Bank;
import lesson12.ChinaBank;
import lesson12.Currency;

public class DemoChinaBankTestClass {
    public static void main(String[] args) {
        Bank chinaBank1 = new ChinaBank(125865, "China", Currency.USD, 300, 2000, 6, 894689645);
        Bank chinaBank2 = new ChinaBank(125865, "China", Currency.EUR, 300, 2000, 6, 894689645);

        //getLimitOfWithdrawal()
        //возвращает лимит на снятие +
        //если валюта USD +
        //если валюта EUR +

        System.out.println(chinaBank1.getLimitOfWithdrawal());

        System.out.println(chinaBank2.getLimitOfWithdrawal());

        System.out.println();

        //getLimitOfFunding()
        //возвращает лимит на пополнение +
        //если валюта USD +
        //если валюта EUR +

        System.out.println(chinaBank1.getLimitOfFunding());

        System.out.println(chinaBank2.getLimitOfFunding());

        System.out.println();

        //getMonthlyRate()
        //возвращает процент от депозита +
        //если валюта USD +
        //если валюта EUR +

        System.out.println(chinaBank1.getMonthlyRate());

        System.out.println(chinaBank2.getMonthlyRate());

        System.out.println();

        //getCommission(int amount)
        //возвращает коммиссию на снятие со счета +
        //если валюта USD +
        //если сумма меньше 1000 +
        //если сумма больше 1000 +
        //если валюта EUR +
        //если сумма меньше 1000 +
        //если сумма больше 1000 +

        System.out.println(chinaBank1.getCommission(200));

        System.out.println(chinaBank1.getCommission(1100));

        System.out.println(chinaBank2.getCommission(200));

        System.out.println(chinaBank1.getCommission(1100));

        System.out.println();

        //moneyPaidMonthlyForSalary()
        //возвращает сумму которая выплачивается работникам банка +

        System.out.println(chinaBank1.moneyPaidMonthlyForSalary());
    }
}
