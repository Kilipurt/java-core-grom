package lesson9.Task;

import java.util.Arrays;

public class Demo {
    public static void main(String[] args) {
        User u1 = new User(1, "u1", "rwg2w");
        User u2 = new User(2, "u2", "wef24");
        User[] usAr = {u1, u2};
        UserRepository ur = new UserRepository(usAr);
        System.out.println(Arrays.toString(ur.getUserNames()));
    }
}
