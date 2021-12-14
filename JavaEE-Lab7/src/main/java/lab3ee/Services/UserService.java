package lab3ee.Services;

import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import lab3ee.Model.Student;
import lab3ee.Model.User;
import lab3ee.Repository.JPA.StudentsRepository;
import lab3ee.Repository.JPA.UsersRepository;
import lab3ee.Utils.DataMapper;

import java.util.ArrayList;
import java.util.List;

@Named
@ApplicationScoped
public class UserService {
    private List<User> users;

    @Inject
    private UsersRepository usersRepository;


    @PostConstruct
    public void init(){
        //usersRepository = new UsersRepository();
    }

    public List<User> getUsers() {
        return new ArrayList<>(users);
    }

    public String loginUser(String username, String password){
        return usersRepository.userLoggedIn(username, password);
    }

    public void registerUser(String username, String password, String role){
        usersRepository.registerUser(username, password, role);
    }

}
