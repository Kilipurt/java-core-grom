package lesson30.homework;

import java.util.ArrayList;

public class CustomerDAO {
    private static ArrayList<Customer> customers = new ArrayList<>();

    public CustomerDAO() {
        Customer customer1 = new Customer("01", "Ukraine", 20);
        Customer customer2 = new Customer("02", "Ukraine", 30);
        Customer customer3 = new Customer("03", "Ukraine", 40);
        Customer customer4 = new Customer("04", "Ukraine", 50);
        Customer customer5 = new Customer("05", "Ukraine", 60);
        Customer customer6 = new Customer("06", "Ukraine", 70);

        customers.add(customer1);
        customers.add(customer2);
        customers.add(customer3);
        customers.add(customer4);
        customers.add(customer5);
        customers.add(customer6);
    }

    public static ArrayList<Customer> getCustomers() {
        return customers;
    }
}
