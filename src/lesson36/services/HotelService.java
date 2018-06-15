package lesson36.services;

import lesson36.exceptions.BadRequestException;
import lesson36.exceptions.ObjectNotFoundException;
import lesson36.models.Hotel;
import lesson36.repositories.HotelRepository;

public class HotelService {
    private HotelRepository hotelRepository = new HotelRepository();

    public void addHotel(Hotel hotel) throws Exception {
        validate(hotel);

        hotelRepository.create(hotel);
    }

    public void deleteHotel(long hotelId) throws Exception {
        hotelRepository.remove(hotelRepository.findById(hotelId));
    }

    public Hotel findHotelByCity(String city) throws Exception {
        for (Hotel hotel : hotelRepository.getAll()) {
            if (hotel.getCity().equals(city)) {
                return hotel;
            }
        }

        throw new ObjectNotFoundException("Any hotel was not found in " + city);
    }

    public Hotel findHotelByName(String name) throws Exception {
        for (Hotel hotel : hotelRepository.getAll()) {
            if (hotel.getName().equals(name))
                return hotel;
        }

        throw new ObjectNotFoundException("Hotel with name " + name + " was not found");
    }

    private void validate(Hotel hotel) throws BadRequestException {
        if(hotel.getName() == null)
            throw new BadRequestException("Wrong enter hotel name");

        if(hotel.getCountry() == null)
            throw new BadRequestException("Wrong enter hotel country");

        if(hotel.getCity() == null)
            throw new BadRequestException("Wrong enter hotel city");

        if(hotel.getStreet() == null)
            throw new BadRequestException("Wrong enter hotel street");
    }
}
