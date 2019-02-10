package by.itacademy.jd1.lesson9.homework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

public class Task1 {

    public static void main(String[] args) {
        List<String> strings = new ArrayList<>(Arrays.asList(
                "this", "is", "lots", "of", "fun", "for", "every", "Java", "programmer"));

        System.out.println("initial list: " + strings);
        markLength4(strings);
        System.out.println("Marked list: " + strings);
    }

    public static void markLength4(List<String> strings) {
        ListIterator<String> iterator = strings.listIterator(strings.size());
        while (iterator.hasPrevious()) {
            if (iterator.previous().length() == 4) {
                iterator.add("****");
                iterator.previous();
            }
        }
    }
}
