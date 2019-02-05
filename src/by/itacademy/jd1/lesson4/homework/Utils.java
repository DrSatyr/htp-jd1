package by.itacademy.jd1.lesson4.homework;

import java.util.Scanner;

public class Utils {

    public static int[] interactiveIntArrayCreator(){

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter length of array: ");
        int arrayLength = scanner.nextInt();
        int[] array = new int[arrayLength];
        System.out.println("Enter each element of the array step by step: ");
        for (int i = 0; i < arrayLength; i++) {
            System.out.print(i + 1 + " element: ");
            array[i] = scanner.nextInt();
        }
        return array;

    }

}
