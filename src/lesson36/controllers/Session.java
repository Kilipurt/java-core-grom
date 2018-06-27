package lesson36.controllers;

import lesson36.models.User;

public class Session {
    private static User authorizedUser;

    public User getAuthorizedUser() {
        return authorizedUser;
    }

    public static void setAuthorizedUser(User authorizedUser) {
        Session.authorizedUser = authorizedUser;
    }
}
