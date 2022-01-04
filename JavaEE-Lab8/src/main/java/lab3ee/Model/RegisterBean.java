package lab3ee.Model;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import lab3ee.Services.UserService;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Named("register")
@SessionScoped
public class RegisterBean implements Serializable {

    private String username;
    private String password;
    private String selectedRole;
    private final List<String> roles = Arrays.asList("Admin", "Author", "Reviewer");

    @Inject
    private UserService userService;

    public RegisterBean() {

    }

    public RegisterBean(String username, String password) {
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

    public String getSelectedRole() {
        return selectedRole;
    }

    public void setSelectedRole(String selectedRole) {
        this.selectedRole = selectedRole;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void registerUser(){
        userService.registerUser(username, password, selectedRole);
        System.out.println(username + " " + password + " " + selectedRole);
    }
}
