package by.itacademy.jd1.lesson7.homework;

public class ShapeUtils {

    public static boolean isRectangle(Shape shape){
        boolean result = false;
        if (shape instanceof nAngle) {
            result = ((nAngle) shape).getNumberOfAngles() == 4;
        }
        return result;
    }

    public static boolean isTriangle(Shape shape) {
        boolean result = false;
        if (shape instanceof nAngle) {
            result = ((nAngle) shape).getNumberOfAngles() == 3;
        }
        return result;
    }
}
