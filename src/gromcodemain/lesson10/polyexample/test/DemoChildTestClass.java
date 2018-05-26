package gromcodemain.lesson10.polyexample.test;

import gromcodemain.lesson10.polyexample.Child;

public class DemoChildTestClass {
    public static void main(String[] args) {
        Child child = new Child("Child");
        Child child1 = new Child(null);

        //run()
        //выводит три сообщения +
        //если имя null +

        child.run();

        child1.run();
    }
}
