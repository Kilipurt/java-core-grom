package lesson31.homework;

public class Demo {
    public static void main(String[] args) {
        String text1 = "";
        String text2 = null;
        String text3 = "s";
        String text4 = "sss";
        String text5 = "s456 ewgwg rw";

        try {
            System.out.println(Solution.countSymbols(text1));
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        try {
            System.out.println(Solution.countSymbols(text2));
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        try {
            System.out.println(Solution.countSymbols(text3));
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        try {
            System.out.println(Solution.countSymbols(text4));
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        try {
            System.out.println(Solution.countSymbols(text5));
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }


        try {
            System.out.println(Solution.words(text1));
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        try {
            System.out.println(Solution.words(text2));
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        try {
            System.out.println(Solution.words(text3));
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        try {
            System.out.println(Solution.words(text4));
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        try {
            System.out.println(Solution.words(text5));
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
