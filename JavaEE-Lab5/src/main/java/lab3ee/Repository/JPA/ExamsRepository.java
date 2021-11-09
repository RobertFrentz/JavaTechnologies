package lab3ee.Repository.JPA;

import lab3ee.Entities.Exam;

import java.util.List;

public class ExamsRepository extends AbstractDataRepository<Exam, Integer> {


    @Override
    public Exam findById(Integer id) {
        return (Exam) em.createNamedQuery("Exam.findById") //or use em.find
                .setParameter("id", id)
                .getSingleResult();
    }

    @Override
    public void persist(Exam exam) {
        if (!em.contains(exam)) {
            em.persist(exam);
        }
    }

    @Override
    public void remove(Integer id) {
        Exam exam = findById(id);
        if (exam != null) {
            em.remove(exam);
        }
    }

    @Override
    public void update(Integer id, Exam entity) {
        Exam exam = findById(id);
        if (exam != null) {
            exam.setName(entity.getName());
            exam.setStartingTime(entity.getStartingTime());
            exam.setDuration(entity.getDuration());
            em.merge(exam);
        } else {
            em.persist(entity);
        }
    }

    public List<Exam> getExams(){
        return (List<Exam>)em.createNamedQuery("Exam.getAll").getResultList();
    }
}
