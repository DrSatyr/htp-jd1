package by.itacademy.jd1.lesson4.homework;

import java.util.Arrays;

public class Task4 {

    public static void main(String[] args) {
        int[][] array = {{1, 2, 3}, {1, 2}, {1}};

        System.out.println("Original two-dimensional array is: ");
        for (int i = 0; i < array.length; i++) {
            System.out.println(Arrays.toString(array[i]));
        }
        System.out.println("Linearized array is: ");
        System.out.println(Arrays.toString(linearize(array)));
    }

    public static int[] linearize(int[][] originalArray) {
        int[] resultArray;
        int resultArrayIndex = 0;
        int resultArrayLength = 0;

        for (int i = 0; i < originalArray.length; i++) {
            resultArrayLength += originalArray[i].length;
        }
        resultArray = new int[resultArrayLength];

        for (int i = 0; i < originalArray.length; i++) {
            for (int j = 0; j < originalArray[i].length; j++) {
                resultArray[resultArrayIndex++] = originalArray[i][j];
            }
        }
        return resultArray;
    }
}