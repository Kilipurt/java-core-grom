package lesson34.homework.task2;

public class Demo {
    public static void main(String[] args) {
        try {
            Solution.transferSentences("D:/JavaProjects/test.txt", "D:/JavaProjects/test1.txt", "qwerty");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
