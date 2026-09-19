class Main {
    public static void main(String[] args) {
        int[] arr = {3, 4, 2};
        DynamicArray arrDyn = new DynamicArray();
        System.out.println(arrDyn);
        arrDyn.value = new int[]{1, 2, 3, 4};
        arrDyn.addLast(55);
        arrDyn.addFirst(99);
        System.out.println(arrDyn);
        System.out.println(arrDyn.sum());

        int[] result = ArrayUtils.addToPosition(arr, 77, 2);
        System.out.println(ArrayUtils.arrToString(result));

        result = ArrayUtils.delFirst(result);
        result = ArrayUtils.delFromPosition(result, 1);
        System.out.println(ArrayUtils.arrToString(result));
        System.out.println("\n\n");


        // 1.1.1 - Точка
        Point p1 = new Point(1, 2);
        Point p2 = new Point(-3, 5);
        Point p3 = new Point(0, 0);
        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);

        // 1.1.2 - Человек
        Person cleopatra = new Person("Клеопатра", 152);
        Person pushkin = new Person("Пушкин", 167);
        Person alexander = new Person("Александр", 189);
        System.out.println(cleopatra);
        System.out.println(pushkin);
        System.out.println(alexander);

        // 1.1.3 - Имя
        FullName n1 = new FullName(null, "Клеопатра", null);
        FullName n2 = new FullName("Пушкин", "Александр", "Сергеевич");
        FullName n3 = new FullName("Маяковский", "Владимир", null);
        System.out.println(n1);
        System.out.println(n2);
        System.out.println(n3);

        // 1.1.4 - Время
        DayTime t1 = new DayTime(10);
        DayTime t2 = new DayTime(10000);
        DayTime t3 = new DayTime(100000);
        System.out.println(t1);
        System.out.println(t2);
        System.out.println(t3);

        // 1.1.5 - Дом
        House h1 = new House(1);
        House h2 = new House(5);
        House h3 = new House(23);
        System.out.println(h1);
        System.out.println(h2);
        System.out.println(h3);

    }
}