package by.itacademy.jd1.lesson18.homework;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Activity {

    private int dayNumber;
    private int beginTime;
    private int endTime;
    private String activity;
    private boolean regular;

    public int length() {
        return endTime - beginTime;
    }
}
