package lesson33.homework;

import java.io.FileNotFoundException;

public class Demo {
    public static void main(String[] args) {
        try {
            WriteToFile.writeToFileFromConsole("D:\\JavaProjects\\test1.txt");
        } catch (FileNotFoundException e) {
            System.err.println(e.getMessage());
        }
        try {
            ReadFromFile.readFileByConsolePath();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
