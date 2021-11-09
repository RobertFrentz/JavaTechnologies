package lab3ee.Model;


import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import lab3ee.Services.ExamService;
import lab3ee.Services.StudentService;

import java.io.Serializable;
import java.util.List;

@Named("customSession")
@SessionScoped
public class Session implements Serializable {

    private List<Exam> exams;
    private List<Student> students;

    public Session() {

    }

    @Inject
    private ExamService examService;

    @Inject
    private StudentService studentService;

    @PostConstruct
    public void init() {
        exams = examService.getExams();
        //students = studentService.getStudents();
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

    @Override
    public String toString() {
        return "Session{" +
                "exams=" + exams +
                ", students=" + students +
                ", examService=" + examService +
                ", studentService=" + studentService +
                '}';
    }
}
