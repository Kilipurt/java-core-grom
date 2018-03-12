package lesson11.homework.test;

import lesson11.homework.BookingComAPI;
import lesson11.homework.Room;

import java.util.Arrays;
import java.util.Date;

public class DemoBookingComAPITestClass {
    public static void main(String[] args) {

        Room room1 = new Room(13, 500, 4, new Date(), "Dream", "Kiev");
        Room room2 = new Room(14, 100, 2, new Date(), "Dream", "Kiev");
        Room room3 = new Room(15, 200, 2, new Date(), "Dream", "Kiev");
        Room room4 = new Room(16, 150, 3, new Date(), "Dream", "Kiev");
        Room room5 = new Room(17, 100, 2, new Date(), "Dream", "Kiev");

        Room[] rooms = {room1, room2, room3, room4, room5};

        //findRooms(int price, int persons, String city, String hotel)
        //возвращает комнаты с задаными параметрами и ценою +-100 +
        //если массив комнат равен null +
        //если среди комнат есть null +

        BookingComAPI bookingComAPI = new BookingComAPI(rooms);
        Room[] result = bookingComAPI.findRooms(100, 2, "Kiev", "Dream");
        for (Room room : result) {
            System.out.println(room.print());
        }

        BookingComAPI bookingComAPI1 = new BookingComAPI(null);
        System.out.println(Arrays.toString(bookingComAPI1.findRooms(100, 2, "Kiev", "Dream")));

        Room[] rooms1 = {room1, room2, null, room3, room4, room5, null};
        BookingComAPI bookingComAPI2 = new BookingComAPI(rooms);
        Room[] result1 = bookingComAPI2.findRooms(100, 2, "Kiev", "Dream");
        for (Room room : result1) {
            System.out.println(room.print());
        }
    }
}
