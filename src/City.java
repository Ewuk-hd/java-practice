public class City {
    private String name;
    private Way [] ways;

    public City(String name, Way... ways){
        this.name = name;
        this.ways = copy(ways);
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public Way[] getWays(){
        return copy(ways);
    }

    public void setWays(Way... ways){
        this.ways = copy(ways);
    }

    private static Way[] copy(Way[] arr){
        if (arr == null){
            return new Way[0];
        }
        Way [] result = new Way[arr.length];
        for (int i = 0; i < arr.length; i++){
            result[i] = arr[i];
        }
        return result;
    }

    @Override
    public String toString(){
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