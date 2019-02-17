package by.itacademy.jd1.lesson10.homework;

import java.util.HashMap;
import java.util.Map;

public class Task1 {

    public static void main(String[] args) {
        String text = "All the efforts of several hundred thousand people, crowded in a small space, " +
                "to disfigure the land on which they lived; all the stone they covered it with to keep " +
                "it barren; how so diligently every sprouting blade of grass was removed; all the smoke " +
                "of coal and naphtha; all the cutting down of trees and driving off of cattle could not " +
                "shut out the spring, even from the city. The sun was shedding its light; the grass, " +
                "revivified, was blooming forth, where it was left uncut, not only on the greenswards " +
                "of the boulevard, but between the flag-stones, and the birches, poplars and wild-berry " +
                "trees were unfolding their viscous leaves; the limes were unfolding their buds; the daws, " +
                "sparrows and pigeons were joyfully making their customary nests, and the flies were buzzing " +
                "on the sun-warmed walls.";

        System.out.println(countUniqueWords(text));
    }

    public static Map<String, Integer> countUniqueWords(String text) {
        String[] words = text.replaceAll("[!?,.;]", "").split(" "); // TODO: RegEx can be better!
        Map<String, Integer> uniqueWords = new HashMap<>();
        for (String word : words) {
            if (!uniqueWords.containsKey(word)) {
                uniqueWords.put(word, 1);
            } else {
                uniqueWords.put(word, uniqueWords.get(word) + 1);
            }
        }
        return uniqueWords;
    }
}
