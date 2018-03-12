package lesson10.abstractbigexample.test;

import lesson10.abstractbigexample.BankAccount;
import lesson10.abstractbigexample.Company;
import lesson10.abstractbigexample.ManagerEmployee;

public class DemoManagerEmployeeTestClass {
    public static void main(String[] args) {
        Company company1 = new Company("Frt");
        Company company2 = new Company("fwe");
        Company company3 = new Company("fweewg");

        Company[] companies = {company1, company2, company3};

        String[] positionsWorked = {"ewg", "eethg", "ewgtre", "lh"};

        ManagerEmployee managerEmployee = new ManagerEmployee("Ann", 12, 12, "gt", 1000, companies, positionsWorked);

        BankAccount bankAccount = new BankAccount(managerEmployee, 1000);
        managerEmployee.setBankAccount(bankAccount);

        //paySalary()
        //увеличивает счет на сумму зарплаты + четверть баланса +

        managerEmployee.paySalary();

        System.out.println(bankAccount.toString());

        //changePosition(String newPosition)
        //меняет позицию на указаную +
        //если новая позиция null +

        managerEmployee.changePosition("rt");

        System.out.println(managerEmployee.toString());

        managerEmployee.changePosition(null);

        System.out.println(managerEmployee.toString());
    }
}
