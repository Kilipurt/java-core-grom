package lesson36.demo;

import lesson36.controllers.UserController;
import lesson36.models.User;
import lesson36.models.UserType;

public class UserDemo {
    public static void main(String[] args) {
        UserController userController = new UserController();

        User user = new User("Kilipurt", "123456", "Ukraine", UserType.USER);

        userController.registerUser(user);
        userController.login("Kilipurt", "123456");
        userController.logout();

        userController.removeAccount(user);
    }
}
