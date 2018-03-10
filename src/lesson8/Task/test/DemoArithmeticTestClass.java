package lesson8.Task.test;

import lesson8.Task.Arithmetic;

public class DemoArithmeticTestClass {
    public static void main(String[] args) {
        Arithmetic arithmetic = new Arithmetic();
        int[] array = {5, -5, 10, -7, 16, 108};
        int[] array1 = {5, -5, 10, -7, 16, 10};

        //check(int[] array)
        //проверяет больше ли сумма максимального и минимального элементов массива за 100 +

        System.out.println(arithmetic.check(array));

        System.out.println(arithmetic.check(array1));
    }
}
