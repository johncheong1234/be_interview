package com.example;

import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.Readiness;
import jakarta.enterprise.context.ApplicationScoped;

@Readiness
@ApplicationScoped
public class DownstreamReadinessCheck implements HealthCheck {

    @Override
    public HealthCheckResponse call() {
        boolean connectionOk = simulateCheck();

        if (connectionOk) {
            return HealthCheckResponse.up("Downstream Service");
        } else {
            return HealthCheckResponse.down("Downstream Service");
        }
    }

    private boolean simulateCheck() {
        // Simulate a service check — return false to simulate failure
        return true;
    }
}
