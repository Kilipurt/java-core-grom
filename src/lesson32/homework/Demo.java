package lesson32.homework;

public class Demo {
    public static void main(String[] args) {
        try {
            System.out.println(Solution.readNumbers());
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
