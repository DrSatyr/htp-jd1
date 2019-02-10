package by.itacademy.jd1.lesson9.homework;

import java.util.Comparator;

public class Student {

    public static Comparator<Student> defaultComparator = new FirstNameComparator().thenComparing(
            new LastNameComparator().thenComparing(
                    new AgeComparator().thenComparing(
                            new ResultComparator())));
    private String firstName;
    private String lastName;
    private int age;
    private double averageResult;

    public Student(String firstName, String lastName, int age, double averageResult) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.averageResult = averageResult;
    }

    @Override
    public String toString() {
        return "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", averageResult=" + averageResult +
                "\n";
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public double getAverageResult() {
        return averageResult;
    }

    private static class FirstNameComparator implements Comparator<Student> {

        @Override
        public int compare(Student o1, Student o2) {
            return o1.firstName.compareTo(o2.firstName);
        }

    }

    private static class LastNameComparator implements Comparator<Student> {

        @Override
        public int compare(Student o1, Student o2) {
            return o1.lastName.compareTo(o2.lastName);
        }

    }

    private static class AgeComparator implements Comparator<Student> {

        @Override
        public int compare(Student o1, Student o2) {
            return o1.age - o2.age;
        }

    }

    private static class ResultComparator implements Comparator<Student> {

        @Override
        public int compare(Student o1, Student o2) {
            return (int) (o1.averageResult - o2.averageResult);
        }
    }
}
