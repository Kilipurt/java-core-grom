package lesson6;

import java.util.Date;

public class DemoUserTestClass {
    public static void main(String[] args) {
        Date date = new Date(17, 8, 8, 8, 8, 8);
        User user = new User("Oleg", 17, "Kiev", date, false);

        System.out.println(user.toString());

        //login()
        //изменять дату на новую +
        user.login();

        System.out.println(user.toString());

        //increaseAge()
        //увеличивать возраст на 1 +
        user.increaseAge();

        System.out.println(user.toString());

        //isActive(boolean status)
        //изменять статус активности +
        user.isActive(true);

        System.out.println(user.toString());
    }
}
