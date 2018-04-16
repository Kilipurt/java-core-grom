package lesson27.homework.task2;

public class Demo {
    public static void main(String[] args) {
        User u1 = new User(1, "u1", "rwg2w");
        User u2 = new User(2, "u2", "wef24");
        User u3 = new User(2, "update", "wef24");

        UserRepository ur = new UserRepository();

        System.out.println(ur.getUsers().toString());

        try {
            System.out.println(ur.save(u1));
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        try {
            System.out.println(ur.save(u2));
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        try {
            System.out.println(ur.save(u1));
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        System.out.println(ur.getUsers().toString());

        try {
            ur.update(u3);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        try {
            ur.delete(1);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        System.out.println(ur.getUsers().toString());
    }
}
