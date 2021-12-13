package lab3ee.View;

import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;

@WebListener
public class SessionsCounter implements HttpSessionListener {

    private static int count;

    @Override
    public void sessionCreated(HttpSessionEvent event) {
        count++;
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent event) {
        count--;
    }

    public static int getCount() {
        return count;
    }

}