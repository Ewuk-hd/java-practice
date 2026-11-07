package ru.komarov.geometry;

import java.util.Objects;

public class Line implements Measurable, Cloneable{
    private static final Point DEFAULT_POINT = new Point(0,0);
    private Point start;
    private Point end;

    public Line(int x1, int y1, int x2, int y2) {
        this.start = new Point(x1, y1);
        this.end = new Point(x2, y2);
    }

    public Line(Point start, Point end) {
        this(check(start).getX(), check(start).getY(), check(end).getX(), check(end).getY());
    }

    public Line(Line line){
        this(line.start, line.end);
    }

    private static Point check(Point point){
        if (point == null){
            return DEFAULT_POINT;
        }
        else return point;
    }


    public Point getEnd() {
        return new Point(end);
    }

    public void setEnd(Point end) {
        this.setEnd(check(end).getX(), check(end).getY());
    }

    public void setEnd(int x, int y){
        this.end = new Point(x, y);
    }

    public Point getStart() {
        return new Point(start);
    }

    public void setStart(Point start) {
        this.setStart(check(start).getX(), check(start).getY());
    }

    public void setStart(int x, int y){
        this.start = new Point(x, y);
    }

    @Override
    public Line clone() {
        try {
            Line copy = (Line) super.clone();
            copy.start = start.clone();
            copy.end = end.clone();
            return copy;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public double getLength(){
        int kat1 = getEnd().getX()-getStart().getX();
        int kat2 = getEnd().getY()-getStart().getY();
        double len = Math.sqrt(kat1*kat1 + kat2*kat2);
        return len;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Line line = (Line) o;
        return start.equals(line.start) && end.equals(line.end) || start.equals(line.end) && end.equals(line.start);
    }

    @Override
    public int hashCode() {
        return start.hashCode() + end.hashCode();
    }

    @Override
    public String toString() {
        return "Линия от " + start + " до " + end;
    }
}
