package lesson30.homework;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

public class EmployeeDAO {

    private static ArrayList<Employee> employees = new ArrayList<>();

    public EmployeeDAO() {
        Employee employee1 = new Employee("1", "Jackovich", new Date(), Position.TEAM_LEAD, DepartmentDAO.getDepartments().get(1));
        Employee employee2 = new Employee("2", "Jackovich", new Date(), Position.DEVELOPER, DepartmentDAO.getDepartments().get(3));
        Employee employee3 = new Employee("3", "Jackovich", new Date(), Position.DEVELOPER, DepartmentDAO.getDepartments().get(3));
        Employee employee4 = new Employee("4", "Jackovich", new Date(), Position.ANALYST, DepartmentDAO.getDepartments().get(1));
        Employee employee5 = new Employee("5", "Jackovich", new Date(), Position.LEAD_DESIGNER, DepartmentDAO.getDepartments().get(2));
        Employee employee6 = new Employee("6", "Jackovich", new Date(), Position.FINANCE, DepartmentDAO.getDepartments().get(4));
        Employee employee7 = new Employee("7", "Jackovich", new Date(), Position.DESIGNER, DepartmentDAO.getDepartments().get(2));

        employees.add(employee1);
        employees.add(employee2);
        employees.add(employee3);
        employees.add(employee4);
        employees.add(employee5);
        employees.add(employee6);
        employees.add(employee7);

        employee1.getProjects().add(ProjectDAO.getProjects().get(0));
        employee1.getProjects().add(ProjectDAO.getProjects().get(1));
        employee2.getProjects().add(ProjectDAO.getProjects().get(0));
        employee2.getProjects().add(ProjectDAO.getProjects().get(1));
        employee3.getProjects().add(ProjectDAO.getProjects().get(0));
        //employee4.getProjects().add(ProjectDAO.getProjects().get(0));
        //employee5.getProjects().add(ProjectDAO.getProjects().get(0));
        employee6.getProjects().add(ProjectDAO.getProjects().get(1));
        employee7.getProjects().add(ProjectDAO.getProjects().get(1));

        DepartmentDAO.getDepartments().get(0).getEmployees().add(EmployeeDAO.getEmployees().get(0));
        DepartmentDAO.getDepartments().get(3).getEmployees().add(EmployeeDAO.getEmployees().get(1));
        DepartmentDAO.getDepartments().get(3).getEmployees().add(EmployeeDAO.getEmployees().get(2));
        DepartmentDAO.getDepartments().get(1).getEmployees().add(EmployeeDAO.getEmployees().get(3));
        DepartmentDAO.getDepartments().get(2).getEmployees().add(EmployeeDAO.getEmployees().get(6));
        DepartmentDAO.getDepartments().get(2).getEmployees().add(EmployeeDAO.getEmployees().get(4));
        DepartmentDAO.getDepartments().get(4).getEmployees().add(EmployeeDAO.getEmployees().get(5));
    }

    public static ArrayList<Employee> getEmployees() {
        return employees;
    }

    public static ArrayList<Employee> employeesByProject(String projectName) throws Exception {
        if (projectName == null)
            throw new Exception("Project's name is empty");

        ArrayList<Employee> listOfEmployees = new ArrayList<>();

        for (Employee employee : employees) {
            for (Project project : employee.getProjects()) {
                if (project != null && project.getName().equals(projectName))
                    listOfEmployees.add(employee);
            }
        }

        return listOfEmployees;
    }

    public static ArrayList<Employee> employeesByDepartmentWithoutProject(DepartmentType departmentType) throws Exception {
        if (departmentType == null)
            throw new Exception("Department's name is empty");

        ArrayList<Employee> listOfEmployees = new ArrayList<>();

        for (Department department : DepartmentDAO.getDepartments()) {
            if (department != null && department.getType().equals(departmentType))
                employeesWithoutProjectInStructure(department.getEmployees(), listOfEmployees);
        }

        return listOfEmployees;
    }

    public static ArrayList<Employee> employeesWithoutProject() {
        ArrayList<Employee> listOfEmployees = new ArrayList<>();

        employeesWithoutProjectInStructure(employees, listOfEmployees);

        return listOfEmployees;
    }

    public static ArrayList<Employee> employeesByTeamLead(Employee lead) throws Exception {
        if (lead == null)
            throw new Exception("Input data is empty");

        if (lead.getPosition() != Position.TEAM_LEAD)
            throw new Exception("This employee is not team leader");

        ArrayList<Employee> listOfEmployees = new ArrayList<>();

        for (Project project : lead.getProjects()) {
            if (project != null)
                employeesByTeamLeadInProject(project, listOfEmployees);
        }

        listOfEmployees.remove(lead);

        return listOfEmployees;
    }

    public static ArrayList<Employee> teamLeadsByEmployee(Employee employee) throws Exception {
        if (employee == null)
            throw new Exception("Input data is empty");

        ArrayList<Employee> listOfEmployee = new ArrayList<>();

        for (Project project : employee.getProjects()) {
            if (project != null)
                teamLeadByEmployeeInProject(project, listOfEmployee);
        }

        return listOfEmployee;
    }

    public static ArrayList<Employee> employeesByProjectEmployee(Employee employee) throws Exception {
        if (employee == null)
            throw new Exception("Input data is empty");

        if (employee.getProjects().isEmpty())
            throw new Exception("Employee does not participate in any project");

        ArrayList<Employee> listOfEmployee = new ArrayList<>();

        for (Employee emp : employees) {
            if (emp != null && isEmployeeParticipateInProjects(emp, employee.getProjects()))
                listOfEmployee.add(emp);
        }

        listOfEmployee.remove(employee);

        return listOfEmployee;
    }

    public static ArrayList<Employee> employeesByCustomerProjects(Customer customer) throws Exception {
        if (customer == null)
            throw new Exception("Input data is empty");

        ArrayList<Employee> listOfEmployee = new ArrayList<>();

        for (Project project : ProjectDAO.getProjects()) {
            if (project != null && project.getCustomer().equals(customer))
                employeesByProject(project, listOfEmployee);
        }

        return listOfEmployee;
    }

    private static void employeesByProject(Project project, ArrayList<Employee> resultList) {
        for (Employee employee : employees) {
            if (employee != null && employee.getProjects().contains(project) && !resultList.contains(employee))
                resultList.add(employee);
        }
    }

    private static boolean isEmployeeParticipateInProjects(Employee employee, Collection<Project> projects) {
        for (Project project : projects) {
            if (!employee.getProjects().contains(project))
                return false;
        }

        return true;
    }

    private static void employeesWithoutProjectInStructure(Collection<Employee> employees, ArrayList<Employee> resultList) {
        for (Employee employee : employees) {
            if (employee != null && employee.getProjects().isEmpty())
                resultList.add(employee);
        }
    }

    private static void employeesByTeamLeadInProject(Project project, ArrayList<Employee> resultList) {
        for (Employee employee : employees) {
            if (employee != null && employee.getProjects().contains(project) && !resultList.contains(employee))
                resultList.add(employee);
        }
    }

    private static void teamLeadByEmployeeInProject(Project project, ArrayList<Employee> resultList) {
        for (Employee emp : employees) {
            if (emp != null && emp.getProjects().contains(project) && emp.getPosition().equals(Position.TEAM_LEAD) && !resultList.contains(emp))
                resultList.add(emp);
        }
    }
}
