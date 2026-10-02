public class Way {
    private final City cityTo;
    private final int cost;

    public Way(City cityTo, int cost){
        if (cityTo == null){
            throw new IllegalArgumentException("Город назначения не указан");
        }
        if (cost < 0){
            throw new IllegalArgumentException("Стоимость не может быть отрицательной: " + cost);
        }
        this.cityTo = cityTo;
        this.cost = cost;
    }

    public City getCityTo(){
        return cityTo;
    }

    public int getCost(){
        return cost;
    }

    @Override
    public String toString(){
        return cityTo.getName() + ": " + cost;
    }
}
