package ru.komarov.generics;

public class Abs implements MyFunction<Integer, Integer> {
    @Override
    public Integer apply(Integer n) {
        return n < 0 ? -n : n;
    }
}
