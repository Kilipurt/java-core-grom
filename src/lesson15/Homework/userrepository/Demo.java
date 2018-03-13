package lesson15.Homework.userrepository;

import java.util.Arrays;

public class Demo {
    public static void main(String[] args) {
        User u1 = new User(1, "u1", "rwg2w");
        User u2 = new User(2, "u2", "wef24");
        User[] usAr = new User[10];

        usAr[0] = u1;
        usAr[1] = u2;

        UserRepository ur = new UserRepository();
        usAr = ur.getUsers();

        System.out.println(ur.save(u2));

        ur.delete(1);

        System.out.println(Arrays.toString(usAr));
    }
}
