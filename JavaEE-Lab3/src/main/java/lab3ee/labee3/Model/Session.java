package lab3ee.labee3.Model;


import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import lab3ee.labee3.Services.ExamService;
import lab3ee.labee3.Services.StudentService;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named("customSession")
@SessionScoped
public class Session implements Serializable {

    private List<Exam> exams = new ArrayList<>();
    private List<Student> students = new ArrayList<>();

    public Session() {

    }

    @Inject
    private ExamService examService;

    @Inject
    private StudentService studentService;

    @PostConstruct
    public void init() {
        exams = examService.getExams();
        students = studentService.getStudents();
    }

    public List<Exam> getExams() {
        return exams;
    }

    public List<Student> getStudents(){
        return students;
    }

    public void setExams(List<Exam> exams) {
        this.exams = exams;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
