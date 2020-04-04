package com.arnoldgalovics.blog.healthcheck;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class ManualHealthIndicator implements HealthIndicator {
    @Autowired
    private ManualHealthHolder manualHealthHolder;

    @Override
    public Health health() {
        boolean healthy = manualHealthHolder.isHealthy();
        if (healthy) {
            return Health.up().build();
        }
        return Health.down().build();
    }
}
