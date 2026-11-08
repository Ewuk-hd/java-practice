package ru.komarov.generics;

import java.util.ArrayList;
import java.util.List;

public class LengthGrouper implements Adder<List<List<String>>, String> {
    @Override
    public void add(List<List<String>> collection, String value) {
        for (List<String> group : collection) {
            if (group.get(0).length() == value.length()) {
                group.add(value);
                return;
            }
        }
        List<String> newGroup = new ArrayList<>();
        newGroup.add(value);
        collection.add(newGroup);
    }
}
