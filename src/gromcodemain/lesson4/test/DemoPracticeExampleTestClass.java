package gromcodemain.lesson4.test;

import gromcodemain.lesson4.PracticeExample;

public class DemoPracticeExampleTestClass {
    public static void main(String[] args) {

        //min(int, int, int)
        //поиск минимального числа среди 3-х чисел +
        //если 3 числа одинаковые +

        System.out.println(PracticeExample.min(3, 5, -3));
        System.out.println(PracticeExample.min(3, 3, 3));

        //average(int)
        //подсчет среднего арифметичиского от 1 к указаном числу +
        //если число отрицательное +

        System.out.println(PracticeExample.average(6));
        System.out.println(PracticeExample.average(-6));

        //average(int, int)
        //подсчет среднего арифметичиского +
        //тип возращаемого значения +
        //если первое число меньше чем второе +

        System.out.println(PracticeExample.average(2, 5));
        System.out.println(PracticeExample.average(6, 3));

        //count(int, int, int)
        //подсчет количества кратных чисел на промежутке +
        //если промежуток задан одним числом +
        //если начало промежутка больше чем конец +
        //если последний параметр отрицательный +

        System.out.println(PracticeExample.count(10, 12, 2));
        System.out.println(PracticeExample.count(12, 12, 2));
        System.out.println(PracticeExample.count(12, 10, 2));
        System.out.println(PracticeExample.count(10, 12, -2));
    }
}
