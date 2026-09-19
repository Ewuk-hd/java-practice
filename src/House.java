public class House {
    int floors;

    public House(int floors) {
        this.floors = floors;
    }

    public String toString() {
        String ending = (floors % 10 == 1 && floors % 100 != 11) ? "этажом" : "этажами";
        return "дом с " + floors + " " + ending;
    }
}
