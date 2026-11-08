package ru.komarov.generics;

import java.util.ArrayList;
import java.util.List;

public class TwoListsCreator implements Creator<List<List<Integer>>> {
    @Override
    public List<List<Integer>> create() {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        result.add(new ArrayList<>());
        return result;
    }
}
