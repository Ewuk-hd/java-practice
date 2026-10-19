package ru.komarov.main;

import ru.komarov.study.Student;
import ru.komarov.geometry.*;

import java.util.ArrayList;
import java.util.List;

class Main {
    public static void main(String[] args) {
        //с пары
        System.out.println(sum(3, 4));

        PolygonalLine pl = new PolygonalLine(new Point(3, 4), new Point(10, 10));
        ClosedPolygonalLine cpl = new ClosedPolygonalLine(new Point(5, 5), new Point(7, 7), new Point(1, 1));
        System.out.println(findmax(pl, cpl));
        System.out.println(findmax(new Line(3, 4, 4, 6), new Line(10, 39, 0, 0)));

//        MainTest.task2_1_1();
//        MainTest.task2_1_2();
//        MainTest.task2_1_3();
//        MainTest.task2_1_4();
//        MainTest.task2_1_5();

//        MainTest.task2_2_1();
//        MainTest.task2_2_2();
//        MainTest.task2_2_3();
//        MainTest.task2_2_4();
//        MainTest.task2_2_5();

//        MainTest.task2_3_1();
//        MainTest.task2_3_2();
//        MainTest.task2_3_3();
//        MainTest.task2_3_4();
//        MainTest.task2_3_5();
//        MainTest.task2_3_6();
//        MainTest.task2_3_7();
//        MainTest.task2_3_8();
//        MainTest.task2_3_9();

        MainTest.task3_1_3();
        MainTest.task3_1_4(args);
        MainTest.task3_1_5();

        MainTest.task3_2_1();
        MainTest.task3_2_2();
    }

    public static double sum(Number... nums){
        double res = 0;
        for (int i = 0; i < nums.length; i++) {
            res += nums[i].doubleValue();
        }
        return res;
    }

    public static Measurable findmax(Measurable... mes){
        Measurable ms = mes[0];
        double max = mes[0].getLength();
        for (int i = 1; i < mes.length; i++) {
            double len = mes[i].getLength();
            if (len > max){
                max = len;
                ms = mes[i];
            }
        }
        return ms;
    }

    public List<Student> markSort(Student... students) {
        List<Student> res = new ArrayList<>();
        for (Student student : students) {
            res.add(student);
        }
        return res;
    }
}
