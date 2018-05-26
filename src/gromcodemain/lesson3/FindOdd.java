package gromcodemain.lesson3;

public class FindOdd {
    public static void main(String[] args) {
        int i = 0;
        int sum = 0;
        while (i <= 1000) {
            if (i % 2 != 0) {
                System.out.println("Found");
                sum += i;
            }
            i++;
        }

        if (sum * 5 > 5000) {
            System.out.println("Bigger");
        } else {
            System.out.println("Smaller or equal");
        }
    }
}
