package ru.komarov.generics;

public class StringConcat implements Reducer<String> {
    @Override
    public String apply(String a, String b) {
        return a + b;
    }
}
