import java.util.ArrayList;

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
            length += new Line(points.get(points.size() - 1), points.get(0)).length1();
        }
        return length;
    }
}
