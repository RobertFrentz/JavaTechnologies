package lab3ee.Services;

import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;
import lab3ee.Model.Student;
import lab3ee.Repository.JPA.StudentsRepository;
import lab3ee.Utils.DataMapper;
//import lab3ee.Repository.SingletonRepository;

import java.util.ArrayList;
import java.util.List;

@Named
@ApplicationScoped
public class StudentService {

    private List<Student> students;

    @EJB
    private StudentsRepository studentsRepository;


    @PostConstruct
    public void init(){
        students = DataMapper.StudentsToModel(studentsRepository.getStudents());
    }

    public List<Student> getStudents() {
        return new ArrayList<>(students);
    }
}
