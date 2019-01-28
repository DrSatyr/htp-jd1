package by.it_academy.jd1.lesson3.homework;

import java.util.Scanner;

public class Task3 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of days you want to analyze: ");
        int numberOfDays = scanner.nextInt();
        double value;
        double maxValue = 0;
        double averageValue = 0;
        double sum = 0;

        for (int i = 1; i <= numberOfDays; i++) {

            do {
                System.out.print("Enter precipitation level for " + i + " day: ");
                value = scanner.nextDouble();
                System.out.print(value < 0 ? "precipitation level cant be negative, please, try again. " : "");
            } while (value < 0);

            if (value > maxValue) {
                maxValue = value;
            }

            sum += value;
            averageValue = sum / i;
            System.out.println("STATUS: DAYS=" + i + " MAX=" + maxValue + " AVERAGE=" + averageValue + " SUM=" + sum);
        }

    }

}
