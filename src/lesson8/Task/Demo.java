package lesson8.Task;

public class Demo {
    public static void main(String[] args) {
        int[] array = {5, -5, 10, -7, 16, 108};
        Adder adderObject = new Adder();
        adderObject.check(array);
        adderObject.add(5, 8);
    }
}
