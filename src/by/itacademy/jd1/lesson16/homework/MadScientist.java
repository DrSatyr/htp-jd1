package by.itacademy.jd1.lesson16.homework;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class MadScientist {

    @Getter
    private String name;
    private Map<RobotParts, Integer> parts;

    public MadScientist(String name) {
        this.name = name;
        this.parts = new HashMap<>();
    }

    public void receivePart(RobotParts part) {
        parts.merge(part, 1, (prev, current) -> prev + current);
    }

    public int countRobots() {
        int result;
        if (parts.size() < RobotParts.size()) {
            result = 0;
        } else {
            Optional<Integer> count = parts.values().stream().min(Integer::compareTo);
            result = count.isPresent() ? count.get() : 0;
        }
        return result;
    }
}
