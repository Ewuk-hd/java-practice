package ru.komarov.generics;

public class PositiveFilter implements  Filter<Integer>{
    public boolean test(Integer n){
        return n <= 0;
    }
}
