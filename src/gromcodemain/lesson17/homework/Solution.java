package gromcodemain.lesson17.homework;

public class Solution {

    public boolean stringVerification(String input) {
        return input != null && !input.isEmpty();
    }

    public boolean checkForSpecialCharacters(String input) {
        if (!stringVerification(input))
            return false;

        for (char ch : input.toCharArray()) {
            if (!Character.isLetter(ch)) {
                return false;
            }
        }
        return true;
    }

    public int countWords(String input) {

        if (!stringVerification(input))
            return 0;

        String[] words = input.trim().split(" ");

        int count = 0;
        for (String word : words) {
            if (checkForSpecialCharacters(word))
                count++;
        }
        return count;
    }

    public String maxWord(String input) {
        if (!stringVerification(input))
            return null;

        String[] words = input.split(" ");

        String maxWord = null;
        int maxWordLength = 0;
        for (String word : words) {
            if (checkForSpecialCharacters(word) && word.length() > maxWordLength) {
                maxWord = word;
                maxWordLength = maxWord.length();
            }
        }

        return maxWord;
    }

    public String minWord(String input) {
        if (!stringVerification(input))
            return null;

        String[] words = input.split(" ");

        String minWord = null;

        for (String word : words) {
            if (checkForSpecialCharacters(word))
                minWord = word;
        }

        if (minWord == null)
            return null;

        for (String word : words) {
            if (checkForSpecialCharacters(word) && word.length() < minWord.length())
                minWord = word;
        }

        return minWord;
    }

    public String mostCountedWord(String input) {
        if (!stringVerification(input))
            return null;

        String[] words = input.trim().split(" ");

        int[] countOfDuplicatesOfWord = new int[words.length];

        for (int i = 0; i < words.length; i++) {
            if (checkForSpecialCharacters(words[i])) {
                countOfDuplicatesOfWord[i]++;
                for (int j = i + 1; j < words.length; j++) {
                    if (words[i].equals(words[j]))
                        countOfDuplicatesOfWord[i]++;
                }
            }
        }

        int max = countOfDuplicatesOfWord[0];
        int maxIndex = 0;
        for (int i = 0; i < countOfDuplicatesOfWord.length; i++) {
            if (countOfDuplicatesOfWord[i] > max) {
                max = countOfDuplicatesOfWord[i];
                maxIndex = i;
            }
        }

        return max == 0 ? null : words[maxIndex];
    }

    public boolean validate(String address){
        if (address == null || address.isEmpty())
            return false;

        if (!address.startsWith("http://") && !address.startsWith("https://"))
            return false;

        if (!address.endsWith(".com") && !address.endsWith(".net") && !address.endsWith(".org"))
            return false;

        address = isValid(address, new String[]{"http://", "https://"});
        address = isValid(address, new String[]{".net", ".com", ".org"});

        return address != null && checkForSpecialCharactersAddress(address);
    }

    private String isValid(String address, String[] parts){
        for(String part : parts){
            if(address.contains(part)){
                address = address.replace(part, "");
                return address;
            }
        }
        return null;
    }

    public boolean checkForSpecialCharactersAddress(String input) {
        if (input == null || input.isEmpty())
            return false;

        for (char ch : input.toCharArray()) {
            if (!Character.isLetterOrDigit(ch)) {
                return false;
            }
        }
        return true;
    }
}
