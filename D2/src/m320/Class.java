package m320;

import java.util.ArrayList;

public class Class {

    private ArrayList<Student> students;

    public Class(ArrayList<Student> students) {
        this.students = students;
    }

    public float getAverage(){
        float grades = 0;

        for(int i = 0; i < students.size(); i++){
            grades += students.get(i).studentAverage();
        }

        return grades / students.size();
    }
    public void addStudent(Student student){
        students.add(student);
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }

}
