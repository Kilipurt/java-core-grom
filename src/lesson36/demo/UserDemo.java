package lesson36.demo;

import lesson36.controllers.UserController;
import lesson36.models.User;
import lesson36.models.UserType;

public class UserDemo {
    public static void main(String[] args) {
        UserController userController = new UserController();

        User user = new User("Kilipurt", "123456", "Ukraine", UserType.USER);

        try {
            userController.registerUser(user);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        try {
            userController.login("Kilipurt", "123456");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        try {
            userController.logout();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        try {
            userController.removeAccount(user);
        } catch (Exception e) {
            e.getMessage();
        }
    }
}
