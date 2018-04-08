package lesson20.task2;

import java.util.Arrays;
import java.util.Date;

public class Demo {

    public static void main(String[] args) {

        Transaction t1 = new Transaction(1, "Kiev", 35, "withdraw", TransactionType.OUTCOME, new Date());
        Controller controller = new Controller();

        try {
            controller.save(t1);
        }catch(Exception e){
            System.err.println(e.getMessage());
        }

        try {
            System.out.println(Arrays.toString(controller.transactionList()));
        }catch(Exception e){
            System.err.println(e.getMessage());
        }

        try {
            System.out.println(Arrays.toString(controller.transactionList(50)));
        }catch(Exception e){
            System.err.println(e.getMessage());
        }

        try {
            System.out.println(Arrays.toString(controller.transactionList("Kiev")));
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
    }
}
