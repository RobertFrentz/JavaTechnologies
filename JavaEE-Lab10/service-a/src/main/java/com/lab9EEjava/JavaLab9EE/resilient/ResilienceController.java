package com.lab9EEjava.JavaLab9EE.resilient;

import org.eclipse.microprofile.faulttolerance.*;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

@Path("/resilience")
@ApplicationScoped
public class ResilienceController {

    @Fallback(fallbackMethod = "fallback") // better use FallbackHandler
    @Path("/withoutRetry")
    @Timeout(5000)
    @GET
    public String fallbackWithoutRetryTest() {
        try {
            Thread.sleep(20000L);
        } catch (InterruptedException e) {
            //
        }
        return "Never from normal processing";
    }

    @Retry(maxRetries = 2, delay = 200, jitter = 50)
    @Fallback(fallbackMethod = "fallbackRetry")
    @Timeout(5000)
    @Path("/withRetry")
    @GET
    public String fallbackWithRetryTest() {
        try {
            Thread.sleep(20000L);
        } catch (InterruptedException e) {
            //
        }
        return "Never from normal processing";
    }

    @CircuitBreaker(
            successThreshold = 10,
            requestVolumeThreshold = 4,
            failureRatio=0.75,
            delay = 1000)
    @Path("/circuitBreaker")
    @Fallback(fallbackMethod = "fallbackCircuitBreaker")
    @GET
    public String circuitBreakerTestWithFallback() {
        try {
            Thread.sleep(5000L);
        } catch (InterruptedException e) {
            //
        }
        return "Never from normal processing";
    }

    @Bulkhead(3)
    @Fallback(fallbackMethod = "fallBackBulkheadSemaphore")
    @Path("/semaphore")
    @GET
    public String bulkheadSemaphoreTestWithFallback() {
        try {
            Thread.sleep(20000L);
        } catch (InterruptedException e) {
            //
        }
        return "noHere";
    }

    @Asynchronous
    @Bulkhead(value = 3, waitingTaskQueue = 5)
    @Fallback(fallbackMethod = "fallBackBulkheadThreadPool")
    @Path("/threadPool")
    @GET
    public Future<String> bulkheadThreadPoolTestWithFallback() {
        try {
            Thread.sleep(20000L);
        } catch (InterruptedException e) {
            //
        }
        return CompletableFuture.completedFuture("noHere");
    }

    public String fallback() {
        return "Fallback answer due to timeout";
    }

    public String fallbackRetry() {
        return "Fallback answer due to timeout + retry";
    }

    public String fallbackCircuitBreaker() {
        return "Fallback answer due to circuit breaker";
    }

    public String fallBackBulkheadSemaphore() {
        return "Fallback answer due to bulkhead semaphore maximum concurrent requests allowed ";
    }

    public Future<String> fallBackBulkheadThreadPool() {
        return CompletableFuture.completedFuture("Fallback answer due to bulkhead thread pool maximum concurrent requests allowed " +
                "or maximum requests allowed in waiting queue");
    }
}
