package lesson10.polyexample.test;

import lesson10.polyexample.Human;

public class DemoHumanTestClass {
    public static void main(String[] args) {
        Human human = new Human("Human");
        Human human1 = new Human(null);

        //run()
        //выводит два сообщения +
        //если имя null +

        human.run();

        human1.run();
    }
}
