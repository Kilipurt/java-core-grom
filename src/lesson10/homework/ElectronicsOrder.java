package lesson10.homework;

import java.util.Date;

public class ElectronicsOrder extends Order {
    private int guaranteeMonths;

    public ElectronicsOrder(String itemName, Date dateCreated, String shipFromCity, String shipToCity, int basePrice, Customer customerOwned, int guaranteeMonths) {
        super(itemName, dateCreated, shipFromCity, shipToCity, basePrice, customerOwned);
        this.guaranteeMonths = guaranteeMonths;
    }

    @Override
    public void validateOrder() {
        if (cityVerification(getShipFromCity()) && cityVerification(getShipToCity()) && getBasePrice() >= 100 && getCustomerOwned().getGender() == "Женский")
            setDateConfirmed(new Date());
    }

    private boolean cityVerification(String city) {
        String[] cities = {"Киев", "Одесса", "Днепр", "Харьков"};
        for (String c : cities) {
            if (city == c)
                return true;
        }
        return false;
    }

    @Override
    public void calculatePrice() {
        if (getShipToCity() != "Киев" && getShipToCity() != "Одесса")
            setTotalPrice(getBasePrice() + getBasePrice() * 0.15);
        else
            setTotalPrice(getBasePrice() + getBasePrice() * 0.1);
        if (getBasePrice() > 1000)
            setTotalPrice(getTotalPrice() - getTotalPrice() * 0.05);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
