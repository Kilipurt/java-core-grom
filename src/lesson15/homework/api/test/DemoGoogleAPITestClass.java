package lesson15.homework.api.test;

import lesson15.homework.api.GoogleAPI;
import lesson15.homework.api.Room;

import java.util.Arrays;
import java.util.Date;

public class DemoGoogleAPITestClass {
    public static void main(String[] args) {
        Room room1 = new Room(13, 500, 4, new Date(), "Dream", "Kiev");
        Room room2 = new Room(14, 100, 2, new Date(), "Dream", "Kiev");
        Room room3 = new Room(15, 200, 2, new Date(), "Dream", "Kiev");
        Room room4 = new Room(16, 150, 3, new Date(), "Dream", "Kiev");
        Room room5 = new Room(17, 100, 2, new Date(), "Dream", "Kiev");

        Room[] rooms = {room1, room2, room3, room4, room5};

        //findRooms(int price, int persons, String city, String hotel)
        //возвращает все комнаты с задаными параметрами +
        //если массив комнат равен null +
        //если среди комнат есть null +

        GoogleAPI googleAPI = new GoogleAPI(rooms);
        Room[] result = googleAPI.findRooms(100, 2, "Kiev", "Dream");
        for (Room room : result) {
            System.out.println(room.print());
        }

        GoogleAPI googleAPI1 = new GoogleAPI(null);
        System.out.println(Arrays.toString(googleAPI1.findRooms(100, 2, "Kiev", "Dream")));

        Room[] rooms1 = {room1, room2, null, room3, room4, room5, null};
        GoogleAPI googleAPI2 = new GoogleAPI(rooms);
        Room[] result1 = googleAPI2.findRooms(100, 2, "Kiev", "Dream");
        for (Room room : result1) {
            System.out.println(room.print());
        }
    }
}
