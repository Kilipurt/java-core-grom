package lesson36.repositories;

import lesson36.models.Order;
import lesson36.models.Room;
import lesson36.models.User;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/*public class OrderRepository extends GenericRepository<Order> {
    private UserRepository userRepository = new UserRepository();
    private RoomRepository roomRepository = new RoomRepository();
    private SimpleDateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy");

    public OrderRepository() {
        super.setPath("");
    }

    @Override
    public void setPath(String path) {
        super.setPath(path);
    }

    @Override
    public Order create(Order order) throws Exception {
        return super.create(order);
    }

    @Override
    public ArrayList<Order> getAll() throws Exception {
        return super.getAll();
    }

    @Override
    public Order findById(long id) throws Exception {
        return super.findById(id);
    }

    @Override
    public void remove(Order order) throws Exception {
        super.remove(order);
    }

    @Override
    public Order map(String obj, int count) throws Exception {
        /*String[] fields = obj.split(", ");

        if (fields.length != 6)
            throw new Exception("Order's information is not full in line " + count);

        for (String field : fields) {
            if (field == null || field.isEmpty())
                throw new Exception("Order's information has empty property in line " + count);
        }

        long id = Long.parseLong(fields[0]);
        User user = userRepository.findById(Long.parseLong(fields[1]));
        Room room = roomRepository.findById(Long.parseLong(fields[2]));
        Date dateFrom = dateFormat.parse(fields[3]);
        Date dateTo = dateFormat.parse(fields[4]);
        double moneyPaid = Double.parseDouble(fields[5]);

        return new Order(id, user, room, dateFrom, dateTo, moneyPaid);
        return null;
    }

    @Override
    public ArrayList<Order> mapAll(StringBuffer all) throws Exception {
        return super.mapAll(all);
    }

    @Override
    public String reverseMap(Order obj) {
        return obj.getId() + ", "
                + obj.getUser().getId() + ", "
                + obj.getRoom().getId() + ", "
                + dateFormat.format(obj.getDateFrom()) + ", "
                + dateFormat.format(obj.getDateTo()) + ", "
                +obj.getMoneyPaid();
    }
}*/
