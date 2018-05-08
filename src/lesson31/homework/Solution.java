package lesson31.homework;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static Map<Character, Integer> countSymbols(String text) throws Exception {
        if (text == null || text.isEmpty())
            throw new Exception("Text is empty");

        Map<Character, Integer> map = new HashMap<>();

        Character[] array = text.chars().mapToObj(i -> (char) i).toArray(Character[]::new);

        for (Character symbol : array) {
            if (Character.isLetter(symbol)) {
                map.put(symbol, numberOfRepetitions(array, symbol));
            }
        }

        return map;
    }

    public static Map words(String text) throws Exception {
        if (text == null || text.isEmpty())
            throw new Exception("Text is empty");

        Map<String, Integer> map = new HashMap<>();
        String[] words = text.trim().split(" ");

        for (String word : words) {
            if (validateWord(word)) {
                map.put(word, numberOfRepetitions(words, word));
            }
        }

        return map;
    }

    private static boolean validateWord(String word) {
        if (word.length() < 2)
            return false;

        for (char ch : word.toCharArray()) {
            if (!Character.isLetter(ch)) {
                return false;
            }
        }

        return true;
    }

    private static <T> int numberOfRepetitions(T[] array, T t) {
        int count = 0;

        for (T obj : array) {
            if (t.equals(obj)) {
                count++;
            }
        }

        return count;
    }
}
