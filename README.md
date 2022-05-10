# Counterparty Fee Calculator
Sample app for calculating a fee for a counterparty written in [Java 11](https://www.oracle.com/java/technologies/javase/jdk11-archive-downloads.html "Download JDK 11") using [Spring Reactive Stack](https://docs.spring.io/spring-framework/docs/current/reference/html/web-reactive.html "Spring Reactive Stack").
The Counterparty Fee Calculator exposes 2 APIs:
- (Kubernetes Liveness Probe)[https://kubernetes.io/docs/tasks/configure-pod-container/configure-liveness-readiness-startup-probes/ "Configure Liveness, Readiness and Startup Probes"]
- Get Counterparty Fee

The API documentation for both end-points is available at **http://localhost/swagger-ui/**.

## Dependencies
- [Docker](https://docs.docker.com/get-docker/ "Get Docker")

## Environment Variables
The Counterparty Fee Calculator supports the following environment variables:
| Name | Description | Type  | Default | Required |
| ---- | ----------- |:-----:|:-------:|:--------:|
| PORT | The port the Counterparty Fee Calculator within the container | `Integer` | `8080` | No |
| LOG_LEVEL | The log level passed to Spring, may be one of: `ERROR`, `WARNING`, `INFO`, `DEBUG` or `TRACE` | `String` | `INFO` | No |

## Building and Running using Docker
The Counterparty Fee Calculator may be built and run using [Docker](https://www.docker.com/ "Docker") using the following commands:

**[Build a Counterparty Fee Calculator image from a Dockerfile](https://docs.docker.com/engine/reference/commandline/build/ "docker build")**
```
docker build . --tag dk.jonatanbuus/counterparty-fee-calculator:latest
```
**[Run the Counterparty Fee Calculator container](https://docs.docker.com/engine/reference/commandline/run/ "docker run")**
```
docker run -p 80:80 -e LOG_LEVEL=DEBUG -e PORT=80 dk.jonatanbuus/counterparty-fee-calculator
```