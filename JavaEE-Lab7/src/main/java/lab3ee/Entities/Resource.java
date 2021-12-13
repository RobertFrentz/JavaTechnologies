package lab3ee.Entities;


import jakarta.persistence.*;
import org.dom4j.tree.AbstractEntity;

@Entity
@Table(name="resources", schema = "lab3")
@NamedQueries({
        @NamedQuery(name = "Resource.getAll",
                query = "select r from Resource r")
})
public class Resource extends AbstractEntity {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "exam")
    private String exam;

    public Resource() {

    }

    public Resource(String name, int quantity, String exam) {
        this.name = name;
        this.quantity = quantity;
        this.exam = exam;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getExam() {
        return exam;
    }

    public void setExam(String exam) {
        this.exam = exam;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
