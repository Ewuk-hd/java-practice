import java.util.ArrayList;

public class MainTest {
    public static void task1_4_1(){
        //Уже выполнено в 1.1.1
        System.out.println("=== 1.4.1 Точки с обяз указанием XY ===");
        Point p008 = new Point(3, 5);
        Point p009 = new Point(25, 6);
        Point p010 = new Point(7, 8);
        System.out.println(p008 + "\n" + p009 + "\n" + p010);
    }

    public static void task1_4_2(){
        System.out.println("=== 1.4.2 Конструкторы с разными параметрами (Линия) ===");
        Line line1 = new Line(new Point(1, 3), new Point(23, 8));
        Line line2 = new Line(5, 10, 25, 10);
        Line line3 = new Line(line1.getStart(), line2.getEnd());
        System.out.println(line1);
        System.out.println(line2);
        System.out.println(line3);
    }

    public static void task1_4_3(){
        System.out.println("=== 1.4.3 Рисуем Ломаную линию ===");
        PolygonalLine empty = new PolygonalLine();
        System.out.println(empty);
        PolygonalLine pl = new PolygonalLine(new Point(3, 5), new Point(25, 6), new Point(7, 8));
        System.out.println(pl);
    }

    public static void task1_4_4(){
        System.out.println("=== 1.4.4 Строим Дом (final) ===");
        FinalHouse h1 = new FinalHouse(2);
        FinalHouse h2 = new FinalHouse(35);
        FinalHouse h3 = new FinalHouse(91);
        System.out.println(h1);
        System.out.println(h2);
        System.out.println(h3);
    }

    public static void task1_4_5(){
        System.out.println("=== 1.4.5 Даем имена ===");
        FullName cleopatra = new FullName("Клеопатра");
        FullName pushkin = new FullName("Пушкин", "Александр", "Сергеевич");
        FullName mayakovsky = new FullName("Владимир", "Маяковский");
        FullName christophor = new FullName("Христофор", "Бонифатьевич");
        System.out.println(cleopatra);
        System.out.println(pushkin);
        System.out.println(mayakovsky);
        System.out.println(christophor);
    }

    public static void task1_4_6(){
        System.out.println("=== 1.4.6 Создаем Человека ===");
        Human lev = new Human("Лев");
        Human sergey = new Human(new FullName("Сергей", "Пушкин"), lev);
        Human alexander = new Human("Александр", sergey);
        System.out.println(lev);
        System.out.println(sergey);
        System.out.println(alexander);
    }

    public  static void task1_4_7(){
        Student vasya = new Student("Вася", 3, 4, 5);
        Student maxim = new Student("Максим");
        System.out.println(vasya);
        System.out.println(maxim);
    }

    public static void task1_4_8(){
        System.out.println("=== 1.4.8 Основываем Города ===");
        City b = new City("B");
        City e = new City("E");
        City f = new City("F", new Way(b, 1), new Way(e, 2));
        System.out.println(b);
        System.out.println(f);
    }

    public static void task1_5_1(){
        System.out.println("=== 1.5.1 Пистолет стреляет ===");
        Gun gun = new Gun(3);
        for (int i = 0; i < 5; i++){
            gun.shoot();
        }
    }

    public static void task1_5_2(){
        System.out.println("=== 1.5.2 Кот мяукает ===");
        Cat barsik = new Cat("Барсик");
        System.out.println(barsik);
        barsik.meow();
        barsik.meow(3);
    }

    public static void task1_5_3(){
        System.out.println("=== 1.5.3 Длина Линии ===");
        Line line = new Line(1, 1, 10, 15);
        System.out.println((int) line.getLength());
    }

    public static void task1_5_4(){
        System.out.println("=== 1.5.4 Отец моего отца ===");
        Human ivan = new Human(new FullName("Иван", "Чудов"));
        Human petr = new Human("Петр", ivan);
        Human boris = new Human("Борис", petr);
        System.out.println(ivan);
        System.out.println(petr);
        System.out.println(boris);
    }

    public static void task1_5_5(){
        System.out.println("=== 1.5.5 Дроби ===");
        Fraction f1 = new Fraction(1, 3);
        Fraction f2 = new Fraction(2, 3);
        Fraction f3 = new Fraction(3, 4);

        System.out.println(f1 + " + " + f2 + " = " + f1.sum(f2));
        System.out.println(f1 + " - " + f3 + " = " + f1.minus(f3));
        System.out.println(f1 + " * " + f2 + " = " + f1.mul(f2));
        System.out.println(f2 + " : " + f3 + " = " + f2.div(f3));

        System.out.println(f1 + " + 2 = " + f1.sum(2));
        System.out.println(f1 + " - 1 = " + f1.minus(1));
        System.out.println(f2 + " * 3 = " + f2.mul(3));
        System.out.println(f3 + " : 2 = " + f3.div(2));

        System.out.println("(" + f1 + " + " + f2 + ") : " + f3 + " - 5 = " + f1.sum(f2).div(f3).minus(5));
    }

    public static void task1_5_6(){
        System.out.println("=== 1.5.6 Студент отличник ===");
        Student vasya = new Student("Вася", 3, 4, 5, 4);
        Student petya = new Student("Петя", 5, 5, 5, 5);
        System.out.println(vasya + " средний балл: " + vasya.getAverage() + ", отличник: " + vasya.isExcellent());
        System.out.println(petya + " средний балл: " + petya.getAverage() + ", отличник: " + petya.isExcellent());
    }

    public static void task1_5_7(){
        System.out.println("=== 1.5.7 Длина Ломаной ===");
        PolygonalLine pl = new PolygonalLine(new Point(1, 5), new Point(2, 8), new Point(5, 3));
        System.out.println(pl.getLength());
        pl.addPoints(new Point(5, 15), new Point(8, 10));
        System.out.println(pl.getLength());
    }

    public static void task1_5_8(){
        System.out.println("=== 1.5.8 Квадрат ===");
        //1. Создать квадрат
        Square sq = new Square(new Point(5, 3), 23);
        System.out.println(sq);
        //2. Присвоить в ссылку типа Ломаная результат sq.getPolyline();
        PolygonalLine sqPL = sq.getPolyline();
        System.out.println(sqPL);
        //3. Вывести длину ломаной
        System.out.println(sqPL.getLength());
        //4. Сместить последнюю точку ломаной
        sqPL.setPoint(sqPL.getPoints().size() - 1, new Point(15, 25));
        System.out.println(sqPL);
        //5. Снова вывести длину
        System.out.println(sqPL.getLength());
    }

    public static void task1_6_1(){
        System.out.println("=== 1.6.1 Дом над землей ===");
        System.out.println(new FinalHouse(5));
        System.out.println(new FinalHouse(1));
        //System.out.println(new FinalHouse(-3));   //выбросит IllegalArgumentException, программа остановится
    }

    public static void task1_6_2(){
        System.out.println("=== 1.6.2 Непустые Имена ===");
        System.out.println(new FullName("Клеопатра"));
        System.out.println(new FullName("", "Владимир", null));   //пустая фамилия просто не учитывается
        new FullName(null, "", null);   //выбросит IllegalArgumentException: все части пустые
    }

    public static void task1_6_3(){
        System.out.println("=== 1.6.3 Сторона Квадрата ===");
        Square sq = new Square(5, 3, 10);
        System.out.println(sq);
        System.out.println("Сторона: " + sq.getSide());

        sq.setSide(20);
        System.out.println(sq);
        System.out.println("Сторона: " + sq.getSide());

        //new Square(5, 3, 0);                   //выбросит IllegalArgumentException при создании
        //sq.setSide(-5);                          //выбросит IllegalArgumentException при изменении
    }

    public static void task1_6_4(){
        System.out.println("=== 1.6.4 Дроби ===");
        Fraction f1 = new Fraction(1, -2);
        Fraction f2 = new Fraction(-3, -4);
        Fraction f3 = new Fraction(1, 2);
        Fraction f4 = new Fraction(-1, 3);
        System.out.println("1/-2 -> " + f1);
        System.out.println("-3/-4 -> " + f2);
        System.out.println(f3 + " : " + f4 + " = " + f3.div(f4));
        System.out.println(f1 + " - " + f2 + " = " + f1.minus(f2));
        //new Fraction(1, 0);   //выбросит IllegalArgumentException: знаменатель 0
    }

    public static void task1_6_5(){
        System.out.println("=== 1.6.5 Перезарядка Пистолета ===");
        Gun gun = new Gun(7, 0);
        gun.reload(3);
        for (int i = 0; i < 5; i++){
            gun.shoot();
        }
        System.out.println("Лишних: " + gun.reload(8));
        gun.shoot();
        gun.shoot();
        System.out.println("Разряжено: " + gun.unload());
        gun.shoot();
        System.out.println("Заряжен: " + gun.isLoaded());
    }

    public static void task1_6_6(){
        System.out.println("=== 1.6.6 Отдельные линии ===");
        Line line1 = new Line(1, 1, 5, 5);
        Line line2 = new Line(line1.getStart(), line1.getEnd());
        line1.setStart(0, 0);
        System.out.println(line1);
        System.out.println(line2);

        Point p = line2.getStart();
        p.setX(100);
        System.out.println(line2);
        System.out.println("Начало line1: " + line1.getStart() + ", конец: " + line1.getEnd());
    }

    public static void task1_6_7(){
        System.out.println("=== 1.6.7 Родители остаются ===");
        Human ivan = new Human(new FullName("Иван", "Чудов"));
        Human petr = new Human("Петр", ivan);
        System.out.println(petr);
        System.out.println("Отец: " + petr.getFather());
        System.out.println("Имя: " + petr.getName());
        //petr.father = new Human("Другой");   //ошибка компиляции: поле private final
    }

    public static void task1_6_8(){
        System.out.println("=== 1.6.8 Диапазон оценок ===");
        Student vasya = new Student("Вася", 3, 4, 5);
        vasya.addMark(2);
        System.out.println(vasya);
        System.out.println(vasya.getMarks());
        vasya.addMark(7);                  //выбросит IllegalArgumentException
        new Student("Петя", 1, 5);         //выбросит IllegalArgumentException
    }

    public static void task1_6_9(){
        System.out.println("=== 1.6.9 Дороги ===");
        City b = new City("B");
        City c = new City("C");
        City d = new City("D");
        City a = new City("A", new Way(b, 5), new Way(c, 3), new Way(b, 7));
        System.out.println(a);

        a.addWay(c, 10);
        a.addWay(d, 4);
        System.out.println(a);

        a.removeWay(b);
        System.out.println(a);
    }

    //должен успешно выполнять: перевод сотрудника, удаление с департмента, установка боссом
    public static void task1_6_10(){
        System.out.println("=== 1.6.10 Начальник отдела ===");
        Department it = new Department("IT");
        Department hr = new Department("HR");
        Employee petrov = new Employee("Петров");
        Employee kozlov = new Employee("Козлов");


        petrov.setDepartment(it);
        kozlov.setDepartment(it);

        it.setDepartmentHead(kozlov);
        System.out.println(petrov);
        System.out.println(kozlov);

        kozlov.setDepartment(hr);
        System.out.println(petrov);
        System.out.println(kozlov);
        System.out.println("IT: " + it.getEmployees().size() + ", HR: " + hr.getEmployees().size());
    }

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
        //new AutoGun(10, 0);                            //выбросит IllegalArgumentException
    }

    public static void task2_1_5(){
        System.out.println("=== 2.1.5 Трёхмерная точка точка ===");
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
            System.out.println(items[i].getLength());
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
    }

    //Метод для 2.3.7
    public static PolygonalLine joinPolylines(Polylinable... items){
        PolygonalLine result = new PolygonalLine();
        for (int i = 0; i < items.length; i++){
            ArrayList<Point> points = items[i].getPolyline().getPoints();   //точки очередной ломаной
            for (int j = 0; j < points.size(); j++){
                result.addPoints(points.get(j));                           //дописываем в общую
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
}
