package lesson8.task;

public class Arithmetic {
    public boolean check(int[] array) {
        if (array == null)
            return false;
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
