package ru.komarov.geometry;

public sealed class Point implements Cloneable permits Point3D {
    protected int[] coords;

    public Point(int x, int y) {
        coords = new int[2];
        coords[0] = x;
        coords[1] = y;
    }

    public Point(Point point){
        int[] src = point.getPoints();
        coords = new int[2];
        coords[0] = src[0];
        coords[1] = src[1];
    }

    public int getX() {
        return coords[0];
    }

    public void setX(int x) {
        coords[0] = x;
    }

    public int getY() {
        return coords[1];
    }

    public void setY(int y) {
        coords[1] = y;
    }

    public int[] getPoints(){
        int[] copy = new int[coords.length];
        for (int i = 0; i < coords.length; i++){
            copy[i] = coords[i];
        }
        return copy;
    }

    @Override
    public Point clone() {
        try {
            Point copy = (Point) super.clone();
            copy.coords = new int[coords.length];
            for (int i = 0; i < coords.length; i++) {
                copy.coords[i] = coords[i];
            }
            return copy;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    @Override
    public String toString() {
        String result = "{";
        for (int i = 0; i < coords.length ; i++) {
            if(i < coords.length - 1){
                result += coords[i] + "; ";
            }
            else{
                result += coords[i];
            }
        }
        result += "}";
        return result;
    }
}
