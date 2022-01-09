package lab3ee.Model;


import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.context.ExternalContext;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import lab3ee.Services.UserService;

import javax.security.auth.login.LoginException;
import java.io.Serializable;
import java.util.Locale;

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

    public String loginUser() throws LoginException {
        FacesContext context = FacesContext.getCurrentInstance();
        ExternalContext externalContext = context.getExternalContext();
        HttpServletRequest request = (HttpServletRequest) externalContext.getRequest();
        try{
            request.login(username, password);
            System.out.println(username + " " + password);
            String userRole = userService.loginUser(username, password);
            System.out.println(userRole.toLowerCase(Locale.ROOT));
            return userRole.toLowerCase(Locale.ROOT) + "/home" + userRole + ".xhtml";
        } catch (RuntimeException | ServletException e){
            System.out.println("Login Failed ");
            externalContext.log("Login failed");
            throw new LoginException("Login failed");
        }
    }

}
