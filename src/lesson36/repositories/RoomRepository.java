package lesson36.repositories;

import lesson36.exceptions.MappingException;
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
    public boolean isObjectExist(Room room) throws MappingException {
        return super.isObjectExist(room);
    }

    @Override
    public ArrayList<Room> getAll() throws MappingException {
        return super.getAll();
    }

    @Override
    public Room findById(long id) throws MappingException {
        return super.findById(id);
    }

    @Override
    public Room find(Room room) throws MappingException {
        return super.find(room);
    }

    @Override
    public void remove(Room room) throws Exception {
        super.remove(room);
    }

    @Override
    public Room map(String obj, int count) throws MappingException {
        String[] fields = obj.split("([,][ ])");

        if (fields.length != 7)
            throw new MappingException("Room's information is not full in line " + count);

        for (String field : fields) {
            if (field == null || field.isEmpty())
                throw new MappingException("Room's information has empty property in line " + count);
        }

        long id = Long.parseLong(fields[0]);
        int numberOfGuests = Integer.parseInt(fields[1]);
        double price = Double.parseDouble(fields[2]);
        boolean breakfastIncluded = Boolean.parseBoolean(fields[3]);
        boolean petsAllowed = Boolean.parseBoolean(fields[4]);

        Date dateAvailableFrom;
        try {
            dateAvailableFrom = dateFormat.parse(fields[5]);
        } catch (Exception e) {
            throw new MappingException("Room " + id + " has injured data in field date in line " + count);
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
