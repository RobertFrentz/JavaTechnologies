package lab3ee.Model;


import java.util.ArrayList;
import java.util.List;


public class Student {

    private String name;
    private List<Exam> exams = new ArrayList<>();

    public Student(String name, List<Exam> exams) {
        this.name = name;
        this.exams = exams;
    }

    public Student() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Exam> getExamsList(){
        return exams;
    }

    public String getExams() {

        StringBuilder stringBuilder = new StringBuilder();
        for (Exam exam : exams) {
            stringBuilder.append(exam.getName()).append(", ");
        }
        return stringBuilder.toString();
    }

    public void setExams(List<Exam> exams) {
        this.exams = exams;
    }

    public void addExam(String examName){
        exams.add(new Exam(examName));
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", exams=" + exams +
                '}';
    }
}
