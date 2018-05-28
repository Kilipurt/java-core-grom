package lesson36.controllers;

import lesson36.exceptions.AuthorizeException;
import lesson36.models.Filter;
import lesson36.models.Room;
import lesson36.models.UserType;
import lesson36.services.RoomService;

import java.util.ArrayList;

public class RoomController {
    private UserController userController = new UserController();
    private RoomService roomService = new RoomService();

    public void addRoom(Room room) throws Exception {
        validateUserRights();

        roomService.addRoom(room);
    }

    public void deleteRoom(long roomId) throws Exception {
        validateUserRights();

        roomService.deleteRoom(roomId);
    }

    public ArrayList<Room> findRooms(Filter filter) throws Exception {
        if (userController.getAuthorizedUser() == null)
            throw new AuthorizeException("User is not authorized");

        if (filter == null)
            throw new NullPointerException("Filter is empty");

        return roomService.findRooms(filter);
    }

    private void validateUserRights() throws AuthorizeException {
        if (userController.getAuthorizedUser() == null)
            throw new AuthorizeException("User is not authorized");

        if (userController.getAuthorizedUser().getUserType() != UserType.ADMIN)
            throw new AuthorizeException("User with id " + userController.getAuthorizedUser().getId() + " does not enough rights");
    }
}
