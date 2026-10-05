import java.util.ArrayList;

public class City {
    private String name;
    private ArrayList<Way> ways;

    public City(String name, Way... ways){
        this.name = name;
        this.ways = new ArrayList<>();
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

    public ArrayList<Way> getWays(){
        return new ArrayList<>(ways);
    }

    public void setWays(Way... ways){
        this.ways = new ArrayList<>();
        if (ways != null){
            for (int i = 0; i < ways.length; i++){
                addWay(ways[i].getCityTo(), ways[i].getCost());
            }
        }
    }

    public void addWay(City cityTo, int cost){
        for (int i = 0; i < ways.size(); i++){
            if (ways.get(i).getCityTo() == cityTo){
                ways.set(i, new Way(cityTo, cost));
                return;
            }
        }
        ways.add(new Way(cityTo, cost));
    }

    public void removeWay(City cityTo){
        for (int i = 0; i < ways.size(); i++){
            if (ways.get(i).getCityTo() == cityTo){
                ways.remove(i);
                return;
            }
        }
    }

    @Override
    public String toString(){
        return name + " " + ways;
    }
}
