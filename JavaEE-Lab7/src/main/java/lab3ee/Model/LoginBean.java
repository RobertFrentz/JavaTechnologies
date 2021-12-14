package lab3ee.Model;


import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import lab3ee.Services.UserService;

import java.io.Serializable;

@Named("login")
@SessionScoped
public class LoginBean implements Serializable {

    private String username;
    private String password;

    @Inject
    private UserService userService;

    public LoginBean() {

    }

    public LoginBean(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String loginUser(){
        System.out.println(username + " " + password);
        String userRole = userService.loginUser(username, password);
        System.out.println(userRole);
        return userRole;
    }

}
