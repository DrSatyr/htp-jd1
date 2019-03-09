package by.itacademy.jd1.lesson18.homework;

import by.itacademy.jd1.common.utils.DayTimeUtils;
import lombok.AllArgsConstructor;
import lombok.Setter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@AllArgsConstructor
@Setter
public class ReportService {

    private List<Activity> data;

    public void generateScheduleReport(Path path) throws IOException {
        int currentDay = 1;
        List<String> strings = new ArrayList<>();
        for (Activity activity : data) {
            if (currentDay != activity.getDayNumber()) {
                strings.add("");
                currentDay++;
            }
            strings.add(DayTimeUtils.toString(activity.getBeginTime())
                    + "-" + DayTimeUtils.toString(activity.getEndTime())
                    + " " + activity.getActivity());
        }
        Files.write(path, strings);
    }

    public void generateDayReport(Path path, int day) throws IOException {
        List<Activity> oneDayData = getOneDay(day);
        List<Activity> regularActivity = getRegularActivity(oneDayData);
        List<Activity> lectureActivity = getLectureActivity(oneDayData);
        int totalTime = getTotalTime(oneDayData);
        int lectureTime = getTotalTime(lectureActivity);
        List<String> strings = new ArrayList<>();

        strings.add("Лекции : " + lectureTime + " минут " + (lectureTime * 100.0f) / totalTime + "%");
        Map<String, Integer> map = countUniqueActivityTime(regularActivity);
        map.forEach((key, value) -> strings.add(key + ": "
                + value + " минут " + (value * 100.0f) / totalTime + "%"));
        strings.add("");
        strings.add("Лекции:");
        lectureActivity.forEach(it -> strings.add(it.getActivity() + ": минут " + it.length()
                + " " + (it.length() * 100.0f) / totalTime + "%"));

        Files.write(path, strings);
    }

    private List<Activity> getOneDay(int day) {
        return data.stream()
                .filter(it -> it.getDayNumber() == day)
                .collect(Collectors.toList());
    }

    private List<Activity> getRegularActivity(List<Activity> data) {
        return data.stream()
                .filter(Activity::isRegular)
                .collect(Collectors.toList());
    }

    private List<Activity> getLectureActivity(List<Activity> data) {
        return data.stream()
                .filter(it -> !it.isRegular())
                .collect(Collectors.toList());
    }

    private Map<String, Integer> countUniqueActivityTime(List<Activity> data) {
        HashMap<String, Integer> map = new HashMap<>();
        data.forEach(it -> map.merge(it.getActivity(), it.length(), (prev, next) -> prev + next));
        return map;
    }

    private int getTotalTime(List<Activity> data) {
        return data.stream()
                .map(Activity::length)
                .reduce(0, (a, b) -> a + b);
    }
}
