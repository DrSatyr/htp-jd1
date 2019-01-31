package by.it_academy.jd1.lesson4.homework;

import java.util.Arrays;

public class Task2 {

    public static void main(String[] args) {
        int[] array = Utils.interactiveIntArrayCreator();
        int[] resultArray;

        System.out.println("Your array is: " + Arrays.toString(array));
        resultArray = cleanDuplicates(array);
        System.out.println("Cleaned array is: " + Arrays.toString(resultArray));

    }

    private static int[] cleanDuplicates(int[] array) {
        int[] resultArray;
        int unique = 1;
        int resultArrayIndex = 1;

        if (array.length > 1) {
            Arrays.sort(array);

            for (int i = 1; i < array.length; i++) {
                if (array[i] != array[i - 1]) {
                    unique++;
                }
            }

            resultArray = new int[unique];
            resultArray[0] = array[0];

            for (int i = 1; i < array.length; i++) {
                if (array[i] != array[i - 1]) {
                    resultArray[resultArrayIndex++] = array[i];
                }
            }

        } else {
            resultArray = array;
        }
        return resultArray;
    }
}