package lab3ee.Model;

import jakarta.persistence.*;
import org.dom4j.tree.AbstractEntity;


@Entity
@Table(name="documents", schema = "lab3")
@NamedQueries({
        @NamedQuery(name = "Document.getAll",
                query = "select d from Document d"),
        @NamedQuery(name = "Document.getAllForUser",
                query = "select d from Document d where d.userId = :userId")
})
public class Document extends AbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "authors")
    private String authors;

    @Column(name = "content")
    private String content;

    @Column(name = "userid")
    private int userId;

    public Document() {

    }

    public Document(String name, String authors, String content, int userId) {
        this.name = name;
        this.authors = authors;
        this.content = content;
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public String getAuthors() {
        return authors;
    }

    public void setAuthors(String authors) {
        this.authors = authors;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Document{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", authors='" + authors + '\'' +
                ", content='" + content + '\'' +
                ", userId=" + userId +
                '}';
    }
}
