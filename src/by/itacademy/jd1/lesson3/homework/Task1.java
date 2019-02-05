package by.itacademy.jd1.lesson3.homework;

import java.util.Scanner;

public class Task1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int userNumber;
        int sum = 0;

        System.out.print("Enter some Int number: ");
        userNumber = scanner.nextInt();

        while (userNumber / 10 != 0 || userNumber % 10 != 0) {
            sum += userNumber % 10;
            userNumber /= 10;
        }

        System.out.println("Sum of digits is: " + sum);
    }

}
