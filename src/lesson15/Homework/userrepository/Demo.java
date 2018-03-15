package lesson15.Homework.userrepository;

import java.util.Arrays;

public class Demo {
    public static void main(String[] args) {
        User u1 = new User(1, "u1", "rwg2w");
        User u2 = new User(2, "u2", "wef24");

        UserRepository ur = new UserRepository();

        System.out.println(Arrays.toString(ur.getUsers()));

        System.out.println(ur.save(u1));
        System.out.println(ur.save(u2));
        System.out.println(ur.save(u1));

        System.out.println(Arrays.toString(ur.getUsers()));
        ur.delete(1);
        System.out.println(Arrays.toString(ur.getUsers()));
    }
}
