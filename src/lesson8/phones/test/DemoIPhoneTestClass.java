package lesson8.phones.test;

import lesson8.phones.IPhone;

public class DemoIPhoneTestClass {
    public static void main(String[] args) {
        IPhone iPhone = new IPhone(110, 10.0, "China", true);

        //deleteIPhoneFromDb()
        //выводит сообщение +
        iPhone.deleteIPhoneFromDb();

        //orderPhone()
        //выводит сообщение +
        iPhone.orderPhone();
    }
}
