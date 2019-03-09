package by.itacademy.jd1.lesson18.homework;

import by.itacademy.jd1.common.utils.DayTimeUtils;
import lombok.Getter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParsingService {

    private Config config;
    private Path path;
    private int dayCounter = 1;
    @Getter
    private LinkedList<Activity> data = new LinkedList<>();

    public ParsingService(Config config, Path path) {
        this.config = config;
        this.path = path;
    }

    public ParsingService collectData() throws IOException {
        Pattern linePattern = Pattern.compile(config.LINE_REGEX);
        Files.lines(path)
                .map(linePattern::matcher)
                .filter(Matcher::find)
                .forEach(it -> addElement(it.group("activity"), it.group("time")));
        return this;
    }

    private void addElement(String activity, String time) {
        int minutesLeft = DayTimeUtils.parse(time);

        if (!data.isEmpty() && data.getLast().getDayNumber() == dayCounter) {
            data.getLast().setEndTime(minutesLeft);
        }
        if (activity.matches(config.END_OF_DAY_REGEX)) {
            dayCounter++;
        } else {
            data.add(
                    Activity.builder()
                            .dayNumber(dayCounter)
                            .activity(activity)
                            .beginTime(minutesLeft)
                            .regular(activity.matches(config.REGULAR_ACTIVITY_REGEX))
                            .build()
            );
        }
    }
}
