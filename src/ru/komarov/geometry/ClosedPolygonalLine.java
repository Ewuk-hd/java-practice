package ru.komarov.geometry;
import java.util.ArrayList;
import java.util.List;

public class ClosedPolygonalLine extends PolygonalLine {

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
            length += new Line(points.get(points.size() - 1), points.get(0)).getLength();
        }
        return length;
    }

    @Override
    protected List<Point> getPath(){
        ArrayList<Point> path = getPoints();
        if (!path.isEmpty()) {
            path.add(path.get(0));   //замыкающий отрезок
        }
        return path;
    }
}
