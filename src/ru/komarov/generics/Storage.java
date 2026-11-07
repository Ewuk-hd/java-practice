package ru.komarov.generics;

public final class Storage<T> {
    private final T ob;

    public Storage(T ob) {
        this.ob = ob;
    }

    public T getOb(T alternative) {
        if(ob == null) return alternative;
        return ob;
    }
}
