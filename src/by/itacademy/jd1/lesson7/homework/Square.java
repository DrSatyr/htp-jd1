package by.itacademy.jd1.lesson7.homework;

public class Square extends Rectangle {

    private final String NAME = "Square";

    public Square(Point lowerLeftVertex, double edgeLength) {
        super(lowerLeftVertex, new Point(lowerLeftVertex.getX() + edgeLength,
                lowerLeftVertex.getY() + edgeLength));
        setName(NAME);
    }
}
