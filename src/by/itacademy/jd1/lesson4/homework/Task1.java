package by.itacademy.jd1.lesson4.homework;

import java.util.Arrays;

public class Task1 {

    public static void main(String[] args) {
        int[] array = Utils.interactiveIntArrayCreator();

        System.out.println("Your array is: " + Arrays.toString(array));
        arrayShifter(array);
        System.out.println("Shifted array is: " + Arrays.toString(array));
    }

    private static void arrayShifter(int[] array) {
        if (array.length > 2) {
            int firstElement = array[0];
            array[0] = array[array.length - 1];

            for (int i = array.length - 2; i > 0; i--) {
                array[i + 1] = array[i];
            }

            array[1] = firstElement;
        }
    }
}
