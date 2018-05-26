package gromcodemain.lesson30.homework;

public class Demo {
    public static void main(String[] args) {

        FirmDAO firmDAO = new FirmDAO();
        CustomerDAO customerDAO = new CustomerDAO();
        DepartmentDAO departmentDAO = new DepartmentDAO();
        ProjectDAO projectDAO = new ProjectDAO();
        EmployeeDAO employeeDAO = new EmployeeDAO();

        try {
            System.out.println(Controller.employeesByCustomerProjects(CustomerDAO.getCustomers().get(0)).toString());
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        try {
            System.out.println(Controller.employeesByDepartmentWithoutProject(DepartmentType.ANALYSTS));
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        try {
            System.out.println(Controller.employeesByProject("001"));
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        try {
            System.out.println(Controller.employeesByProjectEmployee(EmployeeDAO.getEmployees().get(1)));
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        try {
            System.out.println(Controller.employeesByTeamLead(EmployeeDAO.getEmployees().get(0)));
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        System.out.println(Controller.employeesWithoutProject());

        try {
            System.out.println(Controller.teamLeadsByEmployee(EmployeeDAO.getEmployees().get(1)));
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        try {
            System.out.println(Controller.projectsByCustomer(CustomerDAO.getCustomers().get(0)));
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        try {
            System.out.println(Controller.projectsByEmployee(EmployeeDAO.getEmployees().get(0)));
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
