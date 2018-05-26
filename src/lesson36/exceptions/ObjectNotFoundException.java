package lesson36.exceptions;

public class ObjectNotFoundException extends BadRequestException {
    public ObjectNotFoundException(String message) {
        super(message);
    }
}
