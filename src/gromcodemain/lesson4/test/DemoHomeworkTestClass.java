package gromcodemain.lesson4.test;

import gromcodemain.lesson4.Homework;

public class DemoHomeworkTestClass {
    public static void main(String[] args) {

        //sum(int, int)
        //сумма на промежутке +
        //если результат превышает макс. инт +
        //если первое число больше второго +
        //если первое и второе числа одинаковые +
        //если первое и второе числа отрицательные +

        System.out.println(Homework.sum(10, 12));
        System.out.println(Homework.sum(0, Integer.MAX_VALUE));
        System.out.println(Homework.sum(12, 10));
        System.out.println(Homework.sum(10, 10));
        System.out.println(Homework.sum(-10, -8));

        //compareSums(int,int,int,int)
        //сравнение сумм +
        //если суммы на промежутках одинаковые +
        //если суммы на промежутках отрицательные +

        System.out.println(Homework.compareSums(1, 2, 3, 4));
        System.out.println(Homework.compareSums(1, 1, 1, 1));
        System.out.println(Homework.compareSums(-3, -2, -5, -1));
    }
}
