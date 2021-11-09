package lab3ee.labee3.Services;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;
import lab3ee.labee3.Model.Exam;
import lab3ee.labee3.Repository.SingletonRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Named
@ApplicationScoped
public class ExamService {

    private List<Exam> exams;

    private final SingletonRepository repository = SingletonRepository.getInstance();

    @PostConstruct
    public void init() {
        exams = repository.getExams();
    }

    public List<Exam> getExams() {
        return new ArrayList<>(exams);
    }
}
