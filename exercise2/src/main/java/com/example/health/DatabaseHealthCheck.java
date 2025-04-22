package com.example.health;

import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.HealthCheckResponseBuilder;
import org.eclipse.microprofile.health.Readiness;
import com.example.repository.PersonRepository;

import jakarta.inject.Inject;

@Readiness
public class DatabaseHealthCheck implements HealthCheck {

    @Inject
    PersonRepository personRepository;

    @Override
    public HealthCheckResponse call() {
        HealthCheckResponseBuilder responseBuilder = HealthCheckResponse.named("Database connection health check");
        
        try {
            long count = personRepository.count();
            return responseBuilder
                    .up()
                    .withData("person_count", String.valueOf(count))
                    .build();
        } catch (Exception e) {
            return responseBuilder
                    .down()
                    .withData("error", e.getMessage())
                    .build();
        }
    }
}