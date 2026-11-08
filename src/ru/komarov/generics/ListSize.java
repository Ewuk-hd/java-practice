package ru.komarov.generics;

import java.util.List;

public class ListSize implements MyFunction<List<Integer>, Integer> {
    @Override
    public Integer apply(List<Integer> list) {
        return list.size();
    }
}
