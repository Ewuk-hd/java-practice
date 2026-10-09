public class EvenMarkRule implements MarkRule {
    @Override
    public boolean isValid(int mark){
        return mark % 2 == 0;
    }
}
