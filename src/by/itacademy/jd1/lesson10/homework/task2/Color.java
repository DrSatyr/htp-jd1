package by.itacademy.jd1.lesson10.homework.task2;

public enum Color {

    WHITE("WHITE", "#FFFFFF"),
    SILVER("SILVER", "#C0C0C0"),
    GRAY("GRAY", "#808080"),
    BLACK("BLACK", "#000000"),
    MAROON("MAROON", "#800000"),
    YELLOW("YELLOW" ,"#FFFF00"),
    OLIVE("OLIVE" ,"#808000"),
    LIME("LIME", "#00FF00"),
    GREEN("GREEN", "#008000"),
    AQUA("AQUA", "#00FFFF"),
    TEAL("TEAL", "#008080"),
    BLUE("BLUE", "#0000FF"),
    NAVY("NAVY", "#000080"),
    FUCHSIA("FUCHSIA", "#FF00FF"),
    PURPLE("PURPLE", "#800080");

    private String name;
    private String hexCode;

    Color(String name, String hexCode) {
        this.name = name;
        this.hexCode = hexCode;
    }

    public String getHexCode() {
        return hexCode;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
