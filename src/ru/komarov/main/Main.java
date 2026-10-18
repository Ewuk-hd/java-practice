package ru.komarov.main;

import ru.komarov.study.Student;
import ru.komarov.geometry.*;

import java.util.ArrayList;
import java.util.List;

class Main {
    public static void main(String[] args) {

//            ru.komarov.main.MainTest.task2_1_1();
//            ru.komarov.main.MainTest.task2_1_2();
//            ru.komarov.main.MainTest.task2_1_3();
//            ru.komarov.main.MainTest.task2_1_4();
//
//            ru.komarov.main.MainTest.task2_1_5();
//
//            ru.komarov.main.MainTest.task2_2_1();
//            ru.komarov.main.MainTest.task2_2_2();
//            ru.komarov.main.MainTest.task2_2_3();
//            ru.komarov.main.MainTest.task2_2_4();
//            ru.komarov.main.MainTest.task2_2_5();
//
//
//            ru.komarov.main.MainTest.task2_3_1();
//            ru.komarov.main.MainTest.task2_3_2();
//            ru.komarov.main.MainTest.task2_3_3();
//            ru.komarov.main.MainTest.task2_3_4();
//            ru.komarov.main.MainTest.task2_3_5();
//            ru.komarov.main.MainTest.task2_3_6();
//            ru.komarov.main.MainTest.task2_3_7();
//            ru.komarov.main.MainTest.task2_3_8();
//            ru.komarov.main.MainTest.task2_3_9();
            ru.komarov.main.MainTest.task3_1_3();
            MainTest.task3_1_5();


        System.out.println(sum(3, 4));

        PolygonalLine pl = new PolygonalLine(new Point(3 ,4), new Point(10, 10));
        ClosedPolygonalLine cpl = new ClosedPolygonalLine(new Point(5,5 ), new Point( 7,7), new Point(1,1));
        System.out.println(findmax(pl, cpl));
        System.out.println(findmax(new Line(3, 4 ,4 ,6), new Line(10, 39, 0 , 0)));



        }
        public static double sum(Number... nums){
            double res = 0;
            for (int i = 0; i < nums.length; i++) {
                res += nums[i].doubleValue();
            }
            return res;
        }

        public static Measurable findmax(Measurable... mes){
            double max = mes[0].getLength();
            Measurable ms = mes[0];
            for (int i = 0; i < mes.length - 1; i++) {
               if(mes[i+1].getLength() > ms.getLength()){
                  // max = mes[i+1].getLength();
                   ms = mes[i+1];
               }
            }
           // return max;
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
