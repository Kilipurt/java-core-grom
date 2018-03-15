package tasksforall;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        String input = "abc";
        System.out.println(Arrays.toString(findSequences(input)));
    }

    public static String[] findSequences(String input) {
        char[] arrayOfInputSymbols = input.toCharArray();

        int lengthOfInput = input.length();
        int numberOfSequences = (int) Math.pow(2, lengthOfInput) - 1;
        String[] allSequences = new String[numberOfSequences];

        String sequence = "";

        for (int i = 1; i <= numberOfSequences; i++) {
            char[] binaryCodeOfSymbol = Integer.toBinaryString(i).toCharArray();
            int index = lengthOfInput - binaryCodeOfSymbol.length;

            for (int j = 0; j < binaryCodeOfSymbol.length; j++) {
                if (binaryCodeOfSymbol[j] == '1') {
                    sequence += arrayOfInputSymbols[index];
                }
                index++;
            }
            allSequences[i - 1] = sequence;
            sequence = "";
        }
        return allSequences;
    }
}
