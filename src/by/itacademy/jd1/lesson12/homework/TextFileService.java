package by.itacademy.jd1.lesson12.homework;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class TextFileService {

    public Map<Character, Integer> countLetters(Path path) throws IOException {
        Map<Character, Integer> letters = new HashMap<>();
        try (Reader reader = new BufferedReader(new FileReader(path.toFile()))) {
            int current;
            while ((current = reader.read()) > 0) {
                char currentChar = Character.toUpperCase((char) current);
                if (Character.isLetter(currentChar)) {
                    letters.merge(Character.toUpperCase(currentChar), 1, (oldValue, value) -> oldValue + value);
                }
            }
            return letters;
        }
    }

    public Map<Character, Integer> countLettersFuncStyle(Path path) throws IOException {
        Map<Character, Integer> letters = new HashMap<>();
        try (Stream<String> stringStream = Files.lines(path)) {
            stringStream
                    .flatMapToInt(CharSequence::chars)
                    .mapToObj(it -> (char) it)
                    .filter(Character::isLetter)
                    // TODO: 23.02.2019 why commented line is not compiled?
                    //.collect(Collectors.toMap(Character::toUpperCase, 1, (oldValue, value) -> oldValue + value));
                    .forEach(it -> letters.merge(Character.toUpperCase(it), 1, (oldValue, value) -> oldValue + value));
            return letters;
        }
    }

    public <K, V> void exportMapToFile(Map<K, V> map, Path path) throws IOException, SecurityException {
        checkPath(path);
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path.toFile()))) {
            for (Map.Entry<K, V> entry : map.entrySet()) {
                bufferedWriter.append(entry.getKey() + " - " + entry.getValue());
                bufferedWriter.newLine();
            }
        }
    }

    public <T> void fillWithDelimiter(Path path, Collection<T> values, char delimiter) throws SecurityException, IOException {
        checkPath(path);
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path.toFile()))) {
            Iterator<T> iterator = values.iterator();
            while (iterator.hasNext()) {
                bufferedWriter.append(iterator.next().toString());
                if (iterator.hasNext()) {
                    bufferedWriter.append(delimiter);
                }
            }
        }
    }

    public <T> void fillWithDelimiter(Path path, Collection<T> values) throws SecurityException, IOException {
        fillWithDelimiter(path, values, ',');
    }

    public List<String> readWithDelimiter(Path path, char delimiter) throws IOException {
        List<String> result = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path.toFile()))) {
            StringBuilder currentStr = new StringBuilder();
            int currentChar;
            while ((currentChar = bufferedReader.read()) != -1) {
                if ((char) currentChar != delimiter) {
                    currentStr.append((char) currentChar);
                } else {
                    result.add(currentStr.toString());
                    currentStr = new StringBuilder();
                }
            }
            result.add(currentStr.toString());
        }
        return result;
    }

    public List<String> readWithDelimiter(Path path) throws IOException {
        return readWithDelimiter(path, ',');
    }

    public void sort(Path path, char delimiter) throws SecurityException, IOException {
        List<String> values = readWithDelimiter(path, delimiter);
        Collections.sort(values);
        fillWithDelimiter(path, values, delimiter);
    }

    public void sort(Path path) throws SecurityException, IOException {
        sort(path, ',');
    }

    public boolean checkPath(Path path) throws SecurityException {
        return path.getParent().toFile().mkdirs();
    }
}
