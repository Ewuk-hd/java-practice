// 1) добавить сюда JavaDoc (на каждый класс повесить описание методов и сгенерировать html. ArrayUtils это библиотека, которую мы закинем в репозиторий)

// 2) добавить в начало, в указанную позицию, удаление соответственно
// 2*) (для тех кто осилит) сделать нормальный дин. массив у которого size и capacity не одно и тоже

// 3) Реализовать задания 1.1 из задачинка

import java.util.Arrays;

public class DynamicArray {
    int[] value;

    public double sum() {
        if (value == null) return Double.NaN;
        double total = 0;
        for (int el : value) {
            total += el;
        }
        return total;
    }

    public String toString() {
        if (value == null) return "null";
        if (value.length == 0) return "[]";

        String returnString;
        returnString = "[" + value[0];
        for (int i = 1; i < value.length; i++) {
            returnString += ", " + value[i];
        }
        returnString += "]";
        return returnString;
    }

    public void addLast(int num) {
        if (value == null) {
            value = new int[]{num};
            return;
        }
        int[] arr2 = new int[value.length + 1];
        for (int i = 0; i < value.length; i++) {
            arr2[i] = value[i];
        }
        arr2[value.length] = num;
        value = arr2;
    }

//мб не надо было, но добавил
    public void addFirst(int x) {
        if (value == null) {
            value = new int[]{x};
            return;
        }
        int[] arr1 = new int[value.length + 1];
        arr1[0] = x;
        for (int i = 1; i < value.length + 1; i++) {
            arr1[i] = value[i - 1];
        }
        value = arr1;
    }

    public void addToPosition(int x, int pos) {
        if (value == null) {
            if (pos == 0) {
                value = new int[]{x};
                return;
            }
            System.out.println("Позиция " + pos + " недопустима для null-массива");
            return;
        }

        if (pos < 0 || pos > value.length) {
            System.out.println("Позиция " + pos + " вне диапазона [0, " + value.length + "]");
            return;
        }

        int[] arr1 = new int[value.length + 1];
        arr1[pos] = x;

        for (int i = 0; i < value.length + 1; i++) {
            if (i == pos) continue;
            if (i < pos) {
                arr1[i] = value[i];
            } else {
                arr1[i] = value[i - 1];
            }
        }
        value = arr1;
    }

    public void delLast() {
        if (value == null || value.length == 0) {
            System.out.println("Массив пуст, удалять нечего");
            return;
        }

        int[] arr1 = new int[value.length - 1];
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = value[i];
        }
        value = arr1;
    }

    public void delFirst() {
        if (value == null || value.length == 0) {
            System.out.println("Массив пуст, удалять нечего");
            return;
        }

        int[] arr1 = new int[value.length - 1];
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = value[i + 1];
        }
        value = arr1;
    }

    public void delFromPosition(int pos) {
        if (value == null || value.length == 0) {
            System.out.println("Массив пуст, удалять нечего");
            return;
        }
        if (pos < 0 || pos >= value.length) {
            System.out.println("Позиция " + pos + " вне диапазона [0, " + (value.length - 1) + "]");
            return;
        }

        int[] arr1 = new int[value.length - 1];
        for (int i = 0; i < arr1.length; i++) {
            if (i < pos) {
                arr1[i] = value[i];
            } else {
                arr1[i] = value[i + 1];
            }
        }
        value = arr1;
    }
}