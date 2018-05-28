package lesson36.repositories;

import lesson36.exceptions.MappingException;
import lesson36.models.Order;
import lesson36.models.Room;
import lesson36.models.User;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class OrderRepository extends GenericRepository<Order> {

    private SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
    private UserRepository userRepository = new UserRepository();
    private RoomRepository roomRepository = new RoomRepository();

    public OrderRepository() {
        setPath("D:\\JavaProjects\\OrderDb.txt");
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
    public boolean isObjectExist(Order order) throws MappingException {
        return super.isObjectExist(order);
    }

    @Override
    public ArrayList<Order> getAll() throws MappingException {
        return super.getAll();
    }

    @Override
    public Order findById(long id) throws MappingException {
        return super.findById(id);
    }

    @Override
    public Order find(Order order) throws MappingException {
        return super.find(order);
    }

    @Override
    public void remove(Order order) throws Exception {
        super.remove(order);
    }

    @Override
    public Order map(String obj, int count) throws MappingException {
        String[] fields = obj.split("([,][ ])");

        if (fields.length != 6)
            throw new MappingException("Order's information is not full in line " + count);

        for (String field : fields) {
            if (field == null || field.isEmpty())
                throw new MappingException("Order's information has empty property in line " + count);
        }

        long id = Long.parseLong(fields[0]);
        User user = userRepository.findById(Long.parseLong(fields[1]));
        Room room = roomRepository.findById(Long.parseLong(fields[2]));

        Date dateFrom;
        try {
            dateFrom = dateFormat.parse(fields[3]);
        } catch (ParseException e) {
            throw new MappingException("Order " + id + " has injured data in field dateFrom in line " + count + ". " + e.getMessage());
        }

        Date dateTo;
        try {
            dateTo = dateFormat.parse(fields[4]);
        } catch (ParseException e) {
            throw new MappingException("Order " + id + " has injured data in field dateTO in line " + count + ". " + e.getMessage());
        }

        double moneyPaid = Double.parseDouble(fields[5]);

        return new Order(id, user, room, dateFrom, dateTo, moneyPaid);
    }

    @Override
    public String reverseMap(Order obj) {
        return obj.getId() + ", "
                + obj.getUser().getId() + ", "
                + obj.getRoom().getId() + ", "
                + dateFormat.format(obj.getDateFrom()) + ", "
                + dateFormat.format(obj.getDateTo()) + ", "
                + obj.getMoneyPaid();
    }
}
