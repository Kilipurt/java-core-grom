package lesson36.controllers;

import lesson36.exceptions.BadRequestException;
import lesson36.models.User;
import lesson36.services.UserService;

public class UserController {
    private UserService userService = new UserService();
    private User authorizedUser;

    public User getAuthorizedUser() {
        return authorizedUser;
    }

    public void setAuthorizedUser(User authorizedUser) {
        this.authorizedUser = authorizedUser;
    }

    public void logout() throws Exception {
        if (authorizedUser == null)
            throw new BadRequestException("User is not authorized");

        authorizedUser = null;
    }

    public void registerUser(User user) throws Exception {
        userService.registerUser(user);
    }

    public void login(String userName, String password) throws Exception {
        if (userName == null || userName.isEmpty())
            throw new BadRequestException("Wrong  enter user name");

        if (password == null || password.isEmpty())
            throw new BadRequestException("Wrong enter password");

        authorizedUser = userService.login(userName, password);
    }

    public void removeAccount(User user) throws Exception {
        userService.removeAccount(user);
    }
}
