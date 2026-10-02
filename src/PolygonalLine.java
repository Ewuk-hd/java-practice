public class PolygonalLine {
    private Point [] points;

    public PolygonalLine(){
        this.points = new Point[0];
    }

    public PolygonalLine(Point... points){
        this.points = copy(points);
    }

    private static Point[] copy(Point[] arr){
        if (arr == null){
            return new Point[0];
        }
        Point [] result = new Point[arr.length];
        for (int i = 0; i < arr.length; i++){
            result[i] = new Point(arr[i]);
        }
        return result;
    }

    public Point[] getPoints(){
        return copy(points);
    }

    public void setPoint(int index, Point point){
        if (index < 0 || index >= points.length){
            throw new IllegalArgumentException("Нет точки с индексом " + index);
        }
        points[index] = new Point(point);
    }

    public void addPoints(Point... newPoints){
        Point [] added = copy(newPoints);
        Point [] arr = new Point[points.length + added.length];
        for (int i = 0; i < points.length; i++){
            arr[i] = points[i];
        }
        for (int i = 0; i < added.length; i++){
            arr[points.length + i] = added[i];
        }
        points = arr;
    }

    public double getLength(){
        double length = 0;
        for (int i = 0; i < points.length - 1; i++){
            length += new Line(points[i], points[i + 1]).length1();
        }
        return length;
    }

    @Override
    public String toString() {
        String result = "Линия [";
        for(int i = 0; i < points.length; i++){
            result += points[i];
            if(i < points.length-1) result += ", ";
        }
        result += "]";
        return result;
    }
}
