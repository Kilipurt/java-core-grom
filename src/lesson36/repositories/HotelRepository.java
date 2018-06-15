package lesson36.repositories;

import lesson36.models.Hotel;

import java.util.ArrayList;

public class HotelRepository extends GenericRepository<Hotel> {

    public HotelRepository() {
        setPath("D:\\JavaProjects\\HotelDb.txt");
    }

    @Override
    public void setPath(String path) {
        super.setPath(path);
    }

    @Override
    public Hotel create(Hotel hotel) throws Exception {
        return super.create(hotel);
    }

    @Override
    public boolean isObjectExist(Hotel hotel) {
        return super.isObjectExist(hotel);
    }

    @Override
    public ArrayList<Hotel> getAll() {
        return super.getAll();
    }

    @Override
    public Hotel findById(long id) {
        return super.findById(id);
    }

    @Override
    public Hotel find(Hotel hotel) {
        return super.find(hotel);
    }

    @Override
    public void remove(Hotel hotel) throws Exception {
        super.remove(hotel);
    }

    @Override
    public Hotel map(String obj) {
        String[] fields = obj.split("([,][ ])");

        return new Hotel(Long.parseLong(fields[0]), fields[1], fields[2], fields[3], fields[4]);
    }

    @Override
    public String reverseMap(Hotel obj) {
        return obj.getId() + ", "
                + obj.getName() + ", "
                + obj.getCountry() + ", "
                + obj.getCity() + ", "
                + obj.getStreet();
    }
}
