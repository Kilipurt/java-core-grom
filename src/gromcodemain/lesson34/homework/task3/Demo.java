package gromcodemain.lesson34.homework.task3;

public class Demo {
    public static void main(String[] args) {
        try {
            Solution.copyFileContent("D:/JavaProjects/test.txt", "D:/JavaProjects/test1.txt");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        try {
            Solution.copyFileContentApacheIO("D:/JavaProjects/test.txt", "D:/JavaProjects/test1.txt");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
