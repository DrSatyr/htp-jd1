package by.itacademy.jd1.lesson7.homework;

public class Rectangle extends nAngle implements hasDiagonal {

    private final String NAME = "Rectangle";

    public Rectangle(Point lowerLeftVertex, Point UpperRightVertex) {
        super(lowerLeftVertex,
                new Point(lowerLeftVertex.getX(), UpperRightVertex.getY()),
                UpperRightVertex,
                new Point(UpperRightVertex.getX(), lowerLeftVertex.getY()));
        setName(NAME);
    }

    public double getDiagonal() {
        Point[] vertexes = getVertexes();
        return vertexes[0].distanceTo(vertexes[2]);
    }
}
