package by.itacademy.jd1.lesson5.homework;

import java.util.Arrays;

public class Task2 {

    public static void main(String[] args) {
        String romanString = "MMMCMXCIX";
        int result;

        System.out.println("Demonstration of the \"convertRomanToArabian1\" method: ");
        result = convertRomanToArabian1(romanString);
        System.out.println(result >= 0
                ? result
                : romanString + " it is not a valid roman number");

        System.out.println("Demonstration of the \"convertRomanToArabian2\" method: ");
        result = convertRomanToArabian2(romanString);
        System.out.println(result);
    }

    /**
     * Convert roman value to the arabian.
     *
     * @param value
     * @return if "value" parameter is valid roman Number - return converted arabian,
     * else - "-1" meaning that the "value" - is invalid roman Number.
     */
    public static int convertRomanToArabian1(String value) {
        String[] romanLiterals = {"C", "CD", "CM", "D", "I", "IV", "IX", "L", "M",
                "V", "X", "XC", "XL"}; //sorted for binarySearch
        int[] romanValues = {100, 400, 900, 500, 1, 4, 9, 50, 1000, 5, 10, 90, 40};
        boolean valueIsValid = value.length() > 0;
        int result = 0;
        int searchIndex;
        value = value.toUpperCase();

        while (value.length() > 0) {

            searchIndex = value.length() > 1
                    ? Arrays.binarySearch(romanLiterals, value.substring(0, 2))
                    : -1;
            if (searchIndex >= 0) {
                result += romanValues[searchIndex];
                value = value.substring(2);
                continue;
            }

            searchIndex = Arrays.binarySearch(romanLiterals, value.substring(0, 1));
            if (searchIndex >= 0) {
                result += romanValues[searchIndex];
                value = value.substring(1);
                continue;
            }

            valueIsValid = false;
            break;
        }
        return valueIsValid ? result : -1;
    }

    /**
     * Convert roman value to the arabian. Accepts only VALID roman numbers before 3999.
     * Please, check your input before use this method!
     *
     * @param romanString
     * @return arabian int value
     */
    public static int convertRomanToArabian2(String romanString) {
        int result = 0;
        romanString = romanString.toUpperCase();

        while (romanString.length() > 0) {

            if (romanString.startsWith("M")) {
                result += 1000;
                romanString = romanString.substring(1);
            }
            if (romanString.startsWith("CM")) {
                result += 900;
                romanString = romanString.substring(2);
            }
            if (romanString.startsWith("D")) {
                result += 500;
                romanString = romanString.substring(1);
            }
            if (romanString.startsWith("CD")) {
                result += 400;
                romanString = romanString.substring(2);
            }
            if (romanString.startsWith("C")) {
                result += 100;
                romanString = romanString.substring(1);
            }
            if (romanString.startsWith("XC")) {
                result += 90;
                romanString = romanString.substring(2);
            }
            if (romanString.startsWith("L")) {
                result += 50;
                romanString = romanString.substring(1);
            }
            if (romanString.startsWith("XL")) {
                result += 40;
                romanString = romanString.substring(2);
            }
            if (romanString.startsWith("X")) {
                result += 10;
                romanString = romanString.substring(1);
            }
            if (romanString.startsWith("IX")) {
                result += 9;
                romanString = romanString.substring(2);
            }
            if (romanString.startsWith("V")) {
                result += 5;
                romanString = romanString.substring(1);
            }
            if (romanString.startsWith("IV")) {
                result += 4;
                romanString = romanString.substring(2);
            }
            if (romanString.startsWith("I")) {
                result += 1;
                romanString = romanString.substring(1);
            }
        }
        return result;
    }
}