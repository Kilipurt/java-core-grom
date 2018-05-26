package gromcodemain.lesson10.homework;

import java.util.Date;

public class Demo {
    public static void main(String[] args) {

        //Electronics orders
        Customer customer0 = new Customer("Надя", "Киев", "Женский");
        Customer customer1 = new Customer("Вениамин", "Киев", "Мужской");
        ElectronicsOrder elOrder1 = new ElectronicsOrder("Lamp", new Date(), "Одесса", customer0.getCity(), 200, customer0, 5);
        ElectronicsOrder elOrder2 = new ElectronicsOrder("Phone", null, "Харьков", customer1.getCity(), 1100, customer1, 9);

        //First electronics order

        elOrder1.validateOrder();
        elOrder1.calculatePrice();
        elOrder1.confirmShipping();

        System.out.println(elOrder1.print());

        //Second electronics order

        elOrder2.validateOrder();
        elOrder2.calculatePrice();
        elOrder2.confirmShipping();

        System.out.println(elOrder2.print());

        //Furniture orders
        Customer customer2 = new Customer("Петро", "Париж", "Мужской");
        Customer customer3 = new Customer("Тест", "Ялта", "Женский");
        FurnitureOrder furOrder = new FurnitureOrder("Chair", new Date(), "Львов", customer2.getCity(), 600, customer2, "grheure");
        FurnitureOrder furOrder1 = new FurnitureOrder("Chair1", new Date(), "Париж", customer3.getCity(), 900, customer3, "grheuуцуre");

        //First furniture order

        furOrder.validateOrder();
        furOrder.calculatePrice();
        furOrder.confirmShipping();

        System.out.println(furOrder.print());

        //Second furniture order

        furOrder1.validateOrder();
        furOrder1.calculatePrice();
        furOrder1.confirmShipping();

        System.out.println(furOrder1.print());
    }
}
