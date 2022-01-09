package lab3ee.Services;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import lab3ee.Repository.JPA.UsersRepository;

@Named
@ApplicationScoped
public class UserService {

    @Inject
    private UsersRepository usersRepository;

    public String loginUser(String username, String password){
        return usersRepository.userLoggedIn(username, password);
    }

    public void registerUser(String username, String password, String role){
        usersRepository.registerUser(username, password, role);
    }

}
