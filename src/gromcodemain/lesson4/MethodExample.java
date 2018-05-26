package gromcodemain.lesson4;

public class MethodExample {

    public static void main(String[] args) {
        System.out.println(increaser(5, 20));

        System.out.println(min(increaser(10, 5), 11));
    }

    public static long increaser(long a, int index) {
        System.out.println("method invoked");
        a += index;
        System.out.println("method before return");
        return a;
    }

    public static long min(long a, long b) {
        return a < b ? a : b;
    }
}
