package lesson34.homework.task1;

public class Demo {
    public static void main(String[] args) {
        try {
            Solution.transferFileContent("D:/JavaProjects/test1.txt", "D:/JavaProjects/test.txt");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
