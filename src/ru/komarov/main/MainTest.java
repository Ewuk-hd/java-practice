package ru.komarov.main;

import ru.komarov.study.BinaryMarkRule;
import ru.komarov.study.EvenMarkRule;
import ru.komarov.study.IllegalGradeException;
import ru.komarov.study.Student;
import ru.komarov.network.*;
import ru.komarov.math.Fraction;
import ru.komarov.geometry.*;
import ru.komarov.map.City;
import ru.komarov.map.CityBackWay;
import ru.komarov.generics.Box;
import ru.komarov.generics.Storage;
import java.util.List;
import java.util.Random;

public class MainTest {

    public static void task4_1_1(){
        System.out.println("=== 4.1.1 Неправильные оценки ===");
        Student vasya = new Student("Вася", new BinaryMarkRule(), 1, 0);
        try {
            vasya.addMark(5);
        } catch (IllegalGradeException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void task4_1_2(){
        System.out.println("=== 4.1.2 Потеря связи ===");
        ConnectionLostException e1 = new ConnectionLostException();
        ConnectionLostException e2 = new ConnectionLostException("нет сети");
        ConnectionLostException e3 = new ConnectionLostException(new RuntimeException("кабель"));
        ConnectionLostException e4 = new ConnectionLostException("нет сети", new RuntimeException("кабель"));
        System.out.println(e1.getMessage() + " | " + e2.getMessage() + " | " + e3.getCause() + " | " + e4.getMessage() + ", причина: " + e4.getCause());
    }

    public static void task4_1_3(){
        System.out.println("=== 4.1.3 Уже закрыто ===");
        AlreadyClosedException e = new AlreadyClosedException();
        System.out.println(e);
    }

    public static void task4_1_4(){
        System.out.println("=== 4.1.4 Подключение к сети ===");
        Connection con = new Connection("192.168.0.1");
        System.out.println(con);
        for (int i = 0; i < 5; i++) {
            try {
                System.out.println(con.getData());
            } catch (ConnectionLostException e) {
                System.out.println(e.getMessage());
            }
        }
        con.close();
        System.out.println(con);
        try {
            con.getData();
        } catch (ConnectionLostException e) {
            System.out.println(e.getMessage());
        } catch (AlreadyClosedException e) {
            System.out.println("Подключение уже закрыто");
        }
    }

    //Метод для 4.2.1
    public static void readData() throws ConnectionLostException {
        Connection con = new Connection("ermakov.edu");
        try {
            for (int i = 0; i < 10; i++) {
                System.out.println(con.getData());
            }
        } finally {
            con.close();
            System.out.println(con);
        }
    }

    public static void task4_2_1(){
        System.out.println("=== 4.2.1 Читаем данные ===");
        try {
            readData();
        } catch (ConnectionLostException e) {
            System.out.println(e.getMessage());
        }
    }

    //Метод для 4.2.2
    public static double divide(String... strings){
        Double first = null;
        double result = 0;
        for (String s : strings) {
            double number;
            try {
                number = Double.parseDouble(s);
            } catch (NumberFormatException e) {
                continue;
            }
            if (first == null) {
                first = number;
                result = number;
            } else {
                result /= number;
            }
        }
        if (first == null) {
            return Double.NaN;
        }
        return result;
    }

    public static void task4_2_2(){
        System.out.println("=== 4.2.2 Складываем строки ===");
        System.out.println(divide("100", "abc", "5", "2", "x1"));
        System.out.println(divide("привет", "мир"));
    }

    //Метод для 4.2.3
    public static String addRandomMarks(List<Student> students){
        Random random = new Random();
        int[] marks = new int[students.size()];
        for (int i = 0; i < students.size(); i++) {
            marks[i] = random.nextInt(10) + 1;
            try {
                students.get(i).clone().addMark(marks[i]);
            } catch (IllegalGradeException e) {
                return "Оценки не добавлены: " + e.getMessage();
            }
        }
        for (int i = 0; i < students.size(); i++) {
            students.get(i).addMark(marks[i]);
        }
        return "Оценки добавлены всем";
    }

    public static void task4_2_3(){
        System.out.println("=== 4.2.3 Добавляем оценки ===");
        Student vasya = new Student("Вася", new EvenMarkRule(), 2, 4);
        Student petya = new Student("Петя", 3, 5);
        List<Student> students = List.of(vasya, petya);
        System.out.println(addRandomMarks(students));
        System.out.println(vasya + " | " + petya);
    }

    public static void task4_2_4(){
        System.out.println("=== 4.2.4 Завершение регистрации ===");
        ExampleConnector connector = new ExampleConnector();
        for (int i = 0; i < 5; i++) {
            try {
                connector.makeConnect(new Connection("ermakov.edu"));
            } catch (ConnectionLostException e) {
                connector.unregister();
            } catch (RuntimeException e) {
                System.out.println("register не удался, игнорируем");
            }
        }
    }

    public static void task5_1_1(){
        System.out.println("=== 5.1.1 Сравнение дробей ===");
        Fraction f1 = new Fraction(1, 2);
        Fraction f2 = new Fraction(1, 2);
        Fraction f3 = new Fraction(2, 4);
        System.out.println(f1.equals(f2) + " " + (f1.hashCode() == f2.hashCode()) + " " + f1.equals(f3));
    }

    public static void task5_1_2(){
        System.out.println("=== 5.1.2 Сравнение точек ===");
        Point p1 = new Point(1, 2);
        Point p2 = new Point(1, 2);
        Point p3 = new Point(2, 1);
        System.out.println(p1.equals(p2) + " " + (p1.hashCode() == p2.hashCode()) + " " + p1.equals(p3));
    }

    public static void task5_1_3(){
        System.out.println("=== 5.1.3 Сравнение линий ===");
        Line l1 = new Line(1, 2, 3, 4);
        Line l2 = new Line(1, 2, 3, 4);
        Line l3 = new Line(3, 4, 1, 2);
        System.out.println(l1.equals(l2) + " " + l1.equals(l3) + " " + l2.equals(l3));
        System.out.println((l1.hashCode() == l2.hashCode()) + " " + (l1.hashCode() == l3.hashCode()));
    }

    public static void task5_1_4(){
        System.out.println("=== 5.1.4 Сравнение ломаных линий ===");
        PolygonalLine line1 = new PolygonalLine(new Point(1, 2), new Point(3, 4), new Point(7, 8));
        ClosedPolygonalLine line2 = new ClosedPolygonalLine(new Point(1, 2), new Point(3, 4), new Point(7, 8));
        PolygonalLine line3 = new PolygonalLine(new Point(1, 2), new Point(3, 4), new Point(7, 8), new Point(1, 2));
        PolygonalLine line4 = new PolygonalLine(new Point(7, 8), new Point(3, 4), new Point(1, 2));
        System.out.println("1 и 2: " + line1.equals(line2) + ", 1 и 3: " + line1.equals(line3) + ", 2 и 3: " + line2.equals(line3) + ", 3 и 2: " + line3.equals(line2));
        System.out.println("хеши 2 и 3: " + (line2.hashCode() == line3.hashCode()));
        System.out.println("1 и обратная 1: " + line1.equals(line4) + ", хеши: " + (line1.hashCode() == line4.hashCode()));
    }

    public static void task5_1_5(){
        System.out.println("=== 5.1.5 Сравнение городов ===");
        City a = new City("A");
        City b = new City("B");
        City c1 = new City("C1");
        City c2 = new CityBackWay("C2");
        c1.addWay(a, 10);
        c1.addWay(b, 20);
        c2.addWay(b, 99);
        c2.addWay(a, 5);
        System.out.println(c1.equals(c2) + " " + c2.equals(c1) + " " + (c1.hashCode() == c2.hashCode()));
        c2.removeWay(b);
        System.out.println(c1.equals(c2));
    }

    public static void task5_1_6(){
        System.out.println("=== 5.1.6 Сравнение студентов ===");
        Student s1 = new Student("Вася", 3, 5);
        Student s2 = new Student("Вася", 4, 4);
        Student s3 = new Student("Вася", 5, 5);
        Student s4 = new Student("Петя", 4, 4);
        System.out.println(s1.equals(s2) + " " + (s1.hashCode() == s2.hashCode()) + " " + s1.equals(s3) + " " + s2.equals(s4));
    }

    public static void task5_2_1(){
        System.out.println("=== 5.2.1 Клонирование дроби ===");
        Fraction f = new Fraction(3, 4);
        Fraction copy = f.clone();
        System.out.println(copy + " равна: " + f.equals(copy) + ", другой объект: " + (f != copy));
    }

    public static void task5_2_2(){
        System.out.println("=== 5.2.2 Клонирование точки ===");
        Point p = new Point(1, 2);
        Point copy = p.clone();
        p.setX(99);
        System.out.println("оригинал: " + p + ", копия: " + copy);
        Point p3 = new Point3D(1, 2, 3);
        Point copy3 = p3.clone();
        System.out.println("копия Point3D: " + copy3 + ", тип: " + copy3.getClass().getSimpleName());
    }

    public static void task5_2_3(){
        System.out.println("=== 5.2.3 Клонирование линии ===");
        Line line = new Line(0, 0, 3, 4);
        Line copy = line.clone();
        line.setEnd(9, 9);
        System.out.println("оригинал: " + line + ", копия: " + copy);
    }

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
}
