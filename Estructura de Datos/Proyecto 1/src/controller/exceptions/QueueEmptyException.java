package controller.exceptions;

public class QueueEmptyException extends RuntimeException {
    public QueueEmptyException(String message) {
        super(message);
    }
}
