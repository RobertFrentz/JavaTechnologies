package lab3ee.Services;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;
import lab3ee.Repository.JPA.ExamsRepository;
import lab3ee.Model.Exam;
import lab3ee.Utils.DataMapper;

import java.util.ArrayList;
import java.util.List;

@Named
@ApplicationScoped
public class ExamService {

    private List<Exam> exams;

    private final ExamsRepository examsRepository = new ExamsRepository();

    @PostConstruct
    public void init() {
        exams = DataMapper.ExamsToModel(examsRepository.getExams());
    }

    public List<Exam> getExams() {
        return new ArrayList<>(exams);
    }
}
