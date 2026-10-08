import java.util.ArrayList;

public class FeaturePoint {
    private final ArrayList<Integer> coords;
    private final ArrayList<Property> properties;

    public FeaturePoint(int... coords){
        if (coords == null || coords.length < 1 || coords.length > 3){
            throw new IllegalArgumentException("Координат должно быть от 1 до 3");
        }
        this.coords = new ArrayList<>();
        for (int i = 0; i < coords.length; i++){
            this.coords.add(coords[i]);
        }
        this.properties = new ArrayList<>();
    }

    public void addProperty(Property property){
        if (property != null){
            properties.add(property);
        }
    }

    public ArrayList<Integer> getCoords(){
        return new ArrayList<>(coords);
    }

    public ArrayList<Property> getProperties(){
        return new ArrayList<>(properties);
    }

    @Override
    public String toString(){
        String result = "Точка {";
        for (int i = 0; i < coords.size(); i++){
            if (i > 0){
                result += ";";
            }
            result += coords.get(i);
        }
        result += "}";
        for (int i = 0; i < properties.size(); i++){
            result += ", " + properties.get(i);
        }
        return result;
    }
}
