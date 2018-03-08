package lesson11.homework;

import java.util.Arrays;
import java.util.Date;

public class Demo {
    public static void main(String[] args) {
        Room room1 = new Room(13, 500, 4, new Date(), "Dream", "Kiev");
        Room room2 = new Room(14, 100, 2, new Date(), "Dream", "Kiev");
        Room room3 = new Room(15, 200, 3, new Date(), "Dream", "Kiev");
        Room room4 = new Room(16, 150, 3, new Date(), "Dream", "Kiev");
        Room room5 = new Room(17, 100, 2, new Date(), "Dream", "Kiev");

        Room[] rooms = {room1, room2, room3, room4, room5};

        BookingComAPI bookingComAPI = new BookingComAPI(rooms);

        Room[] roomsForBookingComAPI = bookingComAPI.findRooms(200, 2, "Kiev", "Dream");

        for (Room room : roomsForBookingComAPI) {
            System.out.println(room.print());
        }

        System.out.println();

        TripAdvisorAPI tripAdvisorAPI = new TripAdvisorAPI(rooms);

        Room[] roomsForTripAdvisorAPI = tripAdvisorAPI.findRooms(100, 1, "Kiev", "Dream");

        for (Room room : roomsForTripAdvisorAPI) {
            System.out.println(room.print());
        }

        System.out.println();

        GoogleAPI googleAPI = new GoogleAPI(rooms);

        Room[] roomsForGoogleAPI = googleAPI.findRooms(100, 1, "Kiev", "Dream");

        for (Room room : roomsForGoogleAPI) {
            System.out.println(room.print());
        }

        System.out.println();

        API[] apis = {bookingComAPI, tripAdvisorAPI, googleAPI};

        Controller controller = new Controller(apis);

        Room[] roomsForController = controller.requestRooms(100, 1, "Kiev", "Dream");

        for (Room room : roomsForController) {
            System.out.println(room.print());
        }

        System.out.println();

        Room[] roomsCheckForBCAAndTAA = controller.check(bookingComAPI, tripAdvisorAPI);

        for (Room room : roomsCheckForBCAAndTAA) {
            System.out.println(room.print());
        }


    }
}
