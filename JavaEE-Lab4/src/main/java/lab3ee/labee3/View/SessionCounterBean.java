package lab3ee.labee3.View;

import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;

import java.io.Serializable;

@Named("sCounter")
@SessionScoped
public class SessionCounterBean implements Serializable {

    /*private int testSessionCount = 0;

    public void logout() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
    }

    public int getTestSessionCount() {
        return testSessionCount;
    }

    public void increaseTestSessionCount() {
        testSessionCount++;
    }
*/
    public int getSessionCount(){
        return SessionsCounter.getCount();
    }

}