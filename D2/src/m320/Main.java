package m320;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Student> students = createStudents();

        Class classA = new Class(students);

        for (Student student : students) {
            System.out.println(student.getName() + "\nstudent average: " + student.studentAverage());
            System.out.println();
        }

        while (true) {
            System.out.println("Class average: " + classA.getAverage());
            System.out.println("1 - See students \n" +
                    "2 - Add student \n" +
                    "3 - Add test \n" +
                    "4 - Exit");

            switch (scanner.nextInt()) {
                case (1) -> {
                    for (Student student : students) {
                        System.out.println(student.getName() + "\nstudent average: " + student.studentAverage());
                        System.out.println();
                    }
                }
                case (2) -> {
                    scanner.nextLine();
                    System.out.print("Enter the student's name: ");
                    String name = scanner.nextLine();
                    Student newStudent = new Student(name);

                    System.out.println("Adding tests for the new student...");
                    for (int i = 1; i <= 3; i++) {
                        System.out.print("Enter points for test " + i + ": ");
                        float points = scanner.nextFloat();
                        System.out.print("Enter max points for test " + i + ": ");
                        int maxPoints = scanner.nextInt();
                        newStudent.addTest(new Test(points, maxPoints));
                    }

                    students.add(newStudent);
                    classA = new Class(students);
                    System.out.println("Student added successfully!");
                }
                case (3) -> {
                    scanner.nextLine();

                    System.out.print("Enter max points for the new test: ");
                    int maxPoints = scanner.nextInt();

                    System.out.println("now adding achieved points for each student");

                    for (Student student : students) {
                        System.out.println(student.getName());

                        System.out.print("Enter points for the new test: ");
                        float points = scanner.nextFloat();
                        student.addTest(new Test(points, maxPoints));
                    }
                    System.out.println("Test added successfully!");
                }
                case (4) -> {
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                }
                default -> System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static ArrayList<Student> createStudents() {
        ArrayList<Student> students = new ArrayList<>();

        students.add(addTests(new Student("peter"), 12.5f, 2.0f, 20.0f));
        students.add(addTests(new Student("gerard"), 14.0f, 10.0f, 18.5f));
        students.add(addTests(new Student("curt"), 11.0f, 8.5f, 19.0f));

        return students;
    }

    private static Student addTests(Student student, float points1, float points2, float points3) {
        student.addTest(new Test(points1, 15));
        student.addTest(new Test(points2, 12));
        student.addTest(new Test(points3, 20));
        return student;
    }
}
