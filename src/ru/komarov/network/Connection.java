package ru.komarov.network;

public class Connection {
    private final String address;
    private boolean closed;

    public Connection(String address) {
        this.address = address;
        this.closed = false;
    }

    public String getAddress() {
        return address;
    }

    public boolean isClosed() {
        return closed;
    }

    public void close() {
        closed = true;
    }

    public String getData() throws ConnectionLostException {
        if (closed) {
            throw new AlreadyClosedException();
        }
        if (Math.random() < 0.5) {
            throw new ConnectionLostException("Потеряна связь с " + address);
        }
        return "test connection";
    }

    @Override
    public String toString() {
        return "Подключение к " + address + (closed ? " (закрыто)" : " (открыто)");
    }
}
