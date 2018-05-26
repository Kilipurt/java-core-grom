package gromcodemain.lesson30.homework;

import java.util.ArrayList;

public class DepartmentDAO {
    private static ArrayList<Department> departments = new ArrayList<>();

    public DepartmentDAO() {
        Department management = new Department(DepartmentType.MANAGEMENT);
        Department analysts = new Department(DepartmentType.ANALYSTS);
        Department designers = new Department(DepartmentType.DESIGNERS);
        Department developers = new Department(DepartmentType.DEVELOPERS);
        Department finances = new Department(DepartmentType.FINANCES);

        departments.add(management);
        departments.add(analysts);
        departments.add(designers);
        departments.add(developers);
        departments.add(finances);
    }

    public static ArrayList<Department> getDepartments() {
        return departments;
    }
}
