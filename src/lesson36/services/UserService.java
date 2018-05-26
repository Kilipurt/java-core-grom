package lesson36.services;

import lesson36.exceptions.BadRequestException;
import lesson36.models.User;
import lesson36.repositories.UserRepository;

public class UserService {
    private UserRepository userRepository = new UserRepository();
    private User loginUser;

    public User getLoginUser() {
        return loginUser;
    }

    public void setLoginUser(User loginUser) {
        this.loginUser = loginUser;
    }

    public void registerUser(User user) throws Exception {
        validateUser(user);

        userRepository.create(user);
    }

    public void login(String userName, String password) throws Exception {
        if (userName == null || userName.isEmpty())
            throw new BadRequestException("Wrong  enter user name");

        if (password == null || password.isEmpty())
            throw new BadRequestException("Wrong enter password");

        for (User user : userRepository.getAll()) {
            if (user.getUserName().equals(userName) && user.getPassword().equals(password)) {
                loginUser = user;
            }
        }
    }

    public void logout() throws Exception {
        if (loginUser == null)
            throw new BadRequestException("User are not authorized");

        loginUser = null;
    }

    public void removeAccount(User user) throws Exception {
        validateUser(user);

        userRepository.remove(user);
    }

    private void validateUser(User user) throws BadRequestException {
        if (user.getUserName() == null || user.getUserName().isEmpty())
            throw new BadRequestException("Wrong enter user name");

        if (user.getPassword() == null || user.getPassword().isEmpty())
            throw new BadRequestException("Wrong enter password");

        if (user.getCountry() == null || user.getCountry().isEmpty())
            throw new BadRequestException("Wrong enter country");

        if (user.getUserType() == null)
            throw new BadRequestException("Wrong enter user type");
    }
}
