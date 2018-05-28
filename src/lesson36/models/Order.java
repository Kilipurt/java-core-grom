package lesson36.models;

import java.util.Date;

public class Order extends Entity {
    private long id;
    private User user;
    private Room room;
    private Date dateFrom;
    private Date dateTo;
    private double moneyPaid;

    public Order(User user, Room room, Date dateFrom, Date dateTo, double moneyPaid) {
        this.user = user;
        this.room = room;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.moneyPaid = moneyPaid;
    }

    public Order(long id, User user, Room room, Date dateFrom, Date dateTo, double moneyPaid) {
        this.id = id;
        this.user = user;
        this.room = room;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.moneyPaid = moneyPaid;
    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public void setId(long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public Room getRoom() {
        return room;
    }

    public Date getDateFrom() {
        return dateFrom;
    }

    public Date getDateTo() {
        return dateTo;
    }

    public double getMoneyPaid() {
        return moneyPaid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        if (Double.compare(order.moneyPaid, moneyPaid) != 0) return false;
        if (user != null ? !user.equals(order.user) : order.user != null) return false;
        if (room != null ? !room.equals(order.room) : order.room != null) return false;
        if (dateFrom != null ? !dateFrom.equals(order.dateFrom) : order.dateFrom != null) return false;
        return dateTo != null ? dateTo.equals(order.dateTo) : order.dateTo == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = user != null ? user.hashCode() : 0;
        result = 31 * result + (room != null ? room.hashCode() : 0);
        result = 31 * result + (dateFrom != null ? dateFrom.hashCode() : 0);
        result = 31 * result + (dateTo != null ? dateTo.hashCode() : 0);
        temp = Double.doubleToLongBits(moneyPaid);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
