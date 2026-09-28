public class Way {
    City cityTo;
    int cost;

    public Way(City cityTo, int cost){
        this.cityTo = cityTo;
        this.cost = cost;
    }

    @Override
    public String toString(){
        return cityTo.name + ": " + cost;
    }
}
