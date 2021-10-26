package lab3ee.labee3.Services;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;
import lab3ee.labee3.Model.Student;
import lab3ee.labee3.Repository.SingletonRepository;

import java.util.List;

@Named
@ApplicationScoped
public class StudentService {

    private final SingletonRepository repository = SingletonRepository.getInstance();


    public List<Student> getStudents() {
        return repository.getStudents();
    }
}
