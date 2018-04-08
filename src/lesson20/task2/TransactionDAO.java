package lesson20.task2;

import lesson20.task2.exception.BadRequestException;
import lesson20.task2.exception.InternalServerException;
import lesson20.task2.exception.LimitExceeded;

import java.util.Calendar;
import java.util.Date;

public class TransactionDAO {
    private Transaction[] transactions = new Transaction[10];
    private Utils utils = new Utils();

    public Transaction save(Transaction transaction) throws Exception {
        checkTransactionForLimits(transaction);
        transactionValidate(transaction);

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

    private void checkTransactionForLimits(Transaction transaction) throws Exception {
        if (transaction.getAmount() > utils.getLimitSimpleTransactionsAmount() || transaction.getAmount() <= 0)
            throw new LimitExceeded("Transaction limit exceed " + transaction.getId() + ". Can't be saved");

        int sum = 0;
        int count = 0;
        for (Transaction tr : getTransactionsPerDay(transaction.getDateCreated())) {
            sum += tr.getAmount();
            count++;
        }

        if (sum + transaction.getAmount() > utils.getGetLimitTransactionsPerDayAmount())
            throw new LimitExceeded("Transaction limit per day amount exceed " + transaction.getId() + ". Can't be saved");

        if (count >= utils.getLimitTransactionsPerDayCount())
            throw new LimitExceeded("Transaction limit per day count exceed " + transaction.getId() + ". Can't be saved");

        for (Transaction tr : transactions) {
            if (tr == null)
                return;
        }

        throw new InternalServerException("Don't enough space for saving transaction " + transaction.getId());
    }

    private void transactionValidate(Transaction transaction) throws BadRequestException{
        if (transaction == null)
            throw new BadRequestException("Can't be saved empty transaction");

        String city = null;
        for (String c : utils.getCities()) {
            if (c.equals(transaction.getCity()))
                city = c;
        }

        if (city == null)
            throw new BadRequestException("Transaction " + transaction.getId() + " is carried out in an unauthorized city. Can't be saved");

        for(Transaction tr : transactions){
            if(tr != null && transaction.equals(tr))
                throw new BadRequestException("Transaction " + transaction.getId() + " already saved");
        }
    }

    Transaction[] transactionList() {
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

    Transaction[] transactionList(String city) throws BadRequestException {
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

    Transaction[] transactionList(int amount) throws BadRequestException {
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

    private Transaction[] getTransactionsPerDay(Date dateOfCurTransaction) {
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
