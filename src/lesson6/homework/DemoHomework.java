package lesson6.homework;

import java.util.Date;

public class DemoHomework {
    Order createOrder(){
        Order orderObject = new Order(100, new Date(), false, null, "Dnepr", "Ukraine", "Buy");
        return orderObject;
    }

    Order createOrderAndCallMethods(){
        Order orderObject = new Order(100, new Date(), true, new Date(), "Kiev", "Ukraine", "SomeValue");
        orderObject.checkPrice();
        orderObject.confirmOrder();
        orderObject.isValidType();
        return orderObject;
    }
}
