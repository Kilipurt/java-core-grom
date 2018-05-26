package gromcodemain.lesson10.homework.test;

import gromcodemain.lesson10.homework.Customer;
import gromcodemain.lesson10.homework.FurnitureOrder;

import java.util.Date;

public class DemoFurnitureOrderTestClass {
    public static void main(String[] args) {
        Customer customer0 = new Customer("Тест", "Киев", "Женский");
        Customer customer2 = new Customer("Надя", "Львов", "Женский");
        Customer customer1 = new Customer("Вениамин", "Харьков", "Мужской");
        FurnitureOrder furnitureOrder1 = new FurnitureOrder("Lamp", null, "Киев", customer0.getCity(), 600, customer1, "ewg");
        FurnitureOrder furnitureOrder2 = new FurnitureOrder("Phone", null, "Одесса", customer1.getCity(), 1100, customer1, "ewg1");
        FurnitureOrder furnitureOrder3 = new FurnitureOrder("Lamp", null, "Львов", customer0.getCity(), 50, customer2, "ewg2");
        FurnitureOrder furnitureOrder4 = new FurnitureOrder("Lamp", null, "Киев", customer2.getCity(), 5000, customer0, "ewg3");
        FurnitureOrder furnitureOrder5 = new FurnitureOrder("Lamp", null, "Киев", customer2.getCity(), 5005, customer1, "ewg3");


        //validateOrder()
        //проверяет правильный ли заказ и меняет дату на текущую +
        //если имя "Тест" +
        //если цена меньше 500 +
        //если города с которого был сделан заказ "Киев" или "Львов" +

        furnitureOrder1.validateOrder();
        System.out.println(furnitureOrder1.toString());

        furnitureOrder4.validateOrder();
        System.out.println(furnitureOrder4.toString());

        furnitureOrder3.validateOrder();
        System.out.println(furnitureOrder3.toString());

        furnitureOrder2.validateOrder();
        System.out.println(furnitureOrder2.toString());

        //calculatePrice()
        //считает общую сумму заказа +
        //если сумма заказа меньше 5000 +
        //если сумма заказа больше 5000 +

        furnitureOrder1.calculatePrice();
        System.out.println(furnitureOrder1.toString());

        furnitureOrder5.calculatePrice();
        System.out.println(furnitureOrder5.toString());

        //confirmShipping()
        //проставляет дату заказа на текущую +
        //есди дата уже текущая +

        System.out.println(furnitureOrder1.getDateShipped());
        furnitureOrder1.confirmShipping();
        System.out.println(furnitureOrder1.getDateShipped());

        furnitureOrder5.setDateShipped(new Date());
        System.out.println(furnitureOrder5.getDateShipped());
        furnitureOrder5.confirmShipping();
        System.out.println(furnitureOrder5.getDateShipped());
    }
}
