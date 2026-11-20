package ru.komarov.generics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ListUtils {

    //6.3.1 Функция
    public static <T, P> List<P> map(List<T> list, MyFunction<T, P> function){
        List<P> result = new ArrayList<>();
        for (T t : list) {
            result.add(function.apply(t));
        }
        return result;
    }

    //Функции для 6.3.1
    public static class StringLength implements MyFunction<String, Integer> {
        @Override
        public Integer apply(String s) {
            return s.length();
        }
    }

    public static class Abs implements MyFunction<Integer, Integer> {
        @Override
        public Integer apply(Integer n) {
            return n < 0 ? -n : n;
        }
    }

    public static class ArrayMax implements MyFunction<int[], Integer> {
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


    public static class ListSize implements MyFunction<List<Integer>, Integer> { //чисто для 6.3.3
        @Override
        public Integer apply(List<Integer> list) {
            return list.size();
        }
    }

    //6.3.2 Фильтр
    public static <T> List<T> filter(List<T> list, Filter<T> filter){
        List<T> result = new ArrayList<>();
        for (T t : list) {
            if (filter.test(t)) {
                result.add(t);
            }
        }
        return result;
    }

    //Фильтры для 6.3.2
    public static class ShortStrFilter implements Filter<String> {
        @Override
        public boolean test(String s) {
            return s.length() >= 3;
        }
    }

    public static class PositiveFilter implements Filter<Integer> {
        @Override
        public boolean test(Integer n) {
            return n <= 0;
        }
    }

    public static class NegativeMassiveFilter implements Filter<int[]> {
        @Override
        public boolean test(int[] nums) {
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] > 0) return false;
            }
            return true;
        }
    }

    //6.3.3 Сокращение
    public static <T> T reduce(List<T> list, Reducer<T> reducer, T initial){
        T result = initial;
        for (T t : list) {
            result = reducer.apply(result, t);
        }
        return result;
    }

    //Сокращения для 6.3.3
    public static class StringConcat implements Reducer<String> {
        @Override
        public String apply(String a, String b) {
            return a + b;
        }
    }

    public static class IntSum implements Reducer<Integer> {
        @Override
        public Integer apply(Integer a, Integer b) {
            return a + b;
        }
    }

    //6.3.4 Коллекционирование
    public static <T, P> P collect(List<T> list, Creator<P> creator, Adder<P, T> adder){
        P result = creator.create();
        for (T t : list) {
            adder.add(result, t);
        }
        return result;
    }

    //Коллекционирование для 6.3.4
    public static class TwoListsCreator implements Creator<List<List<Integer>>> {
        @Override
        public List<List<Integer>> create() {
            List<List<Integer>> result = new ArrayList<>();
            result.add(new ArrayList<>());
            result.add(new ArrayList<>());
            return result;
        }
    }

    public static class SignSplitter implements Adder<List<List<Integer>>, Integer> {
        @Override
        public void add(List<List<Integer>> collection, Integer value) {
            if (value > 0) {
                collection.get(0).add(value);
            } else if (value < 0) {
                collection.get(1).add(value);
            }
        }
    }

    public static class LengthGroupCreator implements Creator<Map<Integer, List<String>>> {
        @Override
        public Map<Integer, List<String>> create() {
            return new HashMap<>();
        }
    }

    public static class LengthGrouper implements Adder<Map<Integer, List<String>>, String> {
        @Override
        public void add(Map<Integer, List<String>> collection, String value) {
            List<String> group = collection.get(value.length()); //группа ищется по длине за O(1)
            if (group == null) {
                group = new ArrayList<>();
                collection.put(value.length(), group); //put можнт обновлять поэтому пишем только если пусто
            }
            group.add(value); //в мапе все обновится, т.к. там лтшь ссылка
        }
    }

    public static class UniqueSetCreator<T> implements Creator<Set<T>> {
        @Override
        public Set<T> create() {
            return new LinkedHashSet<>(); //без повторов, проверка за O(1), порядок сохраняется
        }
    }

    public static class UniqueAdder<T> implements Adder<Set<T>, T> {
        @Override
        public void add(Set<T> collection, T value) {
            collection.add(value);
        }
    }
}
