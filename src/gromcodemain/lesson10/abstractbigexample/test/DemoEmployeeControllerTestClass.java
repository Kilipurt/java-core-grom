package gromcodemain.lesson10.abstractbigexample.test;

import gromcodemain.lesson10.abstractbigexample.BankAccount;
import gromcodemain.lesson10.abstractbigexample.DeveloperEmployee;
import gromcodemain.lesson10.abstractbigexample.Employee;
import gromcodemain.lesson10.abstractbigexample.EmployeeController;

public class DemoEmployeeControllerTestClass {
    public static void main(String[] args) {
        EmployeeController employeeController = new EmployeeController();

        DeveloperEmployee employee1 = new DeveloperEmployee("Fg", 10000);
        DeveloperEmployee employee2 = new DeveloperEmployee("Fg1", 10000);
        DeveloperEmployee employee3 = new DeveloperEmployee("Fg2", 10000);

        BankAccount bankAccount = new BankAccount(employee1, 1000);
        employee1.setBankAccount(bankAccount);

        BankAccount bankAccount1 = new BankAccount(employee2, 1000);
        employee1.setBankAccount(bankAccount1);

        BankAccount bankAccount2 = new BankAccount(employee3, 1000);
        employee1.setBankAccount(bankAccount2);

        Employee[] employees = {employee1, employee2, employee3};

        //paySalaryToEmployees()
        //пополняет баланс работников на сумму зарплаты +
        //если работник null +

        employeeController.paySalaryToEmployees();

        System.out.println(employee1.toString());
        System.out.println(employee1.toString());
        System.out.println(employee1.toString());

    }
}
