package lesson36.repositories;

import lesson36.exceptions.MappingException;
import lesson36.models.Hotel;

import java.util.ArrayList;

public class HotelRepository extends GenericRepository<Hotel> {
    public HotelRepository() {
        super.setPath("");
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
    public ArrayList<Hotel> getAll() throws MappingException {
        return super.getAll();
    }

    @Override
    public Hotel findById(long id) throws MappingException {
        return super.findById(id);
    }

    @Override
    public void remove(Hotel hotel) throws Exception {
        super.remove(hotel);
    }

    @Override
    public Hotel map(String obj, int count) throws MappingException {
        String[] fields = obj.split(", ");

        if (fields.length != 5)
            throw new MappingException("Hotel's information is not full in line " + count);

        for (String field : fields) {
            if (field == null || field.isEmpty())
                throw new MappingException("Hotel's information has empty property in line " + count);
        }

        return new Hotel(Long.parseLong(fields[0]), fields[1], fields[2], fields[3], fields[4]);
    }

    @Override
    public ArrayList<Hotel> mapAll(StringBuffer all) throws MappingException {
        return super.mapAll(all);
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
