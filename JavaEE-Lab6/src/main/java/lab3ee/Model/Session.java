package lab3ee.Model;


import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import lab3ee.Services.ExamService;
import lab3ee.Services.ResourceService;
import lab3ee.Services.SingletonResourcesLog;
import lab3ee.Services.StudentService;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named("customSession")
@SessionScoped
public class Session implements Serializable {

    private List<Exam> exams;
    private List<Student> students;
    private List<Resource> resources;
    private String selectedExam;

    public Session() {

    }

    @Inject
    private ExamService examService;

    @Inject
    private StudentService studentService;

    @Inject
    private ResourceService resourceService;

    @EJB
    private SingletonResourcesLog resourceLog;

    @PostConstruct
    public void init() {
        exams = examService.getExams();
        students = studentService.getStudents();
        resources = resourceService.getResources();
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

    public List<Resource> getResources() {
        return resources;
    }

    public void setResources(List<Resource> resources) {
        this.resources = resources;
    }

    public String getSelectedExam() {
        return selectedExam;
    }

    public void setSelectedExam(String selectedExam) {
        this.selectedExam = selectedExam;
    }

    public void submitResources(){
        selectedExam = updateExamName(selectedExam);
        List<Integer> selectedQuantities = new ArrayList<>();
        for (Resource resource : resources) {
            if(resourceService.isResourceAvailable(resource)){
                selectedQuantities.add(Integer.parseInt(resource.getSelectedQuantity()));
                resourceLog.updateMap(resource);
            }
        }
        //resourceLog.updateMapList(resources);
        resourceService.assignResources(resources, selectedExam, selectedQuantities);
    }

    public String concatLabel(String name, int quantity){
        return name + ": " + quantity;
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

    public String updateExamName(String selectedExam){
        for (Exam exam : exams) {
            if (selectedExam.contains(exam.getName())) {
                selectedExam = exam.getName();
                return selectedExam;
            }
        }
        return selectedExam;
    }
}
