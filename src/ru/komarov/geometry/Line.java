package ru.komarov.geometry;

public class Line<T extends Point> implements Measurable, Cloneable{
    private T start;
    private T end;

    public static Line<Point> of(int x1, int y1, int x2, int y2) {
        return new Line<>(new Point(x1, y1), new Point(x2, y2));
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
        int kat1 = end.getX() - start.getX();
        int kat2 = end.getY() - start.getY();
        return Math.sqrt(kat1*kat1 + kat2*kat2);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Line<?> line = (Line<?>) o; //Приводим неизвестное к неизвестному, чтобы добраться до точек.
                                    //Если типы точек не равны, то проверка не пройдет, так как в
                                    //equals у Point есть проверка с getClass().
        return start.equals(line.start) && end.equals(line.end) || start.equals(line.end) && end.equals(line.start);
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
