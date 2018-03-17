package lesson17.homework;

public class Solution {

    public boolean stringVerification(String input){
        return input == null || input.isEmpty() ? false : true;
    }

    public boolean checkForSpecialCharacters(String input){
        if(!stringVerification(input))
            return false;

        for (char ch : input.toCharArray()) {
            if (!Character.isLetter(ch)) {
                return false;
            }
        }
        return true;
    }

    public int countWords(String input) {

        if(!stringVerification(input))
            return 0;

        String[] words = input.trim().split(" ");

        int count = 0;
        for (String word : words) {
            if(checkForSpecialCharacters(word))
                count++;
        }
        return count;
    }

    public String maxWord(String input) {
        if(!stringVerification(input))
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
        if(!stringVerification(input))
            return null;

        String[] words = input.split(" ");

        String minWord = null;

        for (String word : words) {
            if (checkForSpecialCharacters(word))
                minWord = word;
        }

        if(minWord == null)
            return null;

        for (String word : words) {
            if (checkForSpecialCharacters(word) && word.length() < minWord.length())
                minWord = word;
        }

        return minWord;
    }

    public String mostCountedWords(String input) {
        if(!stringVerification(input))
            return null;

        String[] words = input.split(" ");
        int[] countOfDuplicatesOfWord = new int[words.length];

        for (String word : words) {
            for (int i = 0; i < words.length; i++) {
                if (checkForSpecialCharacters(word) && word.equals(words[i]))
                    countOfDuplicatesOfWord[i]++;
            }
        }

        int indexOfMostCountedWord = 0;
        for (int i = 0; i < words.length; i++) {
            if (countOfDuplicatesOfWord[i + 1] > countOfDuplicatesOfWord[i])
                indexOfMostCountedWord = i + 1;
        }
        return words[indexOfMostCountedWord];
    }

    public boolean validate(String address) {
        if (!stringVerification(address))
            return false;

        String[] firstValidatePart = address.split("://");
        if (firstValidatePart.length > 2)
            return false;

        if (!firstValidatePart[0].equals("http") && !firstValidatePart[0].equals("https"))
            return false;

        String[] domenValidate = firstValidatePart[1].split(".");
        if (domenValidate.length > 2)
            return false;

        if (!domenValidate[1].equals("com") && !domenValidate[1].equals("org") && !domenValidate[1].equals("net"))
            return false;

        if(!checkForSpecialCharacters(domenValidate[0]))
            return false;

        return true;
    }
}
