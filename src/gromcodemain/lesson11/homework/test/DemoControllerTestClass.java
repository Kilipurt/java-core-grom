package gromcodemain.lesson11.homework.test;

import gromcodemain.lesson11.homework.*;

import java.util.Date;

public class DemoControllerTestClass {
    public static void main(String[] args) {
        Room room1 = new Room(13, 500, 4, new Date(), "Dream", "Kiev");
        Room room2 = new Room(14, 100, 2, new Date(), "Dream", "Kiev");
        Room room3 = new Room(15, 200, 3, new Date(), "Dream", "Kiev");
        Room room4 = new Room(16, 150, 3, new Date(), "Dream", "Kiev");
        Room room5 = new Room(17, 100, 2, new Date(), "Dream", "Kiev");

        Room[] rooms = {room1, room2, room3, room4, room5};

        //requestRooms(int price, int persons, String city, String hotel)
        //находит все комнаты с указаными параметрами используя все реализации API +
        //если массив apis null +
        //если в массиве есть null API +

        BookingComAPI bookingComAPI = new BookingComAPI(rooms);
        GoogleAPI googleAPI = new GoogleAPI(rooms);
        TripAdvisorAPI tripAdvisorAPI = new TripAdvisorAPI(rooms);

        API[] apis = {bookingComAPI, googleAPI, tripAdvisorAPI};

        Controller controller = new Controller(apis);

        Room[] result = controller.requestRooms(150, 3, "Kiev", "Dream");
        for (Room room : result) {
            System.out.println(room.print());
        }

        API[] apis1 = null;
        Controller controller1 = new Controller(apis1);
        System.out.println(controller1.requestRooms(150, 3, "Kiev", "Dream"));

        API[] apis2 = {bookingComAPI, googleAPI, null};
        Controller controller2 = new Controller(apis2);
        Room[] result1 = controller2.requestRooms(150, 3, "Kiev", "Dream");
        for (Room room : result1) {
            System.out.println(room.print());
        }

        System.out.println();

        //check(API api1, API api2)
        //возвращает общие комнаты у двух реализаций АРІ +
        //если api1 или api2 null +

        Room[] rooms2 = {room2, room3, room4};

        Controller controller3 = new Controller(apis);
        Room[] res = controller3.check(bookingComAPI, tripAdvisorAPI);
        for (Room room : res) {
            System.out.println(room.print());
        }

        System.out.println(controller3.check(bookingComAPI, null));
    }
}
