package lab3ee.Entities;

import jakarta.persistence.*;
import org.dom4j.tree.AbstractEntity;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "students")
@NamedQueries({
        @NamedQuery(name = "Student.findById",
                query = "select s from Exam s where s.id = :id")
})
public class Student extends AbstractEntity {

    @Id
    @GeneratedValue
    @Column(name = "Id")
    private Long id;

    @Column(name = "Name")
    private String name;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "Id")
    private List<Exam> exams = new ArrayList<>();

    public Student() {

    }

    public Student(String name, List<Exam> exams) {
        this.name = name;
        this.exams = exams;
    }

    public List<Exam> getExams() {
        return exams;
    }

    public void setExams(List<Exam> exams) {
        this.exams = exams;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
