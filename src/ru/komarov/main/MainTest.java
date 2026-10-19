package ru.komarov.main;

import ru.komarov.animals.*;
import ru.komarov.geometry.properties.ColorProperty;
import ru.komarov.geometry.properties.FeaturePoint;
import ru.komarov.map.City;
import ru.komarov.map.CityBackWay;
import ru.komarov.math.Fraction;
import ru.komarov.study.BinaryMarkRule;
import ru.komarov.study.EvenMarkRule;
import ru.komarov.study.Student;
import ru.komarov.weapons.AutoGun;
import ru.komarov.weapons.Gun;
import ru.komarov.shooters.Shooter;
import ru.komarov.weapons.Weapon;
import ru.komarov.geometry.*;
import ru.komarov.geometry.properties.*;

import ru.komarov.work.*;
import java.util.ArrayList;
import java.math.BigInteger;

//3.1.4
import static java.lang.Math.pow;
import static java.lang.Integer.parseInt;

public class MainTest {

    public static void task2_1_1(){
        System.out.println("=== 2.1.1 Запретная Дробь ===");
        Fraction f = new Fraction(1, 2);
        System.out.println(f);
    }

    public static void task2_1_2(){
        System.out.println("=== 2.1.2 Замкнутая ломаная ===");
        PolygonalLine open = new PolygonalLine(new Point(0, 0), new Point(10, 0), new Point(10, 10), new Point(0, 10));
        ClosedPolygonalLine closed = new ClosedPolygonalLine(new Point(0, 0), new Point(10, 0), new Point(10, 10), new Point(0, 10));
        System.out.println(open + " длина: " + open.getLength());
        System.out.println(closed + " длина: " + closed.getLength());
    }

    public static void task2_1_3(){
        System.out.println("=== 2.1.3 Двусторонняя дорога ===");
        CityBackWay a = new CityBackWay("A");
        CityBackWay b = new CityBackWay("B");
        City c = new City("C");

        a.addWay(b, 5);
        System.out.println(a);
        System.out.println(b);

        b.addWay(a, 8);
        System.out.println(a);
        System.out.println(b);

        a.addWay(c, 3);
        System.out.println(c);
    }

    public static void task2_1_4(){
        System.out.println("=== 2.1.4 Автомат ===");
        AutoGun ak = new AutoGun(4, 2);
        ak.shoot();
        System.out.println("--");
        ak.shoot(2);

        AutoGun def = new AutoGun();
        System.out.println("Без параметров: вместимость " + def.getMaxBullets() + ", скорострельность " + def.getFireRate());
        AutoGun half = new AutoGun(10);
        System.out.println("Вместимость 10: скорострельность " + half.getFireRate());
        //new ru.komarov.weapons.AutoGun(10, 0);                            //выбросит IllegalArgumentException
    }

    public static void task2_1_5(){
        System.out.println("=== 2.1.5 Трёхмерная точка ===");
        Point3D p011 = new Point3D(3, 5, 10);
        System.out.println(p011);
    }

    public static void task2_2_1(){
        System.out.println("=== 2.2.1 Оружие ===");
        Weapon w = new Gun(7, 3);                   //пистолет теперь - оружие
        w.shoot();                                  //Бах!
        System.out.println("Патронов: " + w.ammo());
        System.out.println("Было до перезарядки: " + w.load(7));
        System.out.println("Патронов: " + w.ammo());
    }

    public static void task2_2_2(){
        System.out.println("=== 2.2.2 Дробь - это число ===");
        Fraction f = new Fraction(7, 2);
        Number n = f;

        System.out.println(f + " -> int: " + n.intValue());
        System.out.println(f + " -> long: " + n.longValue());
        System.out.println(f + " -> float: " + n.floatValue());
        System.out.println(f + " -> double: " + n.doubleValue());
    }

    public static void task2_2_3(){
        System.out.println("=== 2.2.3 Птицы ===");
        Bird[] birds = { new Sparrow(), new Cuckoo(), new Parrot("Попка дурак") };
        for (int i = 0; i < birds.length; i++){
            birds[i].sing();
        }
    }

    public static void task2_2_4(){
        System.out.println("=== 2.2.4 Фигуры ===");
        Shape[] shapes = {
                new Circle(2),
                new Rectangle(3, 4),
                new SquareShape(5),
                new Triangle(3, 4, 5)
        };
        for (int i = 0; i < shapes.length; i++){
            System.out.println(shapes[i] + ", площадь: " + shapes[i].getArea());
        }
    }

    public static void task2_2_5(){
        System.out.println("=== 2.2.5 Точки ===");
        FeaturePoint p1 = new FeaturePoint(3);
        p1.addProperty(new ColorProperty("красный"));

        FeaturePoint p2 = new FeaturePoint(4, 2, 5);
        p2.addProperty(new SizeProperty(20));

        FeaturePoint p3 = new FeaturePoint(7, 7);
        p3.addProperty(new ColorProperty("жёлтый"));
        p3.addProperty(new BorderProperty("красный", "котёнка"));

        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);
    }
    // Метод для 2.3.1
    public static double sum(Number... numbers){
        double result = 0;
        for (int i = 0; i < numbers.length; i++) {
            result += numbers[i].doubleValue();
        }
        return result;
    }

    public static void task2_3_1(){
        System.out.println("=== 2.3.1 Результат сложения в вещественном ===");
        System.out.println(sum(2, new Fraction(3, 5), 2.3));
        System.out.println(sum(3.6, new Fraction(49, 12), 3, new Fraction(3, 2)));
        System.out.println(sum(new Fraction(1, 3), 1));
    }


    //Метод для 2.3.2
    public static void birdMarket(Bird... birds){
        for (int i = 0; i < birds.length; i++) {
            birds[i].sing();
        }
    }

    public static void task2_3_2(){
        System.out.println("=== 2.3.2 Птичий рынок ===");
        Sparrow sparrow = new Sparrow();
        Sparrow sparrow1 = new Sparrow();
        Cuckoo cuckoo = new Cuckoo();
        Cuckoo cuckoo1 = new Cuckoo();
        Parrot parrot = new Parrot("Попка хороший попугай");
        Parrot parrot1 = new Parrot("Сегодня хороший день");
        birdMarket(sparrow, cuckoo, parrot, sparrow1, cuckoo1, parrot1);
    }


    public static void task2_3_3(){
        System.out.println("=== 2.3.3 Общая площадь ===");
        double total = Shape.totalArea(
                new Circle(1),
                new Circle(2),
                new SquareShape(3),
                new SquareShape(4));
        System.out.println("Общая площадь: " + total);
    }

    //Метод для 2.3.4
    public static void meowAll(Meowable... meowers){
        for (int i = 0; i < meowers.length; i++) {
            meowers[i].meow();
        }
    }

    public static void task2_3_4(){
        System.out.println("=== 2.3.4 Мяуканье ===");
        meowAll(new Cat("Дымок"), new Cat("Соня"), new Panther());
    }

    public static double totalLength(Measurable... items){
        double sum = 0;
        for (int i = 0; i < items.length; i++) {
            sum += items[i].getLength();
        }
        return sum;
    }

    //Метод для 2.3.5
    public static void task2_3_5(){
        System.out.println("=== 2.3.5 Измерение длины ===");

        Line line = new Line(0, 0, 3,4);
        PolygonalLine pl = new PolygonalLine(new Point(4, 4), new Point(8, 8));
        ClosedPolygonalLine cpl = new ClosedPolygonalLine(new Point(10, 10), new Point(20, 20), new Point(30, 30));
        System.out.println("Итоговая длина:" + totalLength(line, pl, cpl));
    }

    public static void task2_3_6(){
        System.out.println("=== 2.3.6 Замкнутый квадрат ===");
        Square sq = new Square(0, 0, 10);
        PolygonalLine pl = sq.getPolyline();
        System.out.println(pl);
        System.out.println(pl.getLength());
    }

    public static void task2_3_8(){
        System.out.println("=== 2.3.8 Лучший стрелок ===");

        Shooter bob = new Shooter("Боб");
        Shooter garry = new Shooter("Гэрри");
        Shooter mike = new Shooter("Майк");

        garry.setWeapon(new Gun(7, 3));
        mike.setWeapon(new AutoGun(12, 3));

        System.out.println(garry.getName() + " стреляет:");
        garry.shoot();
        System.out.println(mike.getName() + " стреляет:");
        mike.shoot();
        System.out.println(bob.getName() + " стреляет:");
        bob.shoot();
    }

    //Метод для 2.3.7
    public static PolygonalLine joinPolylines(Polylinable... items){
        PolygonalLine result = new PolygonalLine();
        for (int i = 0; i < items.length; i++){
            ArrayList<Point> points = items[i].getPolyline().getPoints();
            for (int j = 0; j < points.size(); j++){
                result.addPoints(points.get(j));
            }
        }
        return result;
    }
    public static void task2_3_7(){
        System.out.println("=== 2.3.7 Поломки ===");
        PolygonalLine joined = joinPolylines(new Square(0, 0, 2), new Square(10, 10, 3));
        System.out.println(joined);
    }

    public static void task2_3_9(){
        System.out.println("=== 2.3.9 Правильные оценки ===");
        Student vasya = new Student("Вася", new BinaryMarkRule(), 1, 0, 1);
        Student petya = new Student("Петя", new EvenMarkRule(), 2, 4, 10, 100);
        Student free = new Student("Без правила", 7, -3, 100);
        System.out.println(vasya);
        System.out.println(petya);
        System.out.println(free);
        //vasya.addMark(5);                 //Exception: не 0 и не 1
        //petya.addMark(3);                 //Exception: нечётное
    }

    public static void task3_1_3(){
        System.out.println("=== 3.1.3 Сложение из пакетов ===");
        BigInteger big = new BigInteger("12345678912345678912");
        System.out.println(sum(7, new Fraction(11, 3), 3.21, big));
    }

    //Метод для 3.1.4
    public static double power(String x, String y){
        double pw = pow(parseInt(x), parseInt(y));
        return pw;
    }

    public static void task3_1_4(String[] args){
        System.out.println("=== 3.1.4 Возведение в степень ===");
        System.out.println(power(args[0], args[1]));
    }

    public static void task3_1_5(){
        System.out.println("=== 3.1.5 Простые имена ===");
        Point p001 = new Point(13, 2);
        java.awt.Point p002 = new java.awt.Point(26, 6);
        System.out.println(p001);
        System.out.println(p002);
    }

    public static void task3_2_1(){
        System.out.println("=== 3.2.1 Отделы доверяют начальникам ===");
        Department it = new Department("IT");
        Department hr = new Department("HR");
        Employee petrov = new Employee("Петров");
        Employee kozlov = new Employee("Козлов");
        it.addEmployee(petrov);
        hr.setChief(kozlov);                //Козлов переводится в HR и становится начальником
        System.out.println(kozlov + ", начальник HR: " + hr.getChief().getName());
        kozlov.setDep(it);                  //уходит в IT - в HR начальника больше нет
        System.out.println(kozlov + ", начальник HR: " + hr.getChief());
        System.out.println("IT: " + it.getEmployees().size() + ", HR: " + hr.getEmployees().size());
    }

    public static void task3_2_2(){
        System.out.println("=== 3.2.2 Патроны наследникам ===");
        Gun gun = new Gun(7, 5);
        gun.shoot();
        System.out.println("Разряжено: " + gun.unload());     //4 - unload работает с полем ammo напрямую
        System.out.println("Осталось: " + gun.getBullets());  //0
        gun.shoot();
        //gun.ammo = 100;   //ошибка: ammo - protected, MainTest не наследник Weapon и в другом пакете
    }
}
