package lesson36.controllers;

import lesson36.exceptions.AuthorizeException;
import lesson36.services.OrderService;

import java.util.Date;

public class OrderController {
    private Session session = new Session();
    private OrderService orderService = new OrderService();

    public void bookRoom(long roomId, Date dateFrom, Date dateTo) throws Exception {
        if (session.getAuthorizedUser() == null)
            throw new AuthorizeException("User is not authorized");

        orderService.bookRoom(roomId, session.getAuthorizedUser(), dateFrom, dateTo);
    }

    public void cancelReservation(long roomId) throws Exception {
        if (session.getAuthorizedUser() == null)
            throw new AuthorizeException("User is not authorized");

        orderService.cancelReservation(roomId, session.getAuthorizedUser().getId());
    }
}
