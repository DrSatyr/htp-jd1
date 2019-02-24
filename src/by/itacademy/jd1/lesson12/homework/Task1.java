package by.itacademy.jd1.lesson12.homework;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

public class Task1 {

    public static void main(String[] args) {
        TextFileService textFileService = new TextFileService();
        Path source = Paths.get("assets", "lesson12", "poem.txt");
        Path destination1 = Paths.get("assets", "lesson12", "task1-result1.txt");
        Path destination2 = Paths.get("assets", "lesson12", "task1-result2.txt");

        try {
            Map<Character, Integer> letters = textFileService.countLetters(source);
            textFileService.exportMapToFile(letters, destination1);
        } catch (IOException | SecurityException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            Map<Character, Integer> letters2 = textFileService.countLettersFuncStyle(source);
            textFileService.exportMapToFile(letters2, destination2);
        } catch (IOException | SecurityException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
