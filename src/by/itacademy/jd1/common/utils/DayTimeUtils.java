package by.itacademy.jd1.common.utils;

import lombok.experimental.UtilityClass;

import java.util.regex.Pattern;

@UtilityClass
public class DayTimeUtils {

    public final String SPLITTER = ":";
    public final String REGEX = "(([0,1][0-9])|(2[0-3])):[0-5][0-9]";
    public static final int TIME_DIVIDER = 60;

    public int parse(String input) {
        int result = -1;
        if (Pattern.matches(REGEX, input)) {
            String[] inputs = input.split(SPLITTER);
            result = Integer.valueOf(inputs[0]) * TIME_DIVIDER + Integer.valueOf(inputs[1]);
        }
        return result;
    }

    public String toString(int input) {
        int hours = input / TIME_DIVIDER;
        int minutes = input - hours * TIME_DIVIDER;
        return String.format("%02d:%02d", hours, minutes);
    }
}
