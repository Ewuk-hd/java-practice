public class City {
    private String name;
    private Way [] ways;

    public City(String name, Way... ways){
        this.name = name;
        this.ways = new Way[0];
        if (ways != null){
            for (int i = 0; i < ways.length; i++){
                addWay(ways[i].getCityTo(), ways[i].getCost());
            }
        }
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
        this.ways = new Way[0];
        if (ways != null){
            for (int i = 0; i < ways.length; i++){
                addWay(ways[i].getCityTo(), ways[i].getCost());
            }
        }
    }

    public void addWay(City cityTo, int cost){
        for (int i = 0; i < ways.length; i++){
            if (ways[i].getCityTo() == cityTo){
                ways[i] = new Way(cityTo, cost);      //дорога уже есть - обновляем стоимость
                return;
            }
        }
        Way [] arr = new Way[ways.length + 1];        //дороги нет - добавляем в конец
        for (int i = 0; i < ways.length; i++){
            arr[i] = ways[i];
        }
        arr[arr.length - 1] = new Way(cityTo, cost);
        ways = arr;
    }

    public void removeWay(City cityTo){
        int index = -1;
        for (int i = 0; i < ways.length; i++){
            if (ways[i].getCityTo() == cityTo){
                index = i;
            }
        }
        if (index == -1){
            return;                                   //такой дороги нет - удалять нечего
        }
        Way [] arr = new Way[ways.length - 1];        //повторов нет, значит удаляем ровно одну
        for (int i = 0; i < arr.length; i++){
            arr[i] = i < index ? ways[i] : ways[i + 1];   //после удалённой берём со сдвигом на 1
        }
        ways = arr;
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
