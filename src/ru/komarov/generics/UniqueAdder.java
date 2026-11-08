package ru.komarov.generics;

import java.util.List;

public class UniqueAdder<T> implements Adder<List<T>, T> {
    @Override
    public void add(List<T> collection, T value) {
        if (!collection.contains(value)) {
            collection.add(value);
        }
    }
}
