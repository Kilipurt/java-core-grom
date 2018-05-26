package gromcodemain.lesson11.homework;

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
            if (room != null && room.getPersons() == persons && room.getCityName() == city
                    && room.getHotelName() == hotel && room.getPrice() == price) {
                count++;
            }
        }
        Room[] requiredRooms = new Room[count];
        int index = 0;
        for (Room room : rooms) {
            if (room != null && room.getPersons() == persons && room.getCityName() == city
                    && room.getHotelName() == hotel && room.getPrice() == price) {
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
