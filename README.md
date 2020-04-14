# Intro
This is a showcase project for Kubernetes and Spring Boot Actuator healthcheck integration with liveness probe.
It was created for a tutorial article that can be found here:
https://blog.arnoldgalovics.com/smart-healthchecks-with-kubernetes-and-spring-boot-actuator/

Also, readiness probe integration has been added for this article:
https://blog.arnoldgalovics.com/health-based-traffic-control-with-kubernetes/


## Building and deploying
1. `./gradlew clean build` 
2. `docker build . -t actuator-healthcheck-example`
3. `kubectl apply -f k8s-deployment.yaml`

