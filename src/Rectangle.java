public class Rectangle extends Shape {
    private final double width;
    private final double height;

    public Rectangle(double width, double height){
        if (width <= 0 || height <= 0){
            throw new IllegalArgumentException("Стороны должны быть больше нуля: " + width + ", " + height);
        }
        this.width = width;
        this.height = height;
    }

    public double getWidth(){
        return width;
    }

    public double getHeight(){
        return height;
    }

    @Override
    public double getArea(){
        return width * height;
    }

    @Override
    public String toString(){
        return "Прямоугольник " + width + "x" + height;
    }
}
