public class Cuckoo extends Bird {
    @Override
    public void sing(){
        int count = (int) (Math.random() * 10) + 1;   //Math.random() даёт [0;1), *10 -> [0;10), +1 -> от 1 до 10
        String result = "";
        for (int i = 0; i < count; i++){
            if (i > 0){
                result += " ";
            }
            result += "ку-ку";
        }
        System.out.println(result);
    }
}
