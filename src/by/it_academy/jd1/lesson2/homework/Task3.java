package by.it_academy.jd1.lesson2.homework;

import java.util.Scanner;

public class Task3 {

    public static void main(String[] args) {
        double a, b, c, x1, x2;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter coefficients of quadratic equation.");
        System.out.print("a: ");
        a = scanner.nextDouble();
        System.out.print("b: ");
        b = scanner.nextDouble();
        System.out.print("c: ");
        c = scanner.nextDouble();
        double discriminant = discriminant(a, b, c);

        if (isPositive(discriminant)) {
            x1 = (-b + Math.sqrt(discriminant)) / 2 * a;
            x2 = (-b - Math.sqrt(discriminant)) / 2 * a;
            System.out.println("This quadratic equation have two roots: x1= " + x1 + ", x2= " + x2);
        } else if (isZero(discriminant)) {
            x1 = (-b + Math.sqrt(discriminant)) / 2 * a;
            System.out.println("This quadratic equation have also one root: x1= " + x1);
        } else {
            System.out.println("This quadratic equation have no roots!!!");
        }
    }

    private static boolean isPositive(double value) {
        return value > 0;
    }

    private static boolean isZero(double value) {
        return value == 0;
    }

    private static double discriminant(double a, double b, double c) {
        return b * b - 4 * a * c;
    }

}
