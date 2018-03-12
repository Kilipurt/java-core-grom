package lesson11.homework;

public class TripAdvisorAPI implements API {

    private Room[] rooms;

    public TripAdvisorAPI(Room[] rooms) {
        this.rooms = rooms;
    }

    @Override
    public Room[] findRooms(int price, int persons, String city, String hotel) {
        if (rooms == null)
            return null;
        int count = 0;
        for (Room room : rooms) {
            if (room != null && room.getPrice() == price && room.getCityName() == city
                    && room.getHotelName() == hotel && room.getPersons() <= persons + 1 && room.getPersons() >= persons - 1) {
                count++;
            }
        }
        Room[] requiredRooms = new Room[count];
        int index = 0;
        for (Room room : rooms) {
            if (room != null && room.getPrice() == price && room.getCityName() == city
                    && room.getHotelName() == hotel && room.getPersons() <= persons + 1 && room.getPersons() >= persons - 1) {
                requiredRooms[index] = room;
                index++;
            }
        }
        return requiredRooms;
    }

    @Override
    public Room[] getAll() {
        return rooms;
    }
}
