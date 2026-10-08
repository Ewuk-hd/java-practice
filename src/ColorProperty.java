public class ColorProperty extends Property {
    private final String color;

    public ColorProperty(String color){
        this.color = color;
    }

    public String getColor(){
        return color;
    }

    @Override
    public String toString(){
        return "цвет " + color;
    }
}
