package lesson36.repositories;

import lesson36.models.User;
import lesson36.models.UserType;

import java.util.ArrayList;

public class UserRepository extends GenericRepository<User> {

    public UserRepository() {
        setPath("D:\\JavaProjects\\UserDb.txt");
    }

    @Override
    public void setPath(String path) {
        super.setPath(path);
    }

    @Override
    public User create(User user) throws Exception {
        return super.create(user);
    }

    @Override
    public boolean isObjectExist(User user) {
        return super.isObjectExist(user);
    }

    @Override
    public void remove(User user) throws Exception {
        super.remove(user);
    }

    @Override
    public ArrayList<User> getAll() {
        return super.getAll();
    }

    @Override
    public User findById(long id) {
        return super.findById(id);
    }

    @Override
    public User map(String obj) {
        String[] fields = obj.split("([,][ ])");

        return new User(Long.parseLong(fields[0]), fields[1], fields[2], fields[3], UserType.valueOf(fields[4]));
    }

    @Override
    public String reverseMap(User obj) {
        return obj.getId() + ", "
                + obj.getUserName() + ", "
                + obj.getPassword() + ", "
                + obj.getCountry() + ", "
                + obj.getUserType().toString();
    }
}