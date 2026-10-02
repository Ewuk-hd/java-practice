public class Square {
    private Point topLeftP;
    private int side;

    public Square(Point topLeftP, int side) {
        if(side <= 0){
            throw new IllegalArgumentException("Некорректная длина стороны: " + side);
        }
        this.topLeftP = new Point(topLeftP);
        this.side = side;
    }

    public Square(int x, int y, int side) {
        this(new Point(x, y), side);
    }

    public Point getTopLeftP() {
        return new Point(topLeftP);
    }

    public void setTopLeftP(Point topLeftP) {
        this.topLeftP = new Point(topLeftP);
    }

    public int getSide() {
        return side;
    }

    public void setSide(int side) {
        if(side <= 0){
            throw new IllegalArgumentException("Некорректная длина стороны: " + side);
        }
        this.side = side;
    }

    public PolygonalLine getPL(){
        int x = topLeftP.getX();
        int y = topLeftP.getY();
        return new PolygonalLine(
                new Point(x, y),
                new Point(x + side, y),
                new Point(x + side, y - side),
                new Point(x, y - side));
    }

    @Override
    public String toString() {
        return "Квадрат в точке " + topLeftP + " со стороной " + side;
    }
}
