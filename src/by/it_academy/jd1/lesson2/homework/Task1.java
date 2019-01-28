package by.it_academy.jd1.lesson2.homework;

import java.util.Scanner;

public class Task1 {

    public static void main(String[] args) {

        int year, month, day;
        Scanner in = new Scanner(System.in);

        System.out.println("Please, input Year, Month and Day step by step:");
        System.out.print("Year: ");
        year = in.nextInt();
        System.out.print("Month: ");
        month = in.nextInt();
        System.out.print("Day: ");
        day = in.nextInt();

        if (isDateCorrect(year, month, day)) {

            if (day < NumberOfDaysInMonth(month, year)) {
                day++;
            } else if (month == 12) {
                day = 1;
                month = 1;
                year++;
            } else {
                day = 1;
                month++;
            }
            System.out.println("Next day is: " + dateFormat(year, month, day));

        } else {
            System.out.println("You have entered invalid date! Please, try again.");
        }

    }

    private static boolean isDateCorrect(int year, int month, int day) {
        boolean result = true;

        if (year < 0) {
            result = false;
        } else if (month > 12 || month < 0) {
            result = false;
        } else if (day > NumberOfDaysInMonth(month, year)) {
            result = false;
        }

        return result;
    }

    private static int NumberOfDaysInMonth(int month, int year) {
        int days;

        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                days = 31;
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                days = 30;
                break;
            case 2:
                days = isLeapYear(year) ? 29 : 28;
                break;
            default:
                days = 0;
                break;
        }

        return days;
    }

    private static boolean isLeapYear(int year) {
        return (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0));
    }

    private static String dateFormat(int year, int month, int day) {
        return String.format("%02d.%02d.%04d", day, month, year);
    }

}
