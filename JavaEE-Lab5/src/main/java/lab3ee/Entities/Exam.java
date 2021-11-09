package lab3ee.Entities;

import jakarta.persistence.*;
import org.dom4j.tree.AbstractEntity;

import java.util.Date;

@Entity
@Table(name = "exams")
@NamedQueries({
        @NamedQuery(name = "Exam.findById",
                query = "select e from Exam e where e.id = :id"),
        @NamedQuery(name = "Exam.getAll",
                query = "select e from Exam e")
})
public class Exam extends AbstractEntity {

    @Id
    @GeneratedValue
    @Column(name = "Id")
    private Long id;

    @Column(name = "Name")
    private String name;

    @Column(name = "Starting time")
    private Date startingTime;

    @Column(name = "Duration")
    private String duration;

    public Exam() {

    }

    public Exam(String name, Date startingTime, String duration) {
        this.name = name;
        this.startingTime = startingTime;
        this.duration = duration;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getStartingTime() {
        return startingTime;
    }

    public void setStartingTime(Date startingTime) {
        this.startingTime = startingTime;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }
}
