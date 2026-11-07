package ru.komarov.network;

public class ConnectionLostException extends Exception {

    public ConnectionLostException() {
    }

    public ConnectionLostException(String message) {
        super(message);
    }

    public ConnectionLostException(Throwable cause) {
        super(cause);
    }

    public ConnectionLostException(String message, Throwable cause) {
        super(message, cause);
    }
}
