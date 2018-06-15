package lesson36.services;

import lesson36.exceptions.BadRequestException;
import lesson36.models.Filter;
import lesson36.models.Room;
import lesson36.repositories.RoomRepository;

import java.util.ArrayList;

public class RoomService {
    private RoomRepository roomRepository = new RoomRepository();

    public void addRoom(Room room) throws Exception {
        validate(room);

        roomRepository.create(room);
    }

    public void deleteRoom(long roomId) throws Exception {
        roomRepository.remove(roomRepository.findById(roomId));
    }

    public ArrayList<Room> findRooms(Filter filter) {
        ArrayList<Room> allRooms = roomRepository.getAll();

        ArrayList<Room> searchedRoomsByCountry = searchRoomsByCountry(filter.getCountry(), allRooms);
        ArrayList<Room> searchedRoomsByCity = searchRoomsByCity(filter.getCity(), searchedRoomsByCountry);
        ArrayList<Room> searchedRoomsByHotelName = searchRoomsByHotelName(filter.getHotelName(), searchedRoomsByCity);
        ArrayList<Room> searchedRoomsByBreakfastIncluded = searchRoomsByBreakfastIncluded(filter.isBreakfastIncluded(), searchedRoomsByHotelName);
        ArrayList<Room> searchedRoomsByPetsAllowed = searchRoomsByPetsAllowed(filter.isPetsAllowed(), searchedRoomsByBreakfastIncluded);
        ArrayList<Room> searchedRoomsByNumberOfGuests = searchRoomsByNumberOfGuests(filter.getNumberOfGuests(), searchedRoomsByPetsAllowed);
        return searchRoomsByMaxPrice(filter.getMaxPrice(), searchedRoomsByNumberOfGuests);
    }

    private ArrayList<Room> searchRoomsByCountry(String country, ArrayList<Room> rooms) {
        if (country == null || country.isEmpty())
            return rooms;

        ArrayList<Room> searchedRooms = new ArrayList<>();

        for (Room room : rooms) {
            if (room.getHotel().getCountry().equals(country)) {
                searchedRooms.add(room);
            }
        }

        return searchedRooms;
    }

    private ArrayList<Room> searchRoomsByCity(String city, ArrayList<Room> rooms) {
        if (city == null || city.isEmpty())
            return rooms;

        ArrayList<Room> searchedRooms = new ArrayList<>();

        for (Room room : rooms) {
            if (room.getHotel().getCity().equals(city)) {
                searchedRooms.add(room);
            }
        }

        return searchedRooms;
    }

    private ArrayList<Room> searchRoomsByHotelName(String hotelName, ArrayList<Room> rooms) {
        if (hotelName == null || hotelName.isEmpty())
            return rooms;

        ArrayList<Room> searchedRooms = new ArrayList<>();

        for (Room room : rooms) {
            if (room.getHotel().getName().equals(hotelName)) {
                searchedRooms.add(room);
            }
        }

        return searchedRooms;
    }

    private ArrayList<Room> searchRoomsByBreakfastIncluded(Boolean breakfastIncluded, ArrayList<Room> rooms) {
        if (breakfastIncluded == null)
            return rooms;

        ArrayList<Room> searchedRooms = new ArrayList<>();

        for (Room room : rooms) {
            if (room.isBreakfastIncluded() == breakfastIncluded) {
                searchedRooms.add(room);
            }
        }

        return searchedRooms;
    }

    private ArrayList<Room> searchRoomsByPetsAllowed(Boolean petsAllowed, ArrayList<Room> rooms) {
        if (petsAllowed == null)
            return rooms;

        ArrayList<Room> searchedRooms = new ArrayList<>();

        for (Room room : rooms) {
            if (room.isPetsAllowed() == petsAllowed) {
                searchedRooms.add(room);
            }
        }

        return searchedRooms;
    }

    private ArrayList<Room> searchRoomsByNumberOfGuests(Integer numberOfGuests, ArrayList<Room> rooms) {
        if (numberOfGuests == null)
            return rooms;

        ArrayList<Room> searchedRooms = new ArrayList<>();

        for (Room room : rooms) {
            if (room.getNumberOfGuests() == numberOfGuests) {
                searchedRooms.add(room);
            }
        }

        return searchedRooms;
    }

    private ArrayList<Room> searchRoomsByMaxPrice(Double maxPrice, ArrayList<Room> rooms) {
        if (maxPrice == null)
            return rooms;

        ArrayList<Room> searchedRooms = new ArrayList<>();

        for (Room room : rooms) {
            if (room.getPrice() <= maxPrice) {
                searchedRooms.add(room);
            }
        }

        return searchedRooms;
    }

    private void validate(Room room) throws BadRequestException {
        if(room.getNumberOfGuests() <= 0)
            throw new BadRequestException("Wrong enter number of guests");

        if(room.getPrice() <= 0)
            throw new BadRequestException("Wrong enter price");

        if(room.getDateAvailableFrom() == null)
            throw new BadRequestException("Wrong enter start date of available");

        if(room.getHotel() == null)
            throw new BadRequestException("Wrong enter hotel");
    }
}
