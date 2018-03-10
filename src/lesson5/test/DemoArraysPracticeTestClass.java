package lesson5.test;

import lesson5.ArraysPractice;

public class DemoArraysPracticeTestClass {
    public static void main(String[] args) {

        int[] array = {-10, 0, 110, 555, 1000, -45, 0, 60, 10};

        //maхElement(int[])
        //поиск максимального элемента массива +
        //если массив пустой +

        System.out.println(ArraysPractice.maxElement(array));

        int[] array1 = new int[5];
        System.out.println(ArraysPractice.maxElement(array1));

        //nCount(int[], int)
        //количество вхождений числа в массив +
        //если массив пустой +

        array1 = new int[5];
        System.out.println(ArraysPractice.nCount(array1, 5));

        for (int i = 0; i < 5; i++) {
            array1[i] = 5;
        }
        System.out.println(ArraysPractice.nCount(array1, 5));
    }
}
