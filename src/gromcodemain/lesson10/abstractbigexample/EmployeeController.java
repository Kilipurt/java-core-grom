package gromcodemain.lesson10.abstractbigexample;

public class EmployeeController {
    private Employee[] employees = new Employee[100];

    public void paySalaryToEmployees() {
        for (Employee employee : employees) {
            if (employee != null) {
                employee.paySalary();
                System.out.println("Salary was paid successfully to " + employee.getName() + "employee");
            }
        }
    }
}
