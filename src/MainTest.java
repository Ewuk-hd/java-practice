public class MainTest {

    // 1.1.1 Точка координат: три точки с разными координатами
    public static void task1_1_1() {
        System.out.println("=== 1.1.1 Точка координат ===");
        Point p1 = new Point(1, 2);
        Point p2 = new Point(-5, 10);
        Point p3 = new Point(0, 0);
        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);
    }

    // 1.1.2 Человек: Клеопатра 152, Пушкин 167, Александр 189
    public static void task1_1_2() {
        System.out.println("=== 1.1.2 Человек ===");
        Person cleopatra = new Person("Клеопатра", 152);
        Person pushkin = new Person("Пушкин", 167);
        Person alexander = new Person("Александр", 189);
        System.out.println(cleopatra);
        System.out.println(pushkin);
        System.out.println(alexander);
    }

    // 1.1.3 Имена: Клеопатра; Пушкин Александр Сергеевич; Маяковский Владимир
    public static void task1_1_3() {
        System.out.println("=== 1.1.3 Имена ===");
        FullName cleopatra = new FullName(null, "Клеопатра", null);
        FullName pushkin = new FullName("Пушкин", "Александр", "Сергеевич");
        FullName mayakovsky = new FullName("Маяковский", "Владимир", null);
        System.out.println(cleopatra);
        System.out.println(pushkin);
        System.out.println(mayakovsky);
    }

    // 1.1.4 Время: 10, 10000, 100000 секунд
    public static void task1_1_4() {
        System.out.println("=== 1.1.4 Время ===");
        DayTime t1 = new DayTime(10);
        DayTime t2 = new DayTime(10000);
        DayTime t3 = new DayTime(100000);
        System.out.println(t1);
        System.out.println(t2);
        System.out.println(t3);
    }

    // 1.1.5 Дом: 1, 5, 23 этажа
    public static void task1_1_5() {
        System.out.println("=== 1.1.5 Дом ===");
        House h1 = new House(1);
        House h2 = new House(5);
        House h3 = new House(23);
        System.out.println(h1);
        System.out.println(h2);
        System.out.println(h3);
    }

    // 1.2.1 Прямая линия
    public static void task1_2_1() {
        System.out.println("=== 1.2.1 Прямая линия ===");
        // 1. Линия 1 от {1;3} до {23;8}
        Line line1 = new Line(new Point(1, 3), new Point(23, 8));
        // 2. Линия 2, горизонтальная, на высоте 10, от x=5 до x=25
        Line line2 = new Line(new Point(5, 10), new Point(25, 10));
        // 3. Линия 3 ссылается на те же объекты-точки: начало линии 1 и конец линии 2
        Line line3 = new Line(line1.start, line2.end);
        System.out.println(line1);
        System.out.println(line2);
        System.out.println(line3);

        // 4. Меняем координаты самих точек, поэтому линия 3 меняется вместе с ними
        System.out.println("-- меняем координаты точек линий 1 и 2 --");
        line1.start.x = 2;
        line1.start.y = 4;
        line2.end.x = 30;
        line2.end.y = 10;
        System.out.println(line1);
        System.out.println(line2);
        System.out.println(line3);

        // 5. Даём линии 1 новый объект-точку: у линии 3 остаётся старая точка
        System.out.println("-- даём линии 1 новую точку начала --");
        line1.start = new Point(-7, 0);
        System.out.println(line1);
        System.out.println(line3);
    }

    // 1.2.2 Человек с именем
    public static void task1_2_2() {
        System.out.println("=== 1.2.2 Человек с именем ===");
        // После 1.2.3 рост не входит в строку, но объекты создаются по условию 1.2.2
        Human cleopatra = new Human(new FullName(null, "Клеопатра", null), 152);
        Human pushkin = new Human(new FullName("Пушкин", "Александр", "Сергеевич"), 167);
        Human mayakovsky = new Human(new FullName("Маяковский", "Владимир", null), 189);
        System.out.println(cleopatra);
        System.out.println(pushkin);
        System.out.println(mayakovsky);
    }

    // 1.2.3 Человек с родителем
    public static void task1_2_3() {
        System.out.println("=== 1.2.3 Человек с родителем ===");
        Human ivan = new Human(new FullName("Чудов", "Иван", null), 180);
        Human petr = new Human(new FullName("Чудов", "Петр", null), 175);
        Human boris = new Human(new FullName(null, "Борис", null), 170);

        petr.father = ivan;
        boris.father = petr;

        System.out.println(ivan);
        System.out.println(petr);
        System.out.println(boris);
    }

    // 1.2.4 Сотрудники и отделы
    public static void task1_2_4() {
        System.out.println("=== 1.2.4 Сотрудники и отделы ===");
        Department it = new Department("IT");

        Employee petrov = new Employee("Петров", it);
        Employee kozlov = new Employee("Козлов", it);
        Employee sidorov = new Employee("Сидоров", it);

        it.boss = kozlov;

        System.out.println(petrov);
        System.out.println(kozlov);
        System.out.println(sidorov);


    }

    public static void task1_3_1(){
        System.out.println("=== 1.3.1 Студент ===");
        //1. Вася
        int [] vMarks = new int[]{3, 4, 5};
        Student vasya = new Student("Вася", vMarks);
        System.out.println(vasya);
        //2. Петя с оценками васи (копировать по полю)
        Student petya = new Student("Петя", vasya.marks);
        System.out.println(petya);
        //3. Замена оценки Пети
        petya.marks[0] = 5;
        System.out.println(petya);
        System.out.println(vasya); //Тоже поменяется, т.к. ссылаются на один массив

        //4. Андрей с независимой копией оценок
        int [] aMarks = new int[vasya.marks.length];
        for (int i = 0; i < vasya.marks.length; i++) {
            aMarks[i] = vasya.marks[i];
        }
        Student andrey = new Student("Андрей", aMarks);

        vasya.marks[1] = 2; //влепил двойку
        System.out.println(vasya);
        System.out.println(andrey);
    }

    public static void task1_3_2(){
        System.out.println("===1.3.2 Ломанная линия===");
        //1. Первая ломанная
        Point p001 = new Point(1, 5);
        Point p002 = new Point(2, 8);
        Point p003 = new Point(5, 3);
        Point [] p1 = new Point[]{p001, p002, p003};
        PolygonalLine pl1 = new PolygonalLine(p1);
        System.out.println(pl1.toString());
        //2. Вторая ломанная
        Point p004 = pl1.points[0];
        Point p005 = new Point(6, 7);
        Point p006 = new Point(9, 10);
        Point p007 = pl1.points[2];
        Point [] p2 = new Point[]{p004, p005, p006, p007};
        PolygonalLine pl2 = new PolygonalLine(p2);
        System.out.println(pl2);
        //3. Сдвиг первой ломанной
        pl1.points[0].x = 10;
        pl1.points[0].y = 10;
        System.out.println(pl2);
    }

    public static void task1_3_3(){
        System.out.println("=== 1.3.3 Города ===");
        //1. Создаём все города без путей, т.к. пути ссылаются друг на друга по кругу
        City a = new City("A", null);
        City b = new City("B", null);
        City c = new City("C", null);
        City d = new City("D", null);
        City e = new City("E", null);
        City f = new City("F", null);

        //2. Задаём пути по рисунку 1.14
        a.ways = new Way[]{new Way(b, 5), new Way(f, 1), new Way(d, 6)};
        b.ways = new Way[]{new Way(a, 5), new Way(c, 3)};
        c.ways = new Way[]{new Way(b, 3), new Way(d, 4)};
        d.ways = new Way[]{new Way(a, 6), new Way(c, 4), new Way(e, 2)};
        e.ways = new Way[]{new Way(f, 2)};
        f.ways = new Way[]{new Way(b, 1), new Way(e, 2)};

        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);
        System.out.println(e);
        System.out.println(f);
    }

    public static void task1_3_4(){
        System.out.println("=== 1.3.4 Сотрудники и отделы ===");
        Department it = new Department("IT");

        Employee petrov = new Employee("Петров", it);
        Employee kozlov = new Employee("Козлов", it);
        Employee sidorov = new Employee("Сидоров", it);
        it.boss = kozlov;

        //Имея ссылку только на Петрова, выводим весь его отдел
        for (int i = 0; i < petrov.department.employees.length; i++) {
            System.out.println(petrov.department.employees[i]);
        }
    }

    public static void task1_4_1(){
        //Уже выполнено в 1.1.1
        System.out.println("=== 1.4.1 Точки с обяз указанием XY ===");
        Point p008 = new Point(3, 5);
        Point p009 = new Point(25, 6);
        Point p010 = new Point(7, 8);
        System.out.println(p008 + "\n" + p009 + "\n" + p009);
    }

    public static void task1_4_2(){
        System.out.println("=== 1.4.2 Конструкторы с разными параметрами (Линия) ===");
        Line line1 = new Line(new Point(1, 3), new Point(23, 8));
        Line line2 = new Line(5, 10, 25, 10);
        Line line3 = new Line(line1.start, line2.end);
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
}

