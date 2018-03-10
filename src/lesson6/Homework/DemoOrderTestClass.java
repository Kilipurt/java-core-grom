package lesson6.Homework;

import java.util.Date;

public class DemoOrderTestClass {
    public static void main(String[] args) {

        Order orderObject = new Order(100, new Date(17,8,8,8,8,8), false, new Date(), "Kiev", "Ukraine", "SomeValue");

        //confirmOrder()
        //изменяет дату заказа на текущую и проставляет статус заказа true +
        orderObject.confirmOrder();

        System.out.println(orderObject.toString());

        //checkPrice()
        //возвращает true если цена больше 1000 и false если меньше или ровно +
        System.out.println(orderObject.checkPrice());

        //isValidType()
        //возвращает true если поле ровно "Buy" или "Sale" и false если нет +
        System.out.println(orderObject.isValidType());
    }
}
