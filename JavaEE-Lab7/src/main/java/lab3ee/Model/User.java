package lab3ee.Model;

import jakarta.persistence.*;
import org.dom4j.tree.AbstractEntity;


@Entity
@Table(name="users", schema = "lab3")
@NamedQueries({
        @NamedQuery(name = "User.getAll",
                query = "select u from User u"),
        @NamedQuery(name = "User.login",
                query = "select u from User u where u.name = :name and u.password = :password")
})
public class User extends AbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "password")
    private String password;

    @Column(name = "role")
    private String role;

    public User() {

    }

    public User(String name, String password, String role) {
        this.name = name;
        this.password = password;
        this.role = role;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }


}
