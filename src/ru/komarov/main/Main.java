package ru.komarov.main;

import java.util.List;

class Main {
    public static void main(String[] args) {
        MainTest.task6_1_1();
        MainTest.task6_1_2();
        MainTest.task6_1_4();
        MainTest.task6_1_5();
        MainTest.task6_1_6();
        MainTest.task6_2_1();
        MainTest.task6_2_2();
        MainTest.task6_2_3();
        MainTest.task6_2_4();
        MainTest.task6_3_1();
        MainTest.task6_3_2();
        MainTest.task6_3_3();
        MainTest.task6_3_4();
        MainTest.taskClosedLineIterator();
        MainTest.taskMixedLine();

        Helper<Integer> h1 = summator(List.of(1, 2, 3));
        System.out.println(h1.getRes());

        Helper<Integer> h2 = summator(List.of());
        System.out.println(h2.getRes());
    
    }

    public static Helper<Integer> summator(List<Integer> list){
        if (list == null || list.isEmpty()){
            return Helper.empty();
        }
        int res = 0;
        for (int i = 0; i < list.size(); i++) {
            res+=list.get(i);
        }
        return Helper.of(res);
    }
}
