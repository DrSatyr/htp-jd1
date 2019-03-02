package by.itacademy.jd1.lesson16.homework;

public enum RobotParts {

    HEAD,
    LEFT_HAND,
    RIGHT_HAND,
    LEFT_LAG,
    RIGHT_LAG,
    RAM,
    HDD,
    CPU;

    public static int size(){
        return RobotParts.values().length;
    }
}
