package lesson8.Task;

public class Arithmetic {
    boolean check(int[] array) {
        int min = array[0];
        int max = array[0];
        for (int i : array) {
            if (i < min)
                min = i;
            if (i > max)
                max = i;
        }
        return min + max > 100;
    }
}
