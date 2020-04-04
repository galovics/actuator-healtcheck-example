package com.arnoldgalovics.blog.healthcheck;

import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicBoolean;

@Component
public class ManualHealthHolder {
    private AtomicBoolean healthy = new AtomicBoolean(true);

    public void switchHealth() {
        healthy.set(!healthy.get());
    }

    public boolean isHealthy() {
        return healthy.get();
    }
}
