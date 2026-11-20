package ru.komarov.main;

import ru.komarov.generics.*;
import static ru.komarov.generics.ListUtils.*;
import ru.komarov.study.BinaryMarkRule;
import ru.komarov.study.EvenMarkRule;
import ru.komarov.study.IllegalGradeException;
import ru.komarov.study.Student;
import ru.komarov.network.*;
import ru.komarov.math.Fraction;
import ru.komarov.geometry.*;
import ru.komarov.map.City;
import ru.komarov.map.CityBackWay;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class MainTest {

    //Метод для 6.1.1
    public static void printFromBox(Box<Integer> box){
        int value = box.getOb();
        System.out.println("Достали из коробки: " + value + ", коробка заполнена: " + box.isFull());
    }

    public static void task6_1_1(){
        System.out.println("=== 6.1.1 Обобщенная коробка ===");
        Box<Integer> box = new Box<>();
        box.setOb(3);
        System.out.println("Коробка заполнена: " + box.isFull());
        try {
            box.setOb(5);
        } catch (RuntimeException e) {
            System.out.println("Нельзя положить в непустую коробку");
        }
        printFromBox(box);
    }

    //Методы для 6.1.2
    public static void printFromStorage(Storage<Integer> storage, int alternative){
        int value = storage.getOb(alternative);
        System.out.println("Из хранилища чисел: " + value);
    }

    public static void printFromStorage(Storage<String> storage, String alternative){
        String value = storage.getOb(alternative);
        System.out.println("Из хранилища строк: " + value);
    }

    public static void task6_1_2(){
        System.out.println("=== 6.1.2 Без null ===");
        printFromStorage(new Storage<Integer>(null), 0);
        printFromStorage(new Storage<Integer>(99), -1);
        printFromStorage(new Storage<String>(null), "default");
        printFromStorage(new Storage<String>("hello"), "hello world");
    }

    public static void task6_1_4(){
        System.out.println("=== 6.1.4 ===");
        Student s01 = new Student("Alex", 5, 5, 5, 5);
        Student s02 = new Student("Ilya", 5, 5, 5, 4);
        System.out.println(s01.compare(s02));
    }

    public static void task6_1_5(){
        System.out.println("=== 6.1.5 Обобщенная линия ===");
        Line<Point3D> line = Line.of(1, 2, 3, 4, 5, 6);
        System.out.println(line);
        Point3D start = line.getStart();
        System.out.println("z начала: " + start.getZ());
    }

    public static void task6_1_6(){
        System.out.println("=== 6.1.6 Стек ===");
        Stack<String> stack = new Stack<>();
        stack.push("a");
        stack.push("b");
        stack.push("c");
        System.out.println(stack + ", сверху: " + stack.peek());
        System.out.println("pop: " + stack.pop() + ", осталось: " + stack);
    }

    //Метод для 6.2.1
    public static void shiftStart(Line<? extends Point> line){
        Point start = line.getStart();
        int x = start.getX();
        int newX = x >= 0 ? x + 10 : x - 10;
        line.setStart(newX, start.getY());
    }

    public static void task6_2_1(){
        System.out.println("=== 6.2.1 Сдвинуть линию ===");
        Line<Point> line2d = Line.of(5, 1, 8, 8);
        Line<Point3D> line3d = Line.of(-7, 2, 3, 0, 0, 0);
        shiftStart(line2d);
        shiftStart(line3d);
        System.out.println(line2d);
        System.out.println(line3d);
    }

    //метод для 6.2.2
    public static double maxBoxValue(Box<? extends Number>... boxes){
        double max = Double.NEGATIVE_INFINITY;
        for (Box<? extends Number> box : boxes) {
            if (!box.isFull()) continue;
            double value = box.getOb().doubleValue();
            if (value > max) max = value;
        }
        return max;
    }

    public static void task6_2_2(){
        System.out.println("=== 6.2.2 Поиск максимума ===");
        Box<Integer> b01 = new Box<>();
        b01.setOb(25);

        Box<Double> b02 = new Box<>();
        b02.setOb(13.02);

        Box<Byte> b03 = new Box<>();
        b03.setOb((byte) 127);

        System.out.println(maxBoxValue(b01, b02, b03));
    }

    //метод для 6.2.3
    public static void putPoint(Box<? super Point3D> box){
        box.setOb(new Point3D((int)(Math.random()*10), (int)(Math.random()*10), (int)(Math.random()*10)));
    }

    public static void task6_2_3(){
        System.out.println("=== 6.2.3 Начало отсчета ===");
        Box<Point3D> b01 = new Box<>();
        Box<Point> b02 = new Box<>();
        Box<Object> b03 = new Box<>();
        putPoint(b01);
        putPoint(b02);
        putPoint(b03);
        System.out.println(b01.getOb() + " " + b02.getOb() + " " + b03.getOb());
    }

    //метод для 6.2.4
    public static void putNumbers(List<? super Integer> nums){
        for (int i = 1; i <= 100; i++) {
            nums.add(i);
        }
    }

    public static void task6_2_4(){
        System.out.println("=== 6.2.4 Заполнение списка ===");
        List<Integer> ints = new ArrayList<>();
        List<Number> numbers = new ArrayList<>();
        List<Object> objs = new ArrayList<>();

        putNumbers(ints);
        putNumbers(numbers);
        putNumbers(objs);

        System.out.println(ints.size() + " " + ints.get(0) + ".." + ints.get(99));
        System.out.println(numbers.size() + " " + numbers.get(0) + ".." + numbers.get(99));
        System.out.println(objs.size() + " " + objs.get(0) + ".." + objs.get(99));
    }

    public static void task6_3_1(){
        System.out.println("=== 6.3.1 Функция ===");
        List<String> words = List.of("qwerty", "asdfg", "zx");
        List<Integer> nums = List.of(1, -3, 7);
        List<int[]> arrays = List.of(new int[]{1, 5, 3}, new int[]{-2, -8});

        System.out.println(map(words, new StringLength()));
        System.out.println(map(nums, new Abs()));
        System.out.println(map(arrays, new ArrayMax()));
    }

    public static void task6_3_2(){
        System.out.println("=== 6.3.2 Фильтр ===");
        List<String> words = List.of("qwerty", "asdfg", "zx");
        List<Integer> nums = List.of(1, -3, 7);
        List<int[]> arrays = List.of(new int[]{1, 5, 3}, new int[]{4, -2}, new int[]{-2, -8});

        System.out.println(filter(words, new ShortStrFilter()));
        System.out.println(filter(nums, new PositiveFilter()));
        for (int[] arr : filter(arrays, new NegativeMassiveFilter())) {
            System.out.println(Arrays.toString(arr));
        }
    }

    public static void task6_3_3(){
        System.out.println("=== 6.3.3 Сокращение ===");
        List<String> words = List.of("qwerty", "asdfg", "zx");
        List<Integer> nums = List.of(1, -3, 7);
        List<List<Integer>> lists = List.of(List.of(1, 2), List.of(3), List.of(4, 5, 6));

        System.out.println(reduce(words, new StringConcat(), ""));
        System.out.println(reduce(nums, new IntSum(), 0));


        List<Integer> sizes = map(lists, new ListSize());
        System.out.println(reduce(sizes, new IntSum(), 0));

//        String emptyStr = reduce(new ArrayList<String>(), new StringConcat(), "");
//        int emptySum = reduce(new ArrayList<Integer>(), new IntSum(), 0);
//        System.out.println("Пустые списки: \"" + emptyStr + "\", " + emptySum);
    }

    public static void task6_3_4(){
        System.out.println("=== 6.3.4 Коллекционирование ===");
        List<Integer> nums = List.of(1, -3, 7);
        List<String> words = List.of("qwerty", "asdfg", "zx", "qw");
        List<String> repeats = List.of("qwerty", "asdfg", "qwerty", "qw");

        System.out.println(collect(nums, new TwoListsCreator(), new SignSplitter()));
        System.out.println(collect(words, new LengthGroupCreator(), new LengthGrouper()));
        System.out.println(collect(repeats, new UniqueSetCreator<String>(), new UniqueAdder<String>()));
    }

    //На паре: итератор замкнутой линии
    public static void taskClosedLineIterator(){
        System.out.println("=== Итератор замкнутой линии ===");
        ClosedPolygonalLine cpl = new ClosedPolygonalLine(new Point(1, 1), new Point(2, 2), new Point(3, 3));
        Iterator<Point> it = cpl.iterator();
        for (int i = 0; i < 7; i++) {
            System.out.println(it.next());
        }
    }

    //На паре: линия из разных точек
    public static void taskMixedLine(){
        System.out.println("=== Линия из 2D и 3D точек ===");
        Line<Point> line = new Line<>(new Point(1, 2), new Point3D(4, 5, 6));
        System.out.println(line);
        line.setStart(new Point(7, 7));
        System.out.println(line);
        Line<Point> line2 = new Line<>(new Point(1, 1), new Point(2, 2));
        line2.setEnd(new Point3D(3, 3, 3));
        System.out.println(line2);
        System.out.println("Длина: " + line2.getLength());
    }

}
