public abstract class Shape {
    public abstract double getArea();

    public static double totalArea(Shape... shapes){
        double sum = 0;
        for (int i = 0; i < shapes.length; i++){
            sum += shapes[i].getArea();
        }
        return sum;
    }
}
