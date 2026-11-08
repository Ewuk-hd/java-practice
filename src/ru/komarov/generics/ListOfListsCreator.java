package ru.komarov.generics;

import java.util.ArrayList;
import java.util.List;

public class ListOfListsCreator<T> implements Creator<List<List<T>>> {
    @Override
    public List<List<T>> create() {
        return new ArrayList<>();
    }
}
