package lesson18.homework;

public class Solution2 {

    public int[] findNumbers(String text) {
        if (text == null || text.isEmpty())
            return null;

        String[] words = text.trim().split(" ");

        int count = 0;

        for (String word : words) {
            if (isDigit(word))
                count++;
        }

        int[] digits = new int[count];
        int index = 0;

        for (String word : words) {
            if (isDigit(word)) {
                digits[index] = Integer.parseInt(word);
                index++;
            } else {
                System.out.println(word + " not a number");
            }
        }

        return digits;
    }

    private boolean isDigit(String input) {
        if (input.isEmpty())
            return false;

        char[] charArray = input.toCharArray();

        for (char ch : charArray) {
            if (!Character.isDigit(ch))
                return false;
        }

        return true;
    }
}
