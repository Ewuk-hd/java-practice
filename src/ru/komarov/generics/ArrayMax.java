package ru.komarov.generics;

public class ArrayMax implements MyFunction<int[], Integer> {
    @Override
    public Integer apply(int[] arr) {
        if (arr.length == 0) throw new IllegalArgumentException("Пустой массив");
        int max = arr[0];
        for (int x : arr) {
            if (x > max) max = x;
        }
        return max;
    }
}
