package ru.komarov.generics;

import java.util.ArrayList;
import java.util.List;

public class Stack<T> {
    private final List<T> items = new ArrayList<>();

    public void push(T item) {
        items.add(item);
    }

    public T pop() {
        if (items.isEmpty()) throw new RuntimeException("Стек пуст");
        return items.remove(items.size() - 1);
    }

    public T peek() {
        if (items.isEmpty()) throw new RuntimeException("Стек пуст");
        return items.get(items.size() - 1);
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    @Override
    public String toString() {
        return items.toString();
    }
}
