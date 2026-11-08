package ru.komarov.generics;

import java.util.ArrayList;
import java.util.List;

public class UniqueListCreator<T> implements Creator<List<T>> {
    @Override
    public List<T> create() {
        return new ArrayList<>();
    }
}
