public class Circle extends Shape {
    private final double radius;

    public Circle(double radius){
        if (radius <= 0){
            throw new IllegalArgumentException("Радиус должен быть больше нуля: " + radius);
        }
        this.radius = radius;
    }

    public double getRadius(){
        return radius;
    }

    @Override
    public double getArea(){
        return Math.PI * radius * radius;
    }

    @Override
    public String toString(){
        return "Круг радиусом " + radius;
    }
}
