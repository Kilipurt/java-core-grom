package gromcodemain.lesson8.phones.test;

import gromcodemain.lesson8.phones.Android;
import gromcodemain.lesson8.phones.Phone;

public class DemoAndroidTestClass {
    public static void main(String[] args) {

        //installNewAndroidVersion()
        //выводит сообщение +
        Android android = new Android(1000, 10, "Spain", "8", 100, "wrgwrg");

        android.installNewAndroidVersion();

        //orderPhone()
        //выводит сообщение +
        android.orderPhone();
    }
}
