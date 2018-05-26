package gromcodemain.lesson4.test;

import gromcodemain.lesson4.MethodExample;

public class DemoMethodExampleTestClass {
    public static void main(String[] args) {

        //increaser(int, int)
        //увеличение числа +
        //когда увеличиваем число на макс. инт +

        System.out.println(MethodExample.increaser(13, 2));
        System.out.println(MethodExample.increaser(13, Integer.MAX_VALUE));

        //min(long, long)
        //вычисление минимального из двух +
        //параметры одинаковые +

        System.out.println(MethodExample.min(13, 15));
        System.out.println(MethodExample.min(13, 13));
    }
}
