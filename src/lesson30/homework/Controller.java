package lesson30.homework;

import java.util.ArrayList;
import java.util.Collection;

public class Controller {

    public static ArrayList<Employee> employeesByProject(String projectName) throws Exception {
        return EmployeeDAO.employeesByProject(projectName);
    }

    public static ArrayList<Employee> employeesByDepartmentWithoutProject(DepartmentType departmentType) throws Exception {
        return EmployeeDAO.employeesByDepartmentWithoutProject(departmentType);
    }

    public static ArrayList<Employee> employeesWithoutProject() {
        return EmployeeDAO.employeesWithoutProject();
    }

    public static ArrayList<Employee> employeesByTeamLead(Employee lead) throws Exception {
        return EmployeeDAO.employeesByTeamLead(lead);
    }

    public static ArrayList<Employee> teamLeadsByEmployee(Employee employee) throws Exception {
        return EmployeeDAO.teamLeadsByEmployee(employee);
    }

    public static ArrayList<Employee> employeesByProjectEmployee(Employee employee) throws Exception {
        return EmployeeDAO.employeesByProjectEmployee(employee);
    }

    public static ArrayList<Employee> employeesByCustomerProjects(Customer customer) throws Exception {
        return EmployeeDAO.employeesByCustomerProjects(customer);
    }

    public static ArrayList<Project> projectsByCustomer(Customer customer) throws Exception {
        return ProjectDAO.projectsByCustomer(customer);
    }

    public static Collection<Project> projectsByEmployee(Employee employee) throws Exception {
        return ProjectDAO.projectsByEmployee(employee);
    }
}
