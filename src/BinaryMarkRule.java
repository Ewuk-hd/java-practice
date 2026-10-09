public class BinaryMarkRule implements MarkRule {
    @Override
    public boolean isValid(int mark){
        return mark == 0 || mark == 1;
    }
}
