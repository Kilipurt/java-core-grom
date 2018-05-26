package gromcodemain.lesson2;

public class SumAndDivision {
    public static void main(String[] args) {
        int a = 1;
        int sum = 0;

        while(a <= 1000){
            sum += a;
            a++;
        }

        int res1 = sum / 1234;
        int res2 = sum % 1234;

        System.out.println(res2 > res1);
    }
}
