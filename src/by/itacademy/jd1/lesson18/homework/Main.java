package by.itacademy.jd1.lesson18.homework;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Path logPath = Paths.get("assets", "lesson18", "log.txt");
        Path reportPath1 = Paths.get("assets", "Lesson18", "ScheduleReport.txt");
        Path reportPath2 = Paths.get("assets", "Lesson18", "1DayReport.txt");
        Path reportPath3 = Paths.get("assets", "Lesson18", "2DayReport.txt");
        Path reportPath4 = Paths.get("assets", "Lesson18", "3DayReport.txt");
        Path reportPath5 = Paths.get("assets", "Lesson18", "4DayReport.txt");

        ParsingService parsingService = new ParsingService(Config.TXT, logPath);
        List<Activity> data = null;
        try {
            data = parsingService.collectData().getData();
        } catch (IOException e) {
            e.printStackTrace();
        }

        ReportService reportService = new ReportService(data);
        try {
            reportService.generateScheduleReport(reportPath1);
            reportService.generateDayReport(reportPath2, 1);
            reportService.generateDayReport(reportPath3, 2);
            reportService.generateDayReport(reportPath4, 3);
            reportService.generateDayReport(reportPath5, 4);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
