package by.it_academy.jd1.lesson6.homework;

public class Rectangle {
    private Point leftUpper;
    private Point rightLower;

    public Rectangle(Point leftUpper, Point rightLowerCorner) {
        this.leftUpper = leftUpper;
        this.rightLower = rightLowerCorner;
    }

    public double square() {
        return Math.abs(leftUpper.getY() - rightLower.getY())
                * Math.abs(rightLower.getX() - leftUpper.getX());
    }

    public double diagonal() {
        return leftUpper.distanceTo(rightLower);
    }
}
