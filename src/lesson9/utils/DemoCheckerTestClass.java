package lesson9.utils;

public class DemoCheckerTestClass {
    public static void main(String[] args) {
        //checkCompanyName(String companyName)
        //проверяет имя компании +
        //если companyNamesValidatedCount больше 10 +
        //если имя компании "Google" или "Amazon"

        Checker checker = new Checker();
        System.out.println(checker.companyNamesValidatedCount);

        System.out.println(checker.checkCompanyName("Fg"));
        System.out.println(checker.checkCompanyName("Google"));
        System.out.println(checker.checkCompanyName("Amazon"));

        checker.companyNamesValidatedCount = 100;
        System.out.println(checker.companyNamesValidatedCount);
        System.out.println(checker.checkCompanyName("Fg"));
    }
}
