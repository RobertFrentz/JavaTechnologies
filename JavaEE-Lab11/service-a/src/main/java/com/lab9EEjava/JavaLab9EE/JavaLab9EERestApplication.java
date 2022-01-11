package com.lab9EEjava.JavaLab9EE;

import org.eclipse.microprofile.auth.LoginConfig;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 *
 */
@ApplicationPath("/api/v1")
@ApplicationScoped
@LoginConfig(authMethod = "MP-JWT")
public class JavaLab9EERestApplication extends Application {
}
