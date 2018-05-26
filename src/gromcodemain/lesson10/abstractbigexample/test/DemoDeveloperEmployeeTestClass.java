package gromcodemain.lesson10.abstractbigexample.test;

import gromcodemain.lesson10.abstractbigexample.BankAccount;
import gromcodemain.lesson10.abstractbigexample.Company;
import gromcodemain.lesson10.abstractbigexample.DeveloperEmployee;

public class DemoDeveloperEmployeeTestClass {
    public static void main(String[] args) {
        Company company1 = new Company("Frt");
        Company company2 = new Company("fwe");
        Company company3 = new Company("fweewg");

        Company[] companies = {company1, company2, company3};

        String[] positionsWorked = {"ewg", "eethg", "ewgtre", "lh"};

        String[] frameworks = {"relg", "2", "3"};

        DeveloperEmployee developerEmployee = new DeveloperEmployee("Ann", 12, 12, "gt", 1000, companies, positionsWorked, frameworks);

        BankAccount bankAccount = new BankAccount(developerEmployee, 1000);
        developerEmployee.setBankAccount(bankAccount);

        //paySalary()
        //увеличивает счет на сумму зарплаты + 1000 +

        developerEmployee.paySalary();

        System.out.println(bankAccount.toString());

        //changePosition(String newPosition)
        //меняет позицию на указаную +
        //если новая позиция null +

        developerEmployee.changePosition("rt");

        System.out.println(developerEmployee.toString());

        developerEmployee.changePosition(null);

        System.out.println(developerEmployee.toString());
    }
}
