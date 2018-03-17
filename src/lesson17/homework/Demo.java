package lesson17.homework;

public class Demo {
    public static void main(String[] args) {
        String test = "erwg wwerggw rerg.reghjgiuyiuk 1 wwerggw 2321 wwerggw gr4 erwg wwerggw wwerggj   erwg   rerg.reghjgiuyiuk  wwerggw  ";
        String address = "";
        String address1 = "https://ergkerg.org";
        String address2 = "http://www.ergkerg.net";
        String address3 = "http://ergke5rg.com";
        String address4 = "https://ergk/erg.org";
        String address5 = "http://www.erg<kerg.com";
        Solution solution = new Solution();
        System.out.println(solution.countWords(test));

        System.out.println(solution.maxWord(test));
        System.out.println(solution.minWord(test));
        System.out.println(solution.mostCountedWords(test));

        System.out.println(solution.validate(address));
        System.out.println(solution.validate(address1));
        System.out.println(solution.validate(address2));
        System.out.println(solution.validate(address3));
        System.out.println(solution.validate(address4));
        System.out.println(solution.validate(address5));
    }
}
