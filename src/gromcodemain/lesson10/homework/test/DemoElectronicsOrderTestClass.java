package gromcodemain.lesson10.homework.test;

import gromcodemain.lesson10.homework.Customer;
import gromcodemain.lesson10.homework.ElectronicsOrder;

import java.util.Date;

public class DemoElectronicsOrderTestClass {
    public static void main(String[] args) {
        Customer customer0 = new Customer("Надя", "Киев", "Женский");
        Customer customer2 = new Customer("Надя", "К", "Женский");
        Customer customer1 = new Customer("Вениамин", "Киев", "Мужской");
        ElectronicsOrder elOrder1 = new ElectronicsOrder("Lamp", null, "Киев", customer0.getCity(), 200, customer0, 5);
        ElectronicsOrder elOrder2 = new ElectronicsOrder("Phone", null, "Одесса", customer1.getCity(), 1100, customer1, 9);
        ElectronicsOrder elOrder3 = new ElectronicsOrder("Lamp", null, "Днепр", customer0.getCity(), 50, customer0, 5);
        ElectronicsOrder elOrder4 = new ElectronicsOrder("Lamp", null, "Харьков", customer2.getCity(), 50, customer0, 5);

        //validateOrder()
        //проверяет правильный ли заказ и меняет дату на текущую +
        //если пол "Мужской" +
        //если цена меньше 100 +
        //если города с которого был сделан заказ и куда не подходят +

        elOrder1.validateOrder();
        System.out.println(elOrder1.toString());

        elOrder2.validateOrder();
        System.out.println(elOrder2.toString());

        elOrder3.validateOrder();
        System.out.println(elOrder3.toString());

        elOrder3.validateOrder();
        System.out.println(elOrder3.toString());

        elOrder4.validateOrder();
        System.out.println(elOrder4.toString());

        //calculatePrice()
        //считает общую сумму заказа +
        //если сумма меньше 1000 +
        //если заказ с города "Киев" или "Одесса" +

        elOrder1.calculatePrice();
        System.out.println(elOrder1.toString());

        elOrder2.calculatePrice();
        System.out.println(elOrder2.toString());

        elOrder3.calculatePrice();
        System.out.println(elOrder3.toString());

        //confirmShipping()
        //проставляет дату заказа на текущую +
        //есди дата уже текущая +

        System.out.println(elOrder1.getDateShipped());
        elOrder1.confirmShipping();
        System.out.println(elOrder1.getDateShipped());

        elOrder2.setDateShipped(new Date());
        System.out.println(elOrder2.getDateShipped());
        elOrder2.confirmShipping();
        System.out.println(elOrder2.getDateShipped());

    }
}
