package lesson17.homework;

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
            if(checkForSpecialCharacters(words[i])) {
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

    public boolean validate(String address) {
        if (!stringVerification(address))
            return false;

        String[] firstValidatePart = address.split("://");
        if (firstValidatePart.length != 2 && !firstValidatePart[0].equals("http") || firstValidatePart.length != 2 && !firstValidatePart[0].equals("https"))
            return false;

        String[] domenValidate = firstValidatePart[1].split("\\.");

        if ((domenValidate[0].equals("www") && domenValidate.length != 3)
                ||(!domenValidate[0].equals("www") && domenValidate.length != 2))
            return false;

        if ((domenValidate.length == 2 && !domenValidate[1].equals("com") && !domenValidate[1].equals("org") && !domenValidate[1].equals("net"))
                || (domenValidate.length == 3 && (!domenValidate[2].equals("com") && !domenValidate[2].equals("org") && !domenValidate[2].equals("net"))))
            return false;

        if ((domenValidate.length == 2 && !checkForSpecialCharactersAddress(domenValidate[0]))
                || (domenValidate.length == 3 && !checkForSpecialCharactersAddress(domenValidate[1])))
            return false;

        return true;
    }

    public boolean checkForSpecialCharactersAddress(String input) {
        if (!stringVerification(input))
            return false;

        for (char ch : input.toCharArray()) {
            if (!Character.isLetterOrDigit(ch)) {
                return false;
            }
        }
        return true;
    }
}
