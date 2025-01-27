package m320;

import java.util.ArrayList;

public class Student {
    private String name;

    private ArrayList<Test> tests;

    public Student(String name) {
        this.name = name;
        this.tests = new ArrayList<>();
    }

    public void addTest(Test test){
        tests.add(test);
    }

    public float studentAverage(){
        float grades = 0;

        for (Test test : tests) {
            grades += test.calculateGrade();
        }

        return grades / tests.size();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Test> getTests() {
        return tests;
    }

    public void setTests(ArrayList<Test> tests) {
        this.tests = tests;
    }
}
