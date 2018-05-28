package lesson36.demo;

import lesson36.controllers.HotelController;
import lesson36.controllers.RoomController;
import lesson36.controllers.UserController;
import lesson36.models.Filter;
import lesson36.models.Room;

import java.util.Collections;
import java.util.Date;

public class RoomDemo {
    public static void main(String[] args) {
        UserController userController = new UserController();
        RoomController roomController = new RoomController();
        HotelController hotelController = new HotelController();

        try {
            userController.login("Kilipurt", "123456");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

//        try {
//            userController.login("Honor", "123456");
//        } catch (Exception e) {
//            System.err.println(e.getMessage());
//        }

//        try {
//            roomController.addRoom(new Room(2, 100, true, false, new Date(), hotelController.findHotelByName("Ukraine55")));
//        } catch (Exception e) {
//            System.err.println(e.getMessage());
//        }

//        try {
//            roomController.deleteRoom(47107114);
//        } catch (Exception e) {
//            System.err.println(e.getMessage());
//        }

        try {
            Filter filter = new Filter(null, "Kiev", null, true, null, null, null);
            System.out.println(roomController.findRooms(filter));
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
