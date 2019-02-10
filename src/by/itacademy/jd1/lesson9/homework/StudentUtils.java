package by.itacademy.jd1.lesson9.homework;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class StudentUtils {

    public static List<Student> getBestStudents(List<Student> students) {
        LinkedList<Student> bestStudents = new LinkedList<>();
        ListIterator<Student> iterator = students.listIterator();
        if (iterator.hasNext()) {
            bestStudents.add(iterator.next());
        }
        while (iterator.hasNext()) {
            Student currStudent = iterator.next();
            if (currStudent.getAverageResult() > bestStudents.getLast().getAverageResult()) {
                bestStudents.clear();
                bestStudents.addLast(currStudent);
            } else if (currStudent.getAverageResult() == bestStudents.getLast().getAverageResult()) {
                bestStudents.addLast(currStudent);
            }
        }
        return bestStudents;
    }
}
