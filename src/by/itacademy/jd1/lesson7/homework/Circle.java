package by.itacademy.jd1.lesson7.homework;

public class Circle extends Shape {

    private final String NAME = "Circle";
    private Point center;
    private double radius;

    public Circle(Point center, double radius) {
        this.center = center;
        this.radius = radius;
        setName(NAME);
    }

    @Override
    public double getArea() {
        return Math.PI * Math.sqrt(radius);
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public String toString() {
        return "i'am a " + this.getName().toUpperCase() + "\n" +
                "my center is : " + this.getCenter().toString() + "\n" +
                "my radius is : " + this.getRadius() + "\n" +
                "my perimeter is : " + this.getPerimeter() + "\n" +
                "my area is : " + this.getArea();
    }

    public Point getCenter() {
        return center;
    }

    public double getRadius() {
        return radius;
    }
}
