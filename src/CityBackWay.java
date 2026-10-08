import java.util.ArrayList;

public class CityBackWay extends City {

    public CityBackWay(String name, Way... ways){
        super(name, ways);
    }

    @Override
    public void addWay(City cityTo, int cost){
        super.addWay(cityTo, cost);
        if (!hasWay(cityTo, this, cost)){
            cityTo.addWay(this, cost);
        }
    }

    private static boolean hasWay(City from, City to, int cost){
        ArrayList<Way> ways = from.getWays();
        for (int i = 0; i < ways.size(); i++){
            if (ways.get(i).getCityTo() == to && ways.get(i).getCost() == cost){
                return true;
            }
        }
        return false;
    }
}
