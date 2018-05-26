package lesson36.services;

import lesson36.exceptions.BadRequestException;
import lesson36.exceptions.ObjectNotFoundException;
import lesson36.models.User;
import lesson36.repositories.UserRepository;

public class UserService {
    private UserRepository userRepository = new UserRepository();

    public void registerUser(User user) throws Exception {
        validateUser(user);

        userRepository.create(user);
    }

    public User login(String userName, String password) throws Exception {
        for (User user : userRepository.getAll()) {
            if (user.getUserName().equals(userName) && user.getPassword().equals(password)) {
                return user;
            }
        }

        throw new ObjectNotFoundException("User " + userName + " was not found");
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
