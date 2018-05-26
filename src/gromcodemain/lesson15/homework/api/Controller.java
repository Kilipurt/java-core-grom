package gromcodemain.lesson15.homework.api;

public class Controller {
    private API[] apis;

    public Controller(API[] apis) {
        this.apis = apis;
    }

    public Room[] requestRooms(int price, int persons, String city, String hotel) {
        if (apis == null)
            return null;
        int count = 0;
        for (API api : apis) {
            if (api != null)
                count += api.findRooms(price, persons, city, hotel).length;
        }

        Room[] rooms = new Room[count];

        int index = 0;
        for (API api : apis) {
            if (api != null) {
                for (Room room : api.findRooms(price, persons, city, hotel)) {
                    rooms[index] = room;
                    index++;
                }
            }
        }
        return rooms;
    }

    public Room[] check(API api1, API api2) {
        if (api1 == null || api2 == null)
            return null;
        int count = 0;
        for (Room room : api1.getAll()) {
            if (room != null) {
                for (Room room1 : api2.getAll()) {
                    if (room.equals(room1)) {
                        count++;
                    }
                }
            }
        }

        Room[] result = new Room[count];

        int index = 0;
        for (Room room : api1.getAll()) {
            if (room != null) {
                for (Room room1 : api2.getAll()) {
                    if (room.equals(room1)) {
                        result[index] = room;
                        index++;
                    }
                }
            }
        }

        return result;
    }
}
