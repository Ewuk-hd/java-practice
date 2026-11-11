package ru.komarov.generics;

public class ShortStrFilter implements Filter<String>{
    @Override
    public boolean test(String s){
        return s.length() >= 3;
    }
}
