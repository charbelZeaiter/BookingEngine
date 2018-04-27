package main;

public class BookingEngineRunTimeException extends RuntimeException {

    public BookingEngineRunTimeException(String message) {
        super(message);
    }

    public BookingEngineRunTimeException(Throwable cause) {
        super(cause);
    }
}
