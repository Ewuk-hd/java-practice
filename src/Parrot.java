public class Parrot extends Bird {
    private final String text;

    public Parrot(String text){
        if (text == null || text.isEmpty()){
            throw new IllegalArgumentException("Попугаю нужен непустой текст");
        }
        this.text = text;
    }

    public String getText(){
        return text;
    }

    @Override
    public void sing(){
        int n = (int) (Math.random() * text.length()) + 1;
        System.out.println(text.substring(0, n));
    }
}