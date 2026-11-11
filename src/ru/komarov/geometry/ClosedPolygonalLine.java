package ru.komarov.geometry;
import java.util.ArrayList;
import java.util.Iterator;

public class ClosedPolygonalLine extends PolygonalLine implements Iterable<Point> {

    public ClosedPolygonalLine(){
        super();
    }

    public ClosedPolygonalLine(Point... points){
        super(points);
    }

    @Override
    public double getLength(){
        double length = super.getLength();
        ArrayList<Point> points = getPoints();
        if (points.size() > 1){
            length += new Line<>(points.get(points.size() - 1), points.get(0)).getLength();
        }
        return length;
    }



    @Override
    protected boolean isClosed(){
        return true;
    }

    @Override
    public Iterator<Point> iterator() {

        return new PointIterator();
    }

    private class PointIterator implements Iterator<Point>{
        private int index =0;

        @Override
        public boolean hasNext(){
            return true;
        }

        @Override
        public Point next(){
            ArrayList<Point> points = getPoints();
            if(index >= points.size()){
                index = 0;


            }
            return points.get(index++);
        }

    }


}


//хотим чтобы реализовывала интерфейс итерабл
//метод итератор
//итератор прячется внутри класса, реализуем клас итератор имеющий некст и хеснекст,
// некст всегда true, некст всегда следующий поинт, когда список значений заканчивается мы переходим в начало
