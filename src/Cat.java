public class Cat implements Meowable {
    String name;

    public Cat(String name){
        this.name = name;
    }

    public void meow(){
        meow(1);
    }

    public void meow(int n){
        if (n < 1){
            return;
        }
        String result = name + ": мяу";
        for (int i = 1; i < n; i++){
            result += "-мяу";
        }
        System.out.println(result + "!");
    }

    @Override
    public String toString(){
        return "кот: " + name;
    }
}
