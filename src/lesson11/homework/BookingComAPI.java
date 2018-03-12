package lesson11.homework;

public class BookingComAPI implements API {

    private Room[] rooms;

    public BookingComAPI(Room[] rooms) {
        this.rooms = rooms;
    }

    @Override
    public Room[] findRooms(int price, int persons, String city, String hotel) {
        if (rooms == null)
            return null;
        int count = 0;
        for (Room room : rooms) {
            if (room != null && room.getPersons() == persons && room.getCityName() == city
                    && room.getHotelName() == hotel && room.getPrice() <= price + 100 && room.getPrice() >= price - 100)
                count++;
        }

        Room[] requiredRooms = new Room[count];
        int index = 0;
        for (Room room : rooms) {
            if (room != null && room.getPersons() == persons && room.getCityName() == city
                    && room.getHotelName() == hotel && room.getPrice() <= price + 100 && room.getPrice() >= price - 100) {
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
