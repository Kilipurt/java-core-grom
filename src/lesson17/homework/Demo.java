package lesson17.homework;

public class Demo {
    public static void main(String[] args) {
        String test = "rerg.reghjgiuyiuk 1 2321 gr4 erwg wwerggw wwerggj rerg.reghjgiuyiuk    ";
        Solution solution = new Solution();
        System.out.println(solution.countWords(test));

        System.out.println(solution.maxWord(test));
        System.out.println(solution.minWord(test));
    }
}
