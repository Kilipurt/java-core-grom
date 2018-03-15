package lesson15.homework.api;

public class GoogleAPI implements API {

    private Room[] rooms;

    public GoogleAPI(Room[] rooms) {
        this.rooms = rooms;
    }

    @Override
    public Room[] findRooms(int price, int persons, String city, String hotel) {

        if (rooms == null)
            return null;
        int count = 0;
        for (Room room : rooms) {
            if (room != null && room.getPrice() == price && room.getPersons() == persons && room.getCityName().equals(city) && room.getHotelName().equals(hotel)) {
                count++;
            }
        }

        Room[] requiredRooms = new Room[count];
        int index = 0;
        for (Room room : rooms) {
            if (room != null && room.getPrice() == price && room.getPersons() == persons && room.getCityName().equals(city) && room.getHotelName().equals(hotel)) {
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
