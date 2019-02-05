package by.itacademy.jd1.lesson6.homework;

public class Point {
    private double x;
    private double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public Point setX(double x) {
        this.x = x;
        return this;
    }

    public Point setY(double y) {
        this.y = y;
        return this;
    }

    public double distanceTo(Point destination) {
        double a = Math.abs(destination.getX() - this.x);
        double b = Math.abs(destination.getY() - this.y);
        return Math.sqrt(a * a + b * b);
    }
}
