public class SizeProperty extends Property {
    private final int size;

    public SizeProperty(int size){
        if (size <= 0){
            throw new IllegalArgumentException("Размер должен быть больше нуля: " + size);
        }
        this.size = size;
    }

    public int getSize(){
        return size;
    }

    @Override
    public String toString(){
        return "размер " + size;
    }
}
