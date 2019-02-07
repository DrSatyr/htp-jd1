package by.itacademy.jd1.lesson7.homework;

public class Triangle extends nAngle {

    private final String NAME = "Triangle";

    public Triangle(Point... vertexes) {
        super(vertexes);
        setName(NAME);
    }

    public double getHeightFromEdge(int EdgeNumber) {
        return 2 * getArea() / getEdgeLength(EdgeNumber);
    }
}
