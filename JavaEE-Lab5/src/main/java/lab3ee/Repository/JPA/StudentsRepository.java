package lab3ee.Repository.JPA;

import lab3ee.Entities.Student;


public class StudentsRepository extends AbstractDataRepository<Student, Integer>{


    @Override
    public Student findById(Integer id) {
        return (Student) em.createNamedQuery("Exam.findById") //or use em.find
                .setParameter("id", id)
                .getSingleResult();
    }


    @Override
    public void persist(Student student) {
        if(!em.contains(student)) {
            em.persist(student);
        }
    }

    @Override
    public void remove(Integer id) {
        Student student = findById(id);
        if(student != null){
            em.remove(student);
        }
    }

    @Override
    public void update(Integer id, Student entity) {
        Student student = findById(id);
        if (student != null) {
            student.setName(entity.getName());
            student.setExams(entity.getExams());
            em.merge(student);
        } else {
            em.persist(entity);
        }
    }
}
