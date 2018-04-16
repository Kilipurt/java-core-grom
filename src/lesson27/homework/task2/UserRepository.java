package lesson27.homework.task2;

import java.util.ArrayList;

public class UserRepository {
    private ArrayList<User> users = new ArrayList<>();

    public ArrayList<User> getUsers() {
        return users;
    }

    public User save(User user) throws Exception {
        if (user == null)
            throw new Exception("Can't save empty user");

        if (!users.contains(user)) {
            users.add(0, user);
            return users.get(0);
        }

        throw new Exception("User " + user.getId() + " already saved");
    }

    public User update(User user) throws Exception {
        if (user != null) {
            if (users.contains(user))
                throw new Exception("User " + user.getId() + " already saved");

            int index = 0;
            for (User us : users) {
                if (us != null && user.getId() == us.getId()) {
                    users.set(index, user);
                    return users.get(index);
                }
                index++;
            }
        }

        throw new Exception("User is empty. Can't update");
    }

    public User findById(long id) throws Exception {
        for (User user : users) {
            if (user != null && user.getId() == id)
                return user;
        }

        throw new Exception("User " + id + " was not found");
    }

    public void delete(long id) throws Exception {
        users.remove(findById(id));
    }
}


