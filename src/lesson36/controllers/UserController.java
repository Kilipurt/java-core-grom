package lesson36.controllers;

import lesson36.models.User;
import lesson36.services.UserService;

public class UserController {
    private UserService userService = new UserService();

    public void registerUser(User user) {
        try {
            userService.registerUser(user);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public void login(String userName, String password) {
        try {
            userService.login(userName, password);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public void logout() {
        try {
            userService.logout();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public void removeAccount(User user) {
        try {
            userService.removeAccount(user);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
