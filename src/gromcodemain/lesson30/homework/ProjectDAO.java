package gromcodemain.lesson30.homework;

import java.util.ArrayList;
import java.util.Collection;

public class ProjectDAO {
    private static ArrayList<Project> projects = new ArrayList<>();

    public ProjectDAO() {
        Project project1 = new Project("001", CustomerDAO.getCustomers().get(0));
        Project project2 = new Project("002", CustomerDAO.getCustomers().get(1));
        Project project3 = new Project("003", CustomerDAO.getCustomers().get(2));
        Project project4 = new Project("004", CustomerDAO.getCustomers().get(3));
        Project project5 = new Project("005", CustomerDAO.getCustomers().get(4));
        Project project6 = new Project("006", CustomerDAO.getCustomers().get(5));

        projects.add(project1);
        projects.add(project2);
        projects.add(project3);
        projects.add(project4);
        projects.add(project5);
        projects.add(project6);
    }

    public static ArrayList<Project> getProjects() {
        return projects;
    }

    public static ArrayList<Project> projectsByCustomer(Customer customer) throws Exception {
        if (customer == null)
            throw new Exception("Input data is empty");

        ArrayList<Project> listOfProjects = new ArrayList<>();

        for (Project project : ProjectDAO.getProjects()) {
            if (project != null && project.getCustomer().equals(customer))
                listOfProjects.add(project);
        }

        return listOfProjects;
    }

    public static Collection<Project> projectsByEmployee(Employee employee) throws Exception {
        if (employee == null)
            throw new Exception("Input date is empty");

        return employee.getProjects();
    }
}
