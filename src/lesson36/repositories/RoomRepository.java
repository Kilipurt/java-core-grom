package lesson36.repositories;

import lesson36.models.Hotel;
import lesson36.models.Room;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class RoomRepository extends GenericRepository<Room> {

    private SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
    private HotelRepository hotelRepository = new HotelRepository();

    public RoomRepository() {
        setPath("D:\\JavaProjects\\RoomDb.txt");
    }

    @Override
    public void setPath(String path) {
        super.setPath(path);
    }

    @Override
    public Room create(Room room) throws Exception {
        return super.create(room);
    }

    @Override
    public boolean isObjectExist(Room room) {
        return super.isObjectExist(room);
    }

    @Override
    public ArrayList<Room> getAll() {
        return super.getAll();
    }

    @Override
    public Room findById(long id) {
        return super.findById(id);
    }

    @Override
    public Room find(Room room) {
        return super.find(room);
    }

    @Override
    public void remove(Room room) throws Exception {
        super.remove(room);
    }

    @Override
    public Room map(String obj) {
        String[] fields = obj.split("([,][ ])");

        long id = Long.parseLong(fields[0]);
        int numberOfGuests = Integer.parseInt(fields[1]);
        double price = Double.parseDouble(fields[2]);
        boolean breakfastIncluded = Boolean.parseBoolean(fields[3]);
        boolean petsAllowed = Boolean.parseBoolean(fields[4]);

        Date dateAvailableFrom = null;
        try {
            dateAvailableFrom = dateFormat.parse(fields[5]);
        } catch (Exception e) {
            System.err.println("Date format exception" + id);
        }

        Hotel hotel = hotelRepository.findById(Long.parseLong(fields[6]));

        return new Room(id, numberOfGuests, price, breakfastIncluded, petsAllowed, dateAvailableFrom, hotel);
    }

    @Override
    public String reverseMap(Room obj) {
        return obj.getId() + ", "
                + obj.getNumberOfGuests() + ", "
                + obj.getPrice() + ", "
                + obj.isBreakfastIncluded() + ", "
                + obj.isPetsAllowed() + ", "
                + dateFormat.format(obj.getDateAvailableFrom()) + ", "
                + obj.getHotel().getId();
    }
}
