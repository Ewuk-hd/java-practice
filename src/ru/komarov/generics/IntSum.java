package ru.komarov.generics;

public class IntSum implements Reducer<Integer> {
    @Override
    public Integer apply(Integer a, Integer b) {
        return a + b;
    }
}
