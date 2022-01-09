package lab3ee;

import jakarta.annotation.security.RolesAllowed;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;

@ApplicationPath("/api")
@ApplicationScoped
@RolesAllowed({"author", "admin", "reviewer"})
public class ApplicationConfig extends Application {
}
