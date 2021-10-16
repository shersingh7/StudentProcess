

import java.sql.SQLOutput;
import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;

public class StudentProcess {

    private static Student[] students = {
            new Student("Jack", "Smith", 50.0, "IT"),
            new Student("Aaron", "Johnson", 76.0, "IT"),
            new Student("Maaria", "White", 35.8, "Business"),
            new Student("John", "White", 47.0, "Media"),
            new Student("Laney", "White", 62.0, "IT"),
            new Student("Jack", "Jones", 32.9, "Business"),
            new Student("Wesley", "Jones", 42.89, "Media")};

    public static void main(String[] args) {

        List<Student> list = Arrays.asList(students);

        //TASK-1
        System.out.println("Task 1:\n\n" + "Complete Student list:" );
        list.forEach(System.out::println);

        //TASK-2
        System.out.println("\nTask 2:\n\nStudents who got 50.0-100.0 sorted by grade:");
        list.stream().filter(std-> std.getGrade() >= 50 && std.getGrade() <= 100)
                .sorted(Comparator.comparing(Student::getGrade))
                .forEach(System.out::println);

        //TASK-3
        System.out.println("\nTask 3:\n\nFirst Student who got 50.0-100.0:");
        list.stream().filter(student->student.getGrade() >= 50 && student.getGrade() <= 100).findFirst().ifPresent(System.out::println);

        //TASK-4
        System.out.println("\nTask 4:\n\nStudents in ascending order by last name then first:");
        list.stream().sorted(Comparator.comparing(Student::getFirstName))
                .sorted(Comparator.comparing(Student::getLastName))
                .forEach(System.out::println);

        System.out.println("\nStudents in descending order by last name then first:");
        list.stream().sorted(Comparator.comparing(Student::getFirstName).reversed())
                .sorted(Comparator.comparing(Student::getLastName).reversed())
                .forEach(System.out::println);

        //TASK-5
        System.out.println("\nTask 5:\n\nUnique Student last names:");
        list.stream().map(Student::getLastName).distinct().sorted().forEach(System.out::println);


        //TASK 6
        System.out.println("\n\nTask 6:\n\nStudent names in order by last name then first name:");

        list.stream().sorted(Comparator.comparing(Student::getFirstName))
                .sorted(Comparator.comparing(Student::getLastName))
                .map(Student::getFullName)
                .forEach(System.out::println);


        //TASK 7
        System.out.println("\n\nTask 7:\n\nStudents by department:");

        Map<String, List<Student>> byDepartment = list.stream().collect(Collectors.groupingBy(Student::getDepartment));

        byDepartment.forEach((dep, obj) -> {
            System.out.println(dep);
            obj.forEach(std -> System.out.println("\t" + std));
        });

        //TASK 8
        System.out.println("\n\nTask 8:\n\nCount of Students by department:");

        Map<String, Long> dept = list.stream().collect(Collectors.groupingBy(Student::getDepartment, Collectors.counting()));

        Map<String, Long> sortDept = new TreeMap<>(dept); //TreeMap to sort Map naturally

        sortDept.forEach((department, count) -> System.out.println(department + " has " + count + " Student(s)"));


        //TASK 9
        System.out.print("\n\nTask 9:\n\nSum of Students' grades: ");

        double total = list.stream().mapToDouble(std -> std.getGrade()).sum();
        System.out.println(total);

        //TASK 10
        System.out.print("\n\nTask 10:\nAverage of Students' grades: ");

        double avg = list.stream().mapToDouble(Student::getGrade).average().getAsDouble();

        DecimalFormat df = new DecimalFormat("####.##");
        System.out.println(df.format(avg));
    }
}
