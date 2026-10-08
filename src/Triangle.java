public class Triangle extends Shape {
    private final double a;
    private final double b;
    private final double c;

    public Triangle(double a, double b, double c){
        if (a <= 0 || b <= 0 || c <= 0 || a + b <= c || a + c <= b || b + c <= a){
            throw new IllegalArgumentException("Треугольника со сторонами " + a + ", " + b + ", " + c + " не существует");
        }
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public double getArea(){
        double p = (a + b + c) / 2;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }

    @Override
    public String toString(){
        return "Треугольник со сторонами " + a + ", " + b + ", " + c;
    }
}
