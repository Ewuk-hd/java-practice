public class SquareShape extends Rectangle {

    public SquareShape(double side){
        super(side, side);
    }

    public double getSide(){
        return getWidth();
    }

    @Override
    public String toString(){
        return "Квадрат со стороной " + getSide();
    }
}
