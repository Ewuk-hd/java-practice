package ru.komarov.generics;

public class PositiveFilter implements Filter<Integer>{
    @Override
    public boolean test(Integer n){
        return n <= 0;
    }
}
