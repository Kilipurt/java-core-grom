package gromcodemain.lesson30.homework;

import java.util.Date;

public class FirmDAO {
    private Firm firm;

    public FirmDAO() {
        firm = new Firm(new Date());
    }

    public Firm getFirm() {
        return firm;
    }
}
