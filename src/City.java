public class City {
    String name;
    Way [] ways;

    public City(String name, Way... ways){
        this.name = name;
        this.ways = ways;
    }

    @Override
    public String toString(){
        if (ways == null) {
            return name + " []";
        }

        String result = name + " [";
        for (int i = 0; i < ways.length; i++){
            if (i > 0){
                result += ", ";
            }
            result += ways[i];
        }
        return result + "]";
    }
}
