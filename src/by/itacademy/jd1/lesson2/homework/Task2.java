package by.itacademy.jd1.lesson2.homework;

import java.util.Scanner;

public class Task2 {

    public static void main(String[] args) {

        int a, b, c, d, e, f;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter dimensions of the first house: ");
        System.out.print("a: ");
        a = scanner.nextInt();
        System.out.print("b: ");
        b = scanner.nextInt();

        System.out.println("Enter dimensions of the second house: ");
        System.out.print("c: ");
        c = scanner.nextInt();
        System.out.print("d: ");
        d = scanner.nextInt();

        System.out.println("Enter dimensions of the field: ");
        System.out.print("e: ");
        e = scanner.nextInt();
        System.out.print("f: ");
        f = scanner.nextInt();

        int firstHouseMinLength = findMinValue(a, b);
        int firstHouseMaxLength = findMaxValue(a, b);
        int secondHouseMinLength = findMinValue(c, d);
        int secondHouseMaxLength = findMaxValue(c, d);
        int maxHousesLength = findMaxValue(firstHouseMaxLength, secondHouseMaxLength);
        int fieldMinLength = findMinValue(e, f);
        int fieldMaxLength = findMaxValue(e, f);

        if (firstHouseMinLength + secondHouseMinLength <= fieldMinLength
                && maxHousesLength <= fieldMaxLength
                ||
                firstHouseMaxLength + firstHouseMinLength <= fieldMaxLength
                && findMaxValue(firstHouseMinLength, secondHouseMinLength) <= fieldMinLength) {
            System.out.println("This houses can be placed on this field!");
        } else {
            System.out.println("This houses can't be placed on this field");
        }
    }

    private static int findMinValue(int firstValue, int secondValue) {
        return firstValue < secondValue
                ? firstValue
                : secondValue;
    }

    private static int findMaxValue(int firstValue, int secondValue) {
        return firstValue > secondValue
                ? firstValue
                : secondValue;
    }

}
