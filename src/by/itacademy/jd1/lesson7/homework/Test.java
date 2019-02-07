package by.itacademy.jd1.lesson7.homework;

public class Test {

    public static void main(String[] args) {
        nAngle nAngle = new nAngle(new Point(0, 0), new Point(10, 10), new Point(20, 0));
        Rectangle rectangle = new Rectangle(new Point(0, 0), new Point(10, 5));
        Square square = new Square(new Point(0, 0), 5);
        Triangle triangle = new Triangle(new Point(0, 0), new Point(10, 10), new Point(20, 0));
        Circle circle = new Circle(new Point(10, 5), 30);

        shapePresentation(nAngle, rectangle, square, triangle, circle);
        ownMethodsDemonstration(rectangle, square, triangle);
        shapeUtilsDemonstration(square, triangle);
        areaEqualsDemonstration(square, triangle);
    }

    public static void shapePresentation(FlatShape... shapes) {
        System.out.println("Демонстрация обьектов фигур: \n");
        for (FlatShape shape : shapes) {
            System.out.println(shape + "\n");
        }
    }

    public static void ownMethodsDemonstration(Rectangle rectangle, Square square, Triangle triangle) {
        System.out.println("Демонстрация работы собственных методов в классах наследниках: \n");
        System.out.println("Диагональ " + rectangle.getName() + " = " + rectangle.getDiagonal());
        System.out.println("Площадь " + square.getName() + " = " + square.getDiagonal());
        System.out.println("Высота " + triangle.getName() + " из 3ей стороны = " + triangle.getHeightFromEdge(3));
        System.out.println();
    }

    public static void shapeUtilsDemonstration(Square square, Triangle triangle) {
        System.out.println("Демонстрация работы ShapeUtils: \n");
        System.out.println("Квадрат является треугольником?: " + ShapeUtils.isTriangle(square));
        System.out.println("Треугольник является треугольником?: " + ShapeUtils.isTriangle(triangle));
        System.out.println("Треугольник является прямоугольником?: " + ShapeUtils.isRectangle(triangle));
        System.out.println("Квадрат является прямоугольником?: " + ShapeUtils.isRectangle(square));
        System.out.println();
    }

    public static void areaEqualsDemonstration(Square square, Triangle triangle) {
        System.out.println("Демонстрация метода сравнения фигур по площади: \n");
        System.out.println("Sтреуг. = Sквадр. :" + triangle.isAreaEquals(square));
        System.out.println("Sтреуг. = Sтреуг. :" + triangle.isAreaEquals(triangle));
    }
}
