package by.itacademy.jd1.lesson3.homework;

import java.util.Scanner;

public class Task2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter limit value for Fibonacci series: ");
        int limitValue = scanner.nextInt();

        System.out.println("This output uses Fibonacci function with \"while\" loop:");
        System.out.println(fibonacci(limitValue));
        System.out.println("This output uses printFibonacciRec function with recursion:");
        fibonacciRec(0, 1, limitValue);

    }

    private static String fibonacci(int limitValue) {
        String result = "";

        if (limitValue > 0) {
            int preLastNumber = 0;
            int lastNumber = 1;
            int temp;
            result = "0";

            while (lastNumber < limitValue) {
                result += " " + lastNumber;
                temp = lastNumber;
                lastNumber += preLastNumber;
                preLastNumber = temp;
            }
        }
        return result;
    }

    private static void fibonacciRec(int preLastNumber, int lastNumber, int limitValue) {

        if (lastNumber < limitValue) {
            if (preLastNumber == 0) {
                System.out.print("0");
            }
            System.out.print(" " + lastNumber);
            int temp = lastNumber;
            lastNumber += preLastNumber;
            preLastNumber = temp;
            fibonacciRec(preLastNumber, lastNumber, limitValue);
        }
        
    }
}