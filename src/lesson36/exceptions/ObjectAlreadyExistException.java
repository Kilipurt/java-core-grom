package lesson36.exceptions;

public class ObjectAlreadyExistException extends BadRequestException {
    public ObjectAlreadyExistException(String message) {
        super(message);
    }
}
