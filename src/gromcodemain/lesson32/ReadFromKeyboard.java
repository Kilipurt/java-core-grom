package gromcodemain.lesson32;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class ReadFromKeyboard {
    public static void main(String[] args) {

        try {
            readKeyboardWithIOStream();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

    }

    private static void readKeyboardWithScanner() throws Exception {
        //using scanner
        Scanner scanner = new Scanner(System.in);

        int n = 2;

        System.out.println("Please enter your name");

        String name = scanner.nextLine();

        validateName(name);

        System.out.println("Hello, " + name);

        scanner.close();
    }

    private static void readKeyboardWithIOStream() throws Exception {

        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(reader);

        System.out.println("Please enter your name");

        String name = br.readLine();

        validateName(name);

        System.out.println("Hello, " + name + "!");
    }

    private static void validateName(String name) throws Exception {
        if (name == null || name.isEmpty())
            throw new Exception("Wrong enter name");

        for (char ch : name.toCharArray()) {
            if (!Character.isLetter(ch)) {
                throw new Exception("Name " + name + " has invalid characters");
            }
        }
    }
}
