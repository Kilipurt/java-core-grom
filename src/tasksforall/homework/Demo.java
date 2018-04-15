package tasksforall.homework;

import java.util.Arrays;

public class Demo {
    public static void main(String[] args) {
        GeneralDAO<String> generalDAO = new GeneralDAO<>();

        try {
            System.out.println(generalDAO.save("rtr"));
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        try {
            System.out.println(Arrays.toString(generalDAO.getAll()));
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        GeneralDAO<Long> generalDAO1 = new GeneralDAO<>();

        try {
            System.out.println(generalDAO1.save(2L));
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        try {
            System.out.println(Arrays.toString(generalDAO1.getAll()));
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        GeneralDAO<Boolean> generalDAO2 = new GeneralDAO<>();

        try {
            System.out.println(generalDAO2.save(true));
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        try {
            System.out.println(Arrays.toString(generalDAO2.getAll()));
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

    }
}
