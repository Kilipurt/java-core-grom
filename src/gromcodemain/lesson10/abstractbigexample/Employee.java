package gromcodemain.lesson10.abstractbigexample;

import java.util.Arrays;

public abstract class Employee {
    private String name;
    private int age;
    private int yearsOfExperience;

    private String curPosition;

    private int salaryPerMonth;
    private BankAccount bankAccount;
    private Company[] companiesWorked = new Company[10];
    private String[] positionsWorked = new String[10];

    public Employee(String name, int age, int yearsOfExperience, String curPosition, int salaryPerMonth, Company[] companiesWorked, String[] positionsWorked) {
        this.name = name;
        this.age = age;
        this.yearsOfExperience = yearsOfExperience;
        this.curPosition = curPosition;
        this.salaryPerMonth = salaryPerMonth;
        this.bankAccount = null;
        this.companiesWorked = companiesWorked;
        this.positionsWorked = positionsWorked;
    }

    public Employee(String name, int salaryPerMonth) {
        this.name = name;
        this.salaryPerMonth = salaryPerMonth;
        this.bankAccount = null;
    }

    public void setBankAccount(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    public abstract void paySalary();

    public void changePosition(String newPosition) {
        if (newPosition == null)
            return;
        savePositionToHistory();
        curPosition = newPosition;
    }

    private void savePositionToHistory() {
        int index = 0;
        for (String pos : positionsWorked) {
            if (pos == null) {
                positionsWorked[index] = curPosition;
                break;
            }
            index++;
        }
    }

    int getBalance() {
        return bankAccount.getBalance();
    }

    public BankAccount getBankAccount() {
        return bankAccount;
    }

    public int getSalaryPerMonth() {
        return salaryPerMonth;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", yearsOfExperience=" + yearsOfExperience +
                ", curPosition='" + curPosition + '\'' +
                ", salaryPerMonth=" + salaryPerMonth +
                ", bankAccount=" + bankAccount +
                ", companiesWorked=" + Arrays.toString(companiesWorked) +
                ", positionsWorked=" + Arrays.toString(positionsWorked) +
                '}';
    }
}
