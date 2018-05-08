package lesson31.homework;

public class Demo {
    public static void main(String[] args) {
        String text = "erig erig reiuh 1erih 65erih ,erhui hier oiqu i uui";

        try {
            System.out.println(Solution.countSymbols(text));
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        try {
            System.out.println(Solution.words(text));
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
