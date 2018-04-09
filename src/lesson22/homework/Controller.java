package lesson22.homework;

import lesson20.task2.exception.BadRequestException;

public class Controller {

    public static Transaction save(Transaction transaction) throws Exception {
        return TransactionDAO.save(transaction);
    }

    public static Transaction[] transactionList() {
        return TransactionDAO.transactionList();
    }

    public static Transaction[] transactionList(String city) throws BadRequestException {
        return TransactionDAO.transactionList(city);
    }

    public static Transaction[] transactionList(int amount) throws BadRequestException {
        return TransactionDAO.transactionList(amount);
    }
}
