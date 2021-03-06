package gromcodemain.lesson13;

public class UserRepository {
    private User[] users = new User[10];

    /*public UserRepository(User[] users) {
        this.users = users;
    }*/

    public User[] getUsers() {
        return users;
    }

    public String[] getUserNames() {
        String[] names = new String[users.length];
        for (int i = 0; i < users.length; i++) {
            if (users[i] != null)
                names[i] = users[i].getName();
        }
        return names;
    }

    public long[] getUserIds() {
        int count = 0;
        for (int i = 0; i < users.length; i++) {
            if (users[i] != null)
                count++;
        }
        long[] ids = new long[count];
        int index = 0;
        for(int i = 0; i < users.length; i++){
            if(users[i] != null){
                ids[index] = users[i].getId();
            }
            index++;
        }
        return ids;
    }

    public String getUserNameById(long id) {
        if(users != null) {
            for (User user : users) {
                if (user != null && user.getId() == id) {
                    return user.getName();
                }
            }
        }
        return null;
    }

    public User getUserByName(String name){
        if(users != null){
            for(User user : users){
                if(user != null && user.getName() == name)
                    return user;
            }
        }
        return null;
    }

    public User getUserById(long id){
        if(users != null){
            for(User user : users){
                if(user != null && user.getId() == id)
                    return user;
            }
        }
        return null;
    }

    public User getUserBySessionId(String sessionId){
        if(users != null){
            for(User user : users){
                if(user != null && user.getSessionId() == sessionId)
                    return user;
            }
        }
        return null;
    }

    public User save(User user){
        if(user != null && findById(user.getId()) == null) {
            for (int i = 0; i < users.length; i++) {
                if (users[i] == null) {
                    users[i] = user;
                    return user;
                }
            }
        }
        return null;
    }

    public User findById(long id){
        if(users != null){
            for(User user : users){
                if(user != null && user.getId() == id)
                    return user;
            }
        }
        return null;
    }

    public void delete(long id){
        User user = findById(id);
        for(int i = 0; i < users.length; i++){
            if(users[i] == user){
                users[i] = null;
            }
        }
    }

    public User update(User user){
        if(user != null && findById(user.getId()) != null){
            for(int i = 0; i < users.length; i++){
                if(user.getId() == users[i].getId()){
                    users[i] = user;
                    return users[i];
                }
            }
        }
        return null;
    }
}


