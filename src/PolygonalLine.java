public class PolygonalLine {
    Point [] points;

    public PolygonalLine(){
        this.points = new Point[0];
    }

    public PolygonalLine(Point... points){
        this.points = points;
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
