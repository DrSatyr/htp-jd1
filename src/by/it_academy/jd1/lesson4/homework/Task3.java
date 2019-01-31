package by.it_academy.jd1.lesson4.homework;

import java.util.Arrays;

public class Task3 {

    public static void main(String[] args) {
        int[] array1 = Utils.interactiveIntArrayCreator();
        int[] array2 = Utils.interactiveIntArrayCreator();

        System.out.println("First array is: " + Arrays.toString(array1));
        System.out.println("Second array is: " + Arrays.toString(array2));
        System.out.println("Merged array is: " + Arrays.toString(mergeArrays(array1, array2)));
    }

    public static int[] mergeArrays(int[] array1, int[] array2) {
        int[] lessArray = array1.length <= array2.length ? array1 : array2;
        int[] largerArray = array1.length <= array2.length ? array2 : array1;
        int[] mergedArray = new int[array1.length + array2.length];
        int mergedArrayIndex = 0;

        for (int i = 0; i < largerArray.length; i++) {
            mergedArray[mergedArrayIndex++] = largerArray[i];
            if (lessArray.length > i) {
                mergedArray[mergedArrayIndex++] = lessArray[i];
            }
        }
        return mergedArray;
    }
}
