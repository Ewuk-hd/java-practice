package ru.komarov.generics;

public interface Reducer<T> {
    T apply(T a, T b);
}
