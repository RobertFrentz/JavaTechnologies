package lab3ee.labee3.Services;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;
import lab3ee.labee3.Model.Student;
import lab3ee.labee3.Repository.SingletonRepository;

import java.util.ArrayList;
import java.util.List;

@Named
@ApplicationScoped
public class StudentService {

    private List<Student> students;

    private final SingletonRepository repository = SingletonRepository.getInstance();

    @PostConstruct
    public void init(){
        students = repository.getStudents();
    }

    public List<Student> getStudents() {
        return new ArrayList<>(students);
    }
}
