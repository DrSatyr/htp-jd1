package by.itacademy.jd1.lesson7.homework;

public class nAngle extends Shape {

    private static final String NAME = "N-Angle";

    private Point[] vertexes;

    public nAngle(Point... vertexes) {
        setName(NAME);
        this.vertexes = new Point[vertexes.length];
        for (int i = 0; i < vertexes.length; i++) {
            this.vertexes[i] = vertexes[i];
        }
    }

    /**
     * Implements algorithm for getting area of polygon known as "Heron's formula"
     *
     * @return - area double
     */
    @Override
    public double getArea() {
        double halfPerimeter = getHalfPerimeter();
        double result = halfPerimeter;
        for (int i = 1; i <= getNumberOfAngles(); i++) {
            result *= halfPerimeter - getEdgeLength(i);
        }
        return Math.sqrt(result);
    }

    @Override
    public double getPerimeter() {
        double perimeter = vertexes[0].distanceTo(vertexes[vertexes.length - 1]);
        for (int i = 1; i < vertexes.length; i++) {
            perimeter += vertexes[i].distanceTo(vertexes[i - 1]);
        }
        return perimeter;
    }

    @Override
    public String toString() {
        return "i'am a " + this.getName().toUpperCase() + "\n" +
                "I have " + this.getNumberOfAngles() + " angles\n" +
                "my perimeter is : " + this.getPerimeter() + "\n" +
                "my area is : " + this.getArea();
    }

    public double getEdgeLength(int edgeNumber) {
        double result = -1;
        if (edgeNumber > 0 && edgeNumber <= vertexes.length) {
            result = edgeNumber != vertexes.length
                    ? vertexes[edgeNumber - 1].distanceTo(vertexes[edgeNumber])
                    : vertexes[0].distanceTo(vertexes[edgeNumber - 1]);
        }
        return result;
    }

    public int getNumberOfAngles() {
        return vertexes.length;
    }

    public Point[] getVertexes() {
        return vertexes;
    }

    private double getHalfPerimeter() {
        return getPerimeter() / 2;
    }
}
