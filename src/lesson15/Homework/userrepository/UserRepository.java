package lesson15.Homework.userrepository;

public class UserRepository {
    private User[] users;

    public UserRepository(User[] users) {
        this.users = users;
    }

    public User[] getUsers() {
        return users;
    }

    public User save(User user) {
        if (users != null && user != null) {

            for (int i = 0; i < users.length; i++) {
                if (users[i].equals(user) && users[i].hashCode() == user.hashCode()) {
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
                if (user.getId() == users[i].getId()) {
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

    public String[] getUserNames() {
        if (users == null)
            return null;
        int count = 0;
        for (int i = 0; i < users.length; i++) {
            if (users[i] != null)
                count++;
        }

        int index = 0;
        String[] names = new String[count];
        for (int i = 0; i < users.length; i++) {
            if (users[i] != null) {
                names[index] = users[i].getName();
                index++;
            }

        }
        return names;
    }

    public long[] getUserIds() {
        if (users == null)
            return null;
        int count = 0;
        for (int i = 0; i < users.length; i++) {
            if (users[i] != null)
                count++;
        }
        long[] ids = new long[count];
        int index = 0;
        for (int i = 0; i < users.length; i++) {
            if (users[i] != null && index < ids.length) {
                ids[index] = users[i].getId();
            }
            index++;
        }
        return ids;
    }

    public String getUserNameById(long id) {
        if (users != null) {
            for (User user : users) {
                if (user != null && user.getId() == id) {
                    return user.getName();
                }
            }
        }
        return null;
    }

    public User getUserByName(String name) {
        if (users != null) {
            for (User user : users) {
                if (user != null && user.getName() == name)
                    return user;
            }
        }
        return null;
    }

    public User getUserById(long id) {
        if (users != null) {
            for (User user : users) {
                if (user != null && user.getId() == id)
                    return user;
            }
        }
        return null;
    }

    public User getUserBySessionId(String sessionId) {
        if (users != null) {
            for (User user : users) {
                if (user != null && user.getSessionId() == sessionId)
                    return user;
            }
        }
        return null;
    }
}


