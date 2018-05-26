package gromcodemain.lesson5.test;

import gromcodemain.lesson5.Homework;

import java.util.Arrays;

public class DemoHomeworkTestClass {
    public static void main(String[] args) {

        int[] array = {0, 5, 1, -8, 6, 9, 10};

        //sortAscending(int[])
        //сортировка массива в порядке возрастания +
        //если массив пустой +
        //если массив не полный +
        //если массив null +

        System.out.println(Arrays.toString(Homework.sortAscending(array)));

        array = new int[5];
        System.out.println(Arrays.toString(Homework.sortAscending(array)));

        array[0] = 5;
        array[3] = 10;

        System.out.println(Arrays.toString(Homework.sortAscending(array)));

        System.out.println(Homework.sortAscending(null));

        int[] array1 = {0, 5, 1, -8, 6, 9, 10};

        //sortDescending(int[])
        //сортировка массива в порядке убывания +
        //если массив пустой +
        //если массив не полный +
        //если массив null +

        System.out.println(Arrays.toString(Homework.sortDescending(array1)));

        array1 = new int[5];
        System.out.println(Arrays.toString(Homework.sortDescending(array1)));

        array1[0] = 5;
        array1[2] = 10;
        System.out.println(Arrays.toString(Homework.sortDescending(array1)));

        System.out.println(Homework.sortDescending(null));

        int[] array2 = {0, 5, 0, -8, 6, 9, 10};

        //uniqueCount(int[])
        //считает количество вхождений уникальных чисел +
        //если массив пустой +
        //если массив не полный +
        //если массив null +

        System.out.println(Homework.uniqueCount(array2));

        array2 = new int[5];
        System.out.println(Homework.uniqueCount(array2));

        array2[0] = 1;
        array2[2] = 5;
        System.out.println(Homework.uniqueCount(array2));

        System.out.println(Homework.uniqueCount(null));
    }
}
