package gromcodemain.lesson30.homework;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;

public class Firm {
    private Date dateFounded;
    private Collection<Department> departments;
    private Collection<Customer> customers;

    public Firm(Date dateFounded) {
        this.dateFounded = dateFounded;
        this.departments = new HashSet<>();
        this.customers = new ArrayList<>();
    }

    public Date getDateFounded() {
        return dateFounded;
    }

    public Collection<Department> getDepartments() {
        return departments;
    }

    public Collection<Customer> getCustomers() {
        return customers;
    }
}
