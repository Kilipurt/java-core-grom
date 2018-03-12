package lesson10.polyexample.test;


import lesson10.polyexample.User;

public class DemoUserTestClass {
    public static void main(String[] args) {
        User user = new User("User");
        User user1 = new User(null);

        //run()
        //выводит три сообщения +
        //если имя null +

        user.run();

        user1.run();
    }
}
