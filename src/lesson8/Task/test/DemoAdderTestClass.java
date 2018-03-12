package lesson8.Task.test;

import lesson8.Task.Adder;

public class DemoAdderTestClass {
    public static void main(String[] args) {

        Adder adder = new Adder();
        int[] array = {5, -5, 10, -7, 16, 108};
        int[] array1 = {5, -5, 10, -7, 16, 10};

        //add(int a, int b)
        //считает сумму чисел +
        //если сумма с макс. интом +

        System.out.println(adder.add(1, 2));

        System.out.println(adder.add(1, Integer.MAX_VALUE));

        //check(int[] array)
        //проверяет больше ли сумма максимального и минимального элементов массива за 100 +
        //если массив null +

        System.out.println(adder.check(array));

        System.out.println(adder.check(array1));

        System.out.println(adder.check(null));
    }
}
