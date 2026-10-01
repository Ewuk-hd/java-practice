public class MainTest {
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

}

