package ru.komarov.geometry;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PolygonalLine implements Measurable {
    private ArrayList<Point> points;

    public PolygonalLine(){
        this.points = new ArrayList<>();
    }

    public PolygonalLine(Point... points){
        this.points = toList(points);
    }

    private static ArrayList<Point> toList(Point... arr){
        ArrayList<Point> result = new ArrayList<>();
        if (arr != null){
            for (int i = 0; i < arr.length; i++){
                result.add(new Point(arr[i]));
            }
        }
        return result;
    }

    public ArrayList<Point> getPoints(){
        ArrayList<Point> result = new ArrayList<>();
        for (int i = 0; i < points.size(); i++){
            result.add(new Point(points.get(i)));
        }
        return result;
    }

    public void setPoint(int index, Point point){
        if (index < 0 || index >= points.size()){
            throw new IllegalArgumentException("Нет точки с индексом " + index);
        }
        points.set(index, new Point(point));
    }

    public void addPoints(Point... newPoints){
        points.addAll(toList(newPoints));
    }

    public double getLength(){
        double length = 0;
        for (int i = 0; i < points.size() - 1; i++){
            length += new Line(points.get(i), points.get(i + 1)).getLength();
        }
        return length;
    }

    //Замкнута ли линия (переопределяется в ClosedPolygonalLine)
    protected boolean isClosed(){
        return false;
    }

    //Точки линии без лишних (у замкнутой в конце повторяется первая)
    protected List<Point> getPath(){
        List<Point> points = getPoints();
        //незамкнутая линия, вернувшаяся в начальную точку, — по сути тоже кольцо
        boolean cycle = isClosed() || isCycle(points);
        List<Point> path = simplify(points, cycle);
        if (cycle && path.size() > 1) {
            path.add(path.get(0));   //замыкающий отрезок
        }
        return path;
    }

    //Убирает отрезки нулевой длины и точки, лежащие на прямой между соседями
    private static List<Point> simplify(List<Point> points, boolean closed){
        List<Point> result = new ArrayList<>();
        for (Point p : points) {
            if (result.isEmpty() || !result.get(result.size() - 1).equals(p)) {
                result.add(p);
            }
        }
        if (closed) {
            while (result.size() > 1 && result.get(result.size() - 1).equals(result.get(0))) {
                result.remove(result.size() - 1);
            }
        }
        boolean changed = true;
        while (changed) {
            changed = false;
            int n = result.size();
            for (int i = 0; i < n; i++) {
                if (!closed && (i == 0 || i == n - 1)) continue;   //у незамкнутой концы не трогаем
                if (n < 3) break;
                Point a = result.get((i - 1 + n) % n);
                Point b = result.get(i);
                Point c = result.get((i + 1) % n);
                if (isStraight(a, b, c)) {
                    result.remove(i);
                    changed = true;
                    break;
                }
            }
        }
        return result;
    }

    //B лежит на отрезке AC и не является разворотом назад
    private static boolean isStraight(Point a, Point b, Point c){
        int cross = (b.getX() - a.getX()) * (c.getY() - a.getY()) - (b.getY() - a.getY()) * (c.getX() - a.getX());
        int dot = (b.getX() - a.getX()) * (c.getX() - b.getX()) + (b.getY() - a.getY()) * (c.getY() - b.getY());
        return cross == 0 && dot > 0;
    }

    //Линия замкнута в кольцо: первая точка совпадает с последней
    private static boolean isCycle(List<Point> path){
        return path.size() > 1 && path.get(0).equals(path.get(path.size() - 1));
    }

    //Сравнение колец: любая начальная точка и любое направление обхода
    private static boolean sameCycle(List<Point> a, List<Point> b){
        int n = a.size() - 1;   //последняя точка повторяет первую, её не считаем
        for (int shift = 0; shift < n; shift++) {
            boolean forward = true;
            boolean backward = true;
            for (int i = 0; i < n; i++) {
                if (!a.get(i).equals(b.get((shift + i) % n))) forward = false;
                if (!a.get(i).equals(b.get((shift - i + n) % n))) backward = false;
            }
            if (forward || backward) return true;
        }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) return false;
        if (this == o) return true;
        if (!(o instanceof PolygonalLine)) return false;
        List<Point> a = getPath();
        List<Point> b = ((PolygonalLine) o).getPath();
        if (a.size() != b.size()) return false;
        if (isCycle(a) && isCycle(b)) {
            return sameCycle(a, b);
        }
        List<Point> reversed = new ArrayList<>(b);
        Collections.reverse(reversed);
        return a.equals(b) || a.equals(reversed);
    }

    @Override
    public int hashCode() {
        List<Point> path = getPath();
        int size = isCycle(path) ? path.size() - 1 : path.size();
        int hash = 0;
        for (int i = 0; i < size; i++) {
            hash += path.get(i).hashCode();   //сумма не зависит от порядка и направления
        }
        return hash;
    }

    @Override
    public PolygonalLine clone() {
        try {
            PolygonalLine copy = (PolygonalLine) super.clone();
            copy.points = new ArrayList<>();
            for (int i = 0; i < points.size(); i++) {
                copy.points.add(points.get(i).clone());
            }
            return copy;

        }catch (CloneNotSupportedException e){
            throw new RuntimeException(e);
        }
    }


    @Override
    public String toString() {
        return "Линия " + points;
    }
}
