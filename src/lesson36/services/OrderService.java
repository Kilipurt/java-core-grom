package lesson36.services;

import lesson36.exceptions.BadRequestException;
import lesson36.exceptions.ObjectNotFoundException;
import lesson36.models.Order;
import lesson36.models.Room;
import lesson36.models.User;
import lesson36.repositories.OrderRepository;
import lesson36.repositories.RoomRepository;

import java.util.Date;

public class OrderService {
    private OrderRepository orderRepository = new OrderRepository();
    private RoomRepository roomRepository = new RoomRepository();

    public void bookRoom(long roomId, User user, Date dateFrom, Date dateTo) throws Exception {
        Room room = roomRepository.findById(roomId);

        if (room == null)
            throw new ObjectNotFoundException("Room with id " + roomId + " was not found");

        if (dateFrom.compareTo(room.getDateAvailableFrom()) < 0)
            throw new BadRequestException("Room with id " + roomId + " will be available from " + room.getDateAvailableFrom());

        Order order = new Order(user, room, dateFrom, dateTo, room.getPrice());
        orderRepository.create(order);
    }

    public void cancelReservation(long roomId, long userId) throws Exception {
        for (Order order : orderRepository.getAll()) {
            if (order.getRoom().getId() == roomId && order.getUser().getId() == userId) {
                orderRepository.remove(order);
                return;
            }
        }

        throw new ObjectNotFoundException("User with id " + userId + " does not book room with id " + roomId);
    }
}
