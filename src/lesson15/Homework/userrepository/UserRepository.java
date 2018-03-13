package lesson15.Homework.userrepository;

public class UserRepository {
    private User[] users = new User[10];

    public User[] getUsers() {
        return users;
    }

    public User save(User user) {
        if (user != null || users != null) {

            for (int i = 0; i < users.length; i++) {
                if (users[i] != null && users[i].equals(user) && users[i].hashCode() == user.hashCode()) {
                    return null;
                }
            }

            for (int i = 0; i < users.length; i++) {
                if (users[i] == null) {
                    users[i] = user;
                    return users[i];
                }
            }
        }
        return null;
    }

    public void delete(User user) {
        if (users == null || user == null)
            return;
        for (int i = 0; i < users.length; i++) {
            if (users[i] != null && users[i].equals(user) && users[i].hashCode() == user.hashCode()) {
                users[i] = null;
            }
        }
    }

    public User update(User user) {
        if (users != null && user != null) {

            for (int i = 0; i < users.length; i++) {
                if (users[i] != null && user.getId() == users[i].getId()) {
                    users[i] = user;
                    return users[i];
                }
            }
        }
        return null;
    }

    public User findById(long id) {
        if (users != null) {
            for (User user : users) {
                if (user != null && user.getId() == id)
                    return user;
            }
        }
        return null;
    }

    public void delete(long id) {
        User user = findById(id);
        if(user != null)
        for (int i = 0; i < users.length; i++) {
            if (users[i] != null && users[i].equals(user) && users[i].hashCode() == user.hashCode()) {
                users[i] = null;
            }
        }
    }
}


