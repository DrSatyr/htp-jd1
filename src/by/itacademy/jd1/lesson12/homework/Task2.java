package by.itacademy.jd1.lesson12.homework;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Task2 {

    private static final int SIZE = 1000;
    private static final int RANDOM_RANGE = 1000;

    public static void main(String[] args) {

        Path destination = Paths.get("assets", "lesson12", "task2.txt");
        TextFileService textFileService = new TextFileService();

        List<Integer> values = new ArrayList<>(SIZE);
        for (int i = 0; i < SIZE; i++) {
            values.add(new Random().nextInt(RANDOM_RANGE));
        }

        try {
            textFileService.fillWithDelimiter(destination, values);
            textFileService.sort(destination);
        } catch (IOException | SecurityException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
