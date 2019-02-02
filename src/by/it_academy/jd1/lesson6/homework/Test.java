package by.it_academy.jd1.lesson6.homework;

public class Test {

    public static void main(String[] args) {
        Point point1 = new Point(-10, 10);
        Point point2 = new Point(10, -10);
        Rectangle rectangle = new Rectangle(point1, point2);
        System.out.println("Square of this rectangle is: " + rectangle.square());
        System.out.println("Diagonal length of this rectangle is: " + rectangle.diagonal());
    }
}
