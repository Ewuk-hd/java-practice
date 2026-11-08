package ru.komarov.generics;

public interface Filter<T> {
    boolean test(T t);
}
