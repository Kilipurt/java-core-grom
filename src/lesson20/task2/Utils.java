package lesson20.task2;

public class Utils {
    private int limitTransactionsPerDayCount = 10;
    private int getLimitTransactionsPerDayAmount = 100;
    private int limitSimpleTransactionsAmount = 40;
    private String[] cities = {"Kiev", "Odessa"};

    public int getLimitTransactionsPerDayCount() {
        return limitTransactionsPerDayCount;
    }

    public int getGetLimitTransactionsPerDayAmount() {
        return getLimitTransactionsPerDayAmount;
    }

    public int getLimitSimpleTransactionsAmount() {
        return limitSimpleTransactionsAmount;
    }

    public String[] getCities() {
        return cities;
    }
}
