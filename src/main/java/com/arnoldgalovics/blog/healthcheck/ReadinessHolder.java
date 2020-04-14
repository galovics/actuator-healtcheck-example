package com.arnoldgalovics.blog.healthcheck;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.TaskExecutor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

@Component
public class ReadinessHolder {
    private static final Logger logger = LoggerFactory.getLogger(ReadinessHolder.class);

    @Autowired
    private TaskExecutor taskExecutor;

    private AtomicBoolean isReady = new AtomicBoolean(false);

    @PostConstruct
    public void init() {
        taskExecutor.execute(() -> {
            try {
                logger.info("Sleeping for 20 seconds..");
                Thread.sleep(TimeUnit.SECONDS.toMillis(20));
                isReady.set(true);
                logger.info("Application is ready to serve traffic");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });
    }

    public boolean isReady() {
        return isReady.get();
    }

    public void switchReady() {
        boolean newReadyValue = !isReady.get();
        logger.info("Switching the ready flag to {}", newReadyValue);
        isReady.set(newReadyValue);
    }
}
