package by.itacademy.jd1.lesson9.homework;

import java.util.*;

public class Task2 {

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Ivan", "Ivanov", 25, 10.0));
        students.add(new Student("Petr", "Petrov", 26, 7.0));
        students.add(new Student("Vova", "Vovanov", 24, 4.0));
        students.add(new Student("Ivan", "Ivanov", 23, 10.0));
        students.add(new Student("Ivan", "Ivanov", 23, 2.0));
        List<Student> bestStudents = StudentUtils.getBestStudents(students);

        System.out.println("Initial student list is: ");
        System.out.println();
        System.out.println(students);
        System.out.println();
        System.out.println("Best student(s): \n" + bestStudents);
        System.out.println();

        students.sort(Student.defaultComparator);

        System.out.println("Sorted student list: ");
        System.out.println();
        System.out.println(students);
    }
}
