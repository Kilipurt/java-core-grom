package gromcodemain.lesson30.homework;

import java.util.ArrayList;
import java.util.Collection;

public class Department {
    private DepartmentType type;
    private Collection<Employee> employees;

    public Department(DepartmentType type) {
        this.type = type;
        this.employees = new ArrayList<>();
    }

    public DepartmentType getType() {
        return type;
    }

    public Collection<Employee> getEmployees() {
        return employees;
    }
}
