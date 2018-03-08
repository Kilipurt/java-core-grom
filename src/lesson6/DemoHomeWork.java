package lesson6;

import java.util.Date;

public class DemoHomeWork {
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
