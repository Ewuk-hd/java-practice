package ru.komarov.geometry;

import java.util.Objects;

public class Line<T extends Point> implements Measurable, Cloneable{
    private T start;
    private T end;

    private Line(int x1, int y1, int x2, int y2) {
        this((T) new Point(x1, y1), (T) new Point(x2, y2));
    }

    private Line(int x1, int y1, int z1, int x2, int y2, int z2) {
        this((T) new Point3D(x1, y1, z1), (T) new Point3D(x2, y2, z2));
    }

    public static Line<Point> of(int x1, int y1, int x2, int y2) {
        return new Line<>(x1, y1, x2, y2);
    }

    public static Line<Point3D> of(int x1, int y1, int z1, int x2, int y2, int z2) {
        return new Line<>(x1, y1, z1, x2, y2, z2); //с помощью статического метода мы контролируем типизацию
    }

    public Line(T start, T end) {
        if (start == null || end == null) {
            throw new IllegalArgumentException("Точка не может быть null");
        }
        this.start = copy(start);
        this.end = copy(end);
    }

    public Line(Line<T> line){
        this(line.start, line.end);
    }

    private T copy(T point){
        return (T) point.clone();
    }

    public T getEnd() {
        return copy(end);
    }

    public void setEnd(T end) {
        if (end == null) {
            setEnd(0, 0);
        } else {
            this.end = copy(end);
        }
    }

    public void setEnd(int x, int y){
        end.setX(x);
        end.setY(y);
    }

    public T getStart() {
        return copy(start);
    }

    public void setStart(T start) {
        if (start == null) {
            setStart(0, 0);
        } else {
            this.start = copy(start);
        }
    }

    public void setStart(int x, int y){
        start.setX(x);
        start.setY(y);
    }

    @Override
    public Line<T> clone() {
        try {
            Line<T> copy = (Line<T>) super.clone();
            copy.start = copy(start);
            copy.end = copy(end);
            return copy;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public double getLength(){
        int[] a = start.getCoords();
        int[] b = end.getCoords();

        int n = a.length; // сколько осей проходить
        if (b.length > n) { // у конца осей больше - берём его количество
            n = b.length;
        }

        double sum = 0;
        for (int i = 0; i < n; i++) {
            int ai = 0; // если оси нет, координата 0
            int bi = 0;
            if (i < a.length) ai = a[i];
            if (i < b.length) bi = b[i];
            sum += (ai - bi) * (ai - bi);
        }
        return Math.sqrt(sum);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Line<?> line = (Line<?>) o; //Приводим неизвестное к неизвестному, чтобы добраться до точек.
                                    //Если типы точек не равны, то проверка не пройдет, так как в
                                    //equals у Point есть проверка с getClass().
        return (Objects.equals(start, line.start) && Objects.equals(end, line.end)) ||
                (Objects.equals(start, line.end) && Objects.equals(end, line.start));
    }

    @Override
    public int hashCode() {
        return start.hashCode() + end.hashCode();
    }

    @Override
    public String toString() {
        return "Линия от " + start + " до " + end;
    }
}
