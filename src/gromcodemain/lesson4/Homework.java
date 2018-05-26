package gromcodemain.lesson4;

public class Homework {
    public static void main(String[] args) {
        short a = 0;
        short b = 10;
        //System.out.println(findDivCount(a, b, 2));
        int c = 2147483647;

        System.out.println(compareSums(5, 0, 3, c));
       // System.out.println(sum(5,5));
        //System.out.println(sum(3,6));
        //System.out.println(c);
        //System.out.println(c + 1);
    }

    public static int findDivCount(short a, short b, int n){
        int count = 0;
        for(int i = a; i <= b; i++){
            if(i % n == 0){
                count++;
            }
        }
        return count;
    }

    public static boolean compareSums(int a, int b, int c, int d){
        return sum(a,b)> sum(c,d);
    }

    public static long sum(int from, int to){
        long sum1 = 0;
        if(from <= to) {
            for (long i = from; i <= to; i++) {
                sum1 += i;
            }
        }
        return sum1;
    }
}
