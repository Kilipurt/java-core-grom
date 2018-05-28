package lesson36.demo;

import lesson36.controllers.HotelController;
import lesson36.controllers.UserController;
import lesson36.models.Hotel;

public class HotelDemo {
    public static void main(String[] args) {
        HotelController hotelController = new HotelController();
        UserController userController = new UserController();

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

        try {
            hotelController.addHotel(new Hotel("Ukraine55", "Ukraine", "Kiev", "Hreshchatyk"));
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

//        try {
//            hotelController.deleteHotel(31949586);
//        } catch (Exception e) {
//            System.err.println(e.getMessage());
//        }
//
//        try {
//            System.out.println(hotelController.findHotelByName("Ukraine55").getName());
//        } catch (Exception e) {
//            System.err.println(e.getMessage());
//        }
//
//        try {
//            System.out.println(hotelController.findHotelByCity("Kiev").getCity());
//        } catch (Exception e) {
//            System.err.println(e.getMessage());
//        }
    }
}
