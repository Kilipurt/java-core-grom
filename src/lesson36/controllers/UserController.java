package lesson36.controllers;

import lesson36.exceptions.BadRequestException;
import lesson36.models.User;
import lesson36.services.UserService;

public class UserController {
    private Session session = new Session();
    private UserService userService = new UserService();

    public void registerUser(User user) throws Exception {
        userService.registerUser(user);
    }

    public void removeAccount(User user) throws Exception {
        userService.removeAccount(user);
    }

    public void logout() throws Exception {
        if (session.getAuthorizedUser() == null)
            throw new BadRequestException("User is not authorized");

        Session.setAuthorizedUser(null);
    }

    public void login(String userName, String password) throws Exception {
        if (userName == null || userName.isEmpty())
            throw new BadRequestException("Wrong  enter user name");

        if (password == null || password.isEmpty())
            throw new BadRequestException("Wrong enter password");

        Session.setAuthorizedUser(userService.login(userName, password));
    }
}
