package lab3ee.Entities;

import jakarta.persistence.*;
import org.dom4j.tree.AbstractEntity;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "students", schema = "lab3")
@NamedQueries({
        @NamedQuery(name = "Student.findById",
                query = "select s from Student s where s.id = :id"),
        @NamedQuery(name = "Student.getAll",
                query = "select s from Student s")
})
public class Student extends AbstractEntity {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id")
    private List<Exam> exams = new ArrayList<>();

    public Student() {

    }

    public Student(String name, List<Exam> examEntities) {
        this.name = name;
        this.exams = examEntities;
    }

    public List<Exam> getExams() {
        return exams;
    }

    public void setExams(List<Exam> examEntities) {
        this.exams = examEntities;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

}
