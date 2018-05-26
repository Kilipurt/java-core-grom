package gromcodemain.lesson32.homework;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

    public static int readNumbers() throws Exception {
        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(reader);

        int n = 2;
        String[] numbers = null;

        while (n >= 0) {
            numbers = br.readLine().split(" ");

            if (!validateNumbers(numbers)) {
                if (n == 0) {
                    throw new Exception("Your numbers are wrong. Number of attempts exceeded");
                } else {
                    System.out.println("Your numbers are wrong. You have " + n + " attempts to try again");
                }
            } else {
                break;
            }

            n--;
        }

        return sumOfNumbers(numbers);
    }

    private static int sumOfNumbers(String[] numbers) {
        int sum = 0;

        for (String number : numbers) {
            sum += Integer.parseInt(number);
        }

        return sum;
    }

    private static boolean validateNumbers(String[] numbers) {
        if (numbers == null || numbers.length != 10)
            return false;

        for (String number : numbers) {
            if (number.isEmpty())
                return false;

            for (char ch : number.toCharArray()) {
                if (!Character.isDigit(ch))
                    return false;
            }

            if (Integer.parseInt(number) > 100)
                return false;
        }

        return true;
    }
}
