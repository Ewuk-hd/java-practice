package ru.komarov.generics;

public class StringLength implements MyFunction<String, Integer> {
    @Override
    public Integer apply(String s) {
        return s.length();
    }
}
