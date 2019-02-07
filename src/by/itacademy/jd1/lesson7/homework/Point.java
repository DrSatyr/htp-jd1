package by.itacademy.jd1.lesson7.homework;

public class Point {
    private double x;
    private double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "(" + x + " : " + y + ")";
    }

    public double distanceTo(Point destination) {
        double a = Math.abs(destination.getX() - this.x);
        double b = Math.abs(destination.getY() - this.y);
        return Math.sqrt(a * a + b * b);
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }
}
