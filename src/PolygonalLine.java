import java.util.ArrayList;

public class PolygonalLine {
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
            length += new Line(points.get(i), points.get(i + 1)).length1();
        }
        return length;
    }

    @Override
    public String toString() {
        return "Линия " + points;
    }
}
