package by.itacademy.jd1.lesson18.homework;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum Config {

    TXT(
            "(?<time>(([0,1][0-9])|(2[0-3])):[0-5][0-9]) (?<activity>.+)",
            "(Упражнения|Перерыв|Обеденный перерыв|Лабораторная работа|Экзамен)",
            "Конец"
    );

    public final String LINE_REGEX;
    public final String REGULAR_ACTIVITY_REGEX;
    public final String END_OF_DAY_REGEX;
}
