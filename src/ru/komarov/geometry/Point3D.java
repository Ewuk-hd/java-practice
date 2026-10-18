package ru.komarov.geometry;

public final class Point3D extends Point {

    public Point3D(int x, int y, int z){
        super(x, y);
        coords = new int[3];
        coords[0] = x;
        coords[1] = y;
        coords[2] = z;
    }

    public Point3D(Point point){
        super(point);
        int[] src = point.getPoints();
        coords = new int[3];
        coords[0] = src[0];
        coords[1] = src[1];
        coords[2] = src.length > 2 ? src[2] : 0;
    }

    public int getZ() {
        return coords[2];
    }

    public void setZ(int z) {
        coords[2] = z;
    }
}
