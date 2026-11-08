package ru.komarov.generics;

import java.util.List;

public class SignSplitter implements Adder<List<List<Integer>>, Integer> {
    @Override
    public void add(List<List<Integer>> collection, Integer value) {
        if (value > 0) {
            collection.get(0).add(value);
        } else if (value < 0) {
            collection.get(1).add(value);
        }
    }
}
