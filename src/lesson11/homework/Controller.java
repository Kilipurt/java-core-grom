package lesson11.homework;

public class Controller {
    private API[] apis;

    public Controller(API[] apis) {
        this.apis = apis;
    }

    public Room[] requestRooms(int price, int persons, String city, String hotel) {
        int count = 0;
        for (API api : apis) {
            count += api.findRooms(price, persons, city, hotel).length;
        }

        Room[] rooms = new Room[count];

        int index = 0;
        for (API api : apis) {
            for (Room room : api.findRooms(price, persons, city, hotel)) {
                rooms[index] = room;
                index++;
            }
        }
        return rooms;
    }

    public Room[] check(API api1, API api2) {
        int count = 0;
        for (Room room : api1.getAll()) {
            for (Room room1 : api2.getAll()) {
                if (room.getPersons() == room1.getPersons() && room.getPrice() == room1.getPrice() && room.getHotelName() == room1.getHotelName() && room.getCityName() == room1.getCityName()) {
                    count++;
                }
            }
        }

        Room[] result = new Room[count];

        int index = 0;
        for (Room room : api1.getAll()) {
            for (Room room1 : api2.getAll()) {
                if (room.getPersons() == room1.getPersons() && room.getPrice() == room1.getPrice() && room.getHotelName() == room1.getHotelName() && room.getCityName() == room1.getCityName()) {
                    result[index] = room;
                    index++;
                }
            }
        }

        return result;
    }
}
