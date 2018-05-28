package lesson36.demo;

import lesson36.controllers.OrderController;
import lesson36.controllers.UserController;

import java.util.Date;

public class OrderDemo {
    public static void main(String[] args) {
        OrderController orderController = new OrderController();
        UserController userController = new UserController();

        try {
            userController.login("Honor", "123456");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        try {
            orderController.bookRoom(16030374, new Date(1, 4, 27), new Date(2018, 6, 3));
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        try {
            orderController.cancelReservation(16030374);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
