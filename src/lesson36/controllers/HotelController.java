package lesson36.controllers;

import lesson36.exceptions.AuthorizeException;
import lesson36.models.Hotel;
import lesson36.models.UserType;
import lesson36.services.HotelService;

public class HotelController {
    private HotelService hotelService = new HotelService();
    private UserController userController = new UserController();

    public void addHotel(Hotel hotel) throws Exception {
        validateUserRights();
        hotelService.addHotel(hotel);
    }

    public void deleteHotel(long hotelId) throws Exception {
        validateUserRights();
        hotelService.deleteHotel(hotelId);
    }

    public Hotel findHotelByCity(String city) throws Exception {
        if (userController.getAuthorizedUser() == null)
            throw new AuthorizeException("User is not authorized");

        if (city == null || city.isEmpty())
            throw new NullPointerException("City is empty");

        return hotelService.findHotelByCity(city);
    }

    public Hotel findHotelByName(String name) throws Exception {
        if (userController.getAuthorizedUser() == null)
            throw new AuthorizeException("User is not authorized");

        return hotelService.findHotelByName(name);
    }

    private void validateUserRights() throws AuthorizeException {
        if (userController.getAuthorizedUser() == null)
            throw new AuthorizeException("User is not authorized");

        if (userController.getAuthorizedUser().getUserType() != UserType.ADMIN)
            throw new AuthorizeException("User with id " + userController.getAuthorizedUser().getId() + " does not enough rights");
    }
}
