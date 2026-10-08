public class BorderProperty extends Property {
    private final String color;
    private final String shape;

    public BorderProperty(String color, String shape){
        this.color = color;
        this.shape = shape;
    }

    @Override
    public String toString(){
        return color + " ободок в форме " + shape;
    }
}
