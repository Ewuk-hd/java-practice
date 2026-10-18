package ru.komarov.buildings;

public class House {
    private final int floors;

    public House(int floors) {
        if (floors <= 0){
            throw new IllegalArgumentException("Количество этажей должно быть больше нуля: " + floors);
        }
        this.floors = floors;
    }

    public int getFloors() {
        return floors;
    }

    @Override
    public String toString() {
        String ending = (floors % 10 == 1 && floors % 100 != 11) ? "этажом" : "этажами";
        return "дом с " + floors + " " + ending;
    }
}
