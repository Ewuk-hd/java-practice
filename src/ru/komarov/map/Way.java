package ru.komarov.map;

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
    public boolean equals(Object o) {
        if (o == null) return false;
        if (this == o) return true;
        if (getClass() != o.getClass()) return false;
        Way way = (Way) o;
        return cityTo == way.cityTo;   //стоимость не важна; == чтобы города не сравнивали друг друга по кругу
    }

    @Override
    public int hashCode() {
        return cityTo.getName() == null ? 0 : cityTo.getName().hashCode();
    }

    @Override
    public String toString(){
        return cityTo.getName() + ": " + cost;
    }
}
