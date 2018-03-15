package lesson15.homework.api;

import java.util.Date;

public class GoogleAPI implements API {

    private Room[] rooms;

    public GoogleAPI(Room[] rooms) {
        this.rooms = rooms;
    }

    @Override
    public Room[] findRooms(int price, int persons, String city, String hotel) {

        Room searchedRoom = new Room(-1, price, persons, new Date(), city, hotel);

        if (rooms == null)
            return null;
        int count = 0;
        for (Room room : rooms) {
            if (room != null && room.equals(searchedRoom)) {
                count++;
            }
        }

        Room[] requiredRooms = new Room[count];
        int index = 0;
        for (Room room : rooms) {
            if (room != null && room.equals(searchedRoom)) {
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
