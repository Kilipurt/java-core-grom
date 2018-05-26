package gromcodemain.lesson22.repository;

public class UserRepository {
    private static User[] users = new User[10];

    public static User[] getUsers() {
        return users;
    }

    public static User save(User user) {
        if (users != null && user != null && findById(user.getId()) == null) {
            for (int i = 0; i < users.length; i++) {
                if (users[i] == null) {
                    users[i] = user;
                    return users[i];
                }
            }
        }
        return null;
    }

    public static User findById(long id) {
        if (users != null) {
            for (User user : users) {
                if (user != null && user.getId() == id)
                    return user;
            }
        }
        return null;
    }

    public static void delete(long id) {
        if (users == null)
            return;
        User user = findById(id);
        for (int i = 0; i < users.length; i++) {
            if (users[i] == user) {
                users[i] = null;
            }
        }
    }

    public static User update(User user) {
        if (users != null && user != null && findById(user.getId()) != null) {
            for (int i = 0; i < users.length; i++) {
                if (users[i] != null && user.getId() == users[i].getId()) {
                    users[i] = user;
                    return users[i];
                }
            }
        }
        return null;
    }
}


