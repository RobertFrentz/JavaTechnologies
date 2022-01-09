package lab3ee.Repository.JPA;

import jakarta.ejb.Stateless;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import lab3ee.Model.User;

import java.util.List;

@Named
@ApplicationScoped
public class UsersRepository {

    @PersistenceContext(unitName = "myPersistenceUnit")
    protected EntityManager em;

    public List<User> getUsers() {
        return (List<User>) em.createNamedQuery("User.getAll").getResultList();
    }

    public String userLoggedIn(String username, String password){
        List<User> userList = (List<User>) em.createNamedQuery("User.login")
                .setParameter("name", username)
                .setParameter("password", password)
                .getResultList();
        if(userList.size() == 0){
            return "notAuthorized";
        }
        return userList.get(0).getRole();
    }

    @Transactional
    public void registerUser(String username, String password, String role){
        User user = new User(username, password, role);
        em.persist(user);
    }
}
