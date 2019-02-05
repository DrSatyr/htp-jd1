package by.itacademy.jd1.lesson5.homework;

import java.util.Scanner;

public class Task1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter string to check: ");
        String str = scanner.next();
        System.out.println(isPalindrome(str) ? "This string is a palindrome"
                                             : "This string is not a palindrome");
    }

    public static boolean isPalindrome(String str) {
        return str.equalsIgnoreCase(new StringBuilder(str).reverse().toString());
    }
}
