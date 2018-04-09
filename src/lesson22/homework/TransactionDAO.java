package lesson22.homework;

import lesson22.homework.exception.BadRequestException;
import lesson22.homework.exception.InternalServerException;
import lesson22.homework.exception.LimitExceeded;

import java.util.Calendar;
import java.util.Date;

public class TransactionDAO {
    private static Transaction[] transactions = new Transaction[10];

    public static Transaction save(Transaction transaction) throws Exception {
        transactionVerification(transaction);

        int index = 0;
        for (Transaction tr : transactions) {
            if (tr == null) {
                transactions[index] = transaction;
                break;
            }
            index++;
        }

        return transactions[index];
    }

    private static void transactionVerification(Transaction transaction) throws Exception {
        if (transaction == null)
            throw new BadRequestException("Can't be saved empty transaction");

        for (Transaction tr : transactions) {
            if (tr != null && transaction.equals(tr))
                throw new BadRequestException("Transaction " + transaction.getId() + " already saved");
        }

        String city = null;
        for (String c : Utils.getCities()) {
            if (c.equals(transaction.getCity()))
                city = c;
        }

        if (city == null)
            throw new BadRequestException("Transaction " + transaction.getId() + " is carried out in an unauthorized city. Can't be saved");

        checkTransactionForLimits(transaction);

        for (Transaction tr : transactions) {
            if (tr == null)
                return;
        }

        throw new InternalServerException("Don't enough space for saving transaction " + transaction.getId());
    }

    private static void checkTransactionForLimits(Transaction transaction) throws LimitExceeded {
        if (transaction.getAmount() > Utils.getLimitSimpleTransactionAmount() || transaction.getAmount() <= 0)
            throw new LimitExceeded("Transaction's amount limit exceed " + transaction.getId() + ". Can't be saved");

        int sumOfTransactionsPerDay = 0;
        int countOfTransactionPerDay = 0;

        for (Transaction tr : getTransactionsPerDay(transaction.getDateCreated())) {
            sumOfTransactionsPerDay += tr.getAmount();
            countOfTransactionPerDay++;
        }

        if (sumOfTransactionsPerDay + transaction.getAmount() > Utils.getLimitTransactionsPerDayAmount())
            throw new LimitExceeded("Transaction limit per day amount exceed " + transaction.getId() + ". Can't be saved");

        if (countOfTransactionPerDay >= Utils.getLimitTransactionsPerDayCount())
            throw new LimitExceeded("Transaction limit per day count exceed " + transaction.getId() + ". Can't be saved");
    }

    public static Transaction[] transactionList() {
        int count = 0;
        for (Transaction tr : transactions) {
            if (tr != null)
                count++;
        }

        Transaction[] result = new Transaction[count];

        int index = 0;
        for (Transaction tr : transactions) {
            if (tr != null) {
                result[index] = tr;
                index++;
            }
        }

        return result;
    }

    public static Transaction[] transactionList(String city) throws BadRequestException {
        if (city == null)
            throw new BadRequestException("Wrong enter city");

        int count = 0;
        for (Transaction tr : transactions) {
            if (tr != null && city.equals(tr.getCity()))
                count++;
        }

        Transaction[] result = new Transaction[count];

        int index = 0;
        for (Transaction tr : transactions) {
            if (tr != null && city.equals(tr.getCity())) {
                result[index] = tr;
                index++;
            }
        }

        return result;
    }

    public static Transaction[] transactionList(int amount) throws BadRequestException {
        if (amount == 0)
            throw new BadRequestException("Wrong enter amount");

        int count = 0;
        for (Transaction tr : transactions) {
            if (tr != null && tr.getAmount() == amount)
                count++;
        }

        Transaction[] result = new Transaction[count];

        int index = 0;
        for (Transaction tr : transactions) {
            if (tr != null && tr.getAmount() == amount) {
                result[index] = tr;
                index++;
            }
        }

        return result;
    }

    private static Transaction[] getTransactionsPerDay(Date dateOfCurTransaction) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dateOfCurTransaction);

        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        int count = 0;
        for (Transaction transaction : transactions) {
            if (transaction != null) {
                calendar.setTime(transaction.getDateCreated());
                int trMonth = calendar.get(Calendar.MONTH);
                int trDay = calendar.get(Calendar.DAY_OF_MONTH);

                if (trMonth == month && trDay == day)
                    count++;
            }
        }

        Transaction[] result = new Transaction[count];
        int index = 0;
        for (Transaction transaction : transactions) {
            if (transaction != null) {
                calendar.setTime(transaction.getDateCreated());
                int trMonth = calendar.get(Calendar.MONTH);
                int trDay = calendar.get(Calendar.DAY_OF_MONTH);

                if (trMonth == month && trDay == day) {
                    result[index] = transaction;
                    index++;
                }
            }
        }

        return result;
    }
}
