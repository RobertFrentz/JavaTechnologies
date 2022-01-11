package com.lab9EEjava.JavaLab9EE.health;

import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.Liveness;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Liveness
@ApplicationScoped
public class ServiceLiveHealthCheck implements HealthCheck {

    @Override
    public HealthCheckResponse call() {

        return HealthCheckResponse.named(ServiceLiveHealthCheck.class.getSimpleName()).withData("live", true).up().build();

    }
}
