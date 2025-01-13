package m320;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Student> students = createStudents();

        Class classA = new Class(students);

        for (Student student : students) {
            System.out.println(student.getName() + "\nstudent avarage: " +student.studentAverage());
            System.out.println();
        }

        System.out.println("class avarage: " + classA.getAverage());
    }

    // Function to create default data
    private static ArrayList<Student> createStudents() {
        ArrayList<Student> students = new ArrayList<>();

        students.add(addTests(new Student("peter"), 12.5f, 2.0f, 20.0f));
        students.add(addTests(new Student("gerard"), 14.0f, 10.0f, 18.5f));
        students.add(addTests(new Student("curt"), 11.0f, 8.5f, 19.0f));

        return students;
    }

    // Function to add tests to a student
    private static Student addTests(Student student, float points1, float points2, float points3) {
        student.addTest(new Test(points1, 15));
        student.addTest(new Test(points2, 12));
        student.addTest(new Test(points3, 20));
        return student;
    }
}
