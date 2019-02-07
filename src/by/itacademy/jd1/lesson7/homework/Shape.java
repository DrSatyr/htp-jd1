package by.itacademy.jd1.lesson7.homework;

public abstract class Shape implements FlatShape {

    private String name;

    public boolean isAreaEquals(Shape shape) {
        return this.getArea() == shape.getArea();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
