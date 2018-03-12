package lesson8.ads.test;

import lesson8.ads.Message;
import lesson8.ads.User;

public class DemoMessageTestClass {
    public static void main(String[] args) {

        User user = new User(1, "Ann", "ef");
        User user1 = new User(2, "Ann1", "efe");
        Message message = new Message(123, user, user1, "ewgweg");
        Message message1 = new Message(123, user, user1, "ewgweg");

        //setDateRead()
        //меняет дату прочтения на текущую +

        message.setDateRead();
        System.out.println(message.toString());

        //isRead()
        //проверяет было ли прочтено письмо, путем проверки даты прочтения +

        System.out.println(message.isRead());

        System.out.println(message1.isRead());


    }
}
