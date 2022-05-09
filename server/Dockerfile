# the first stage of our build will use a maven 3.8.5 parent image
#FROM jonatanbuus/base-image:1.0-SNAPSHOT AS BUILDER
FROM maven:3.8.5-openjdk-11 AS BUILDER

# copy the pom and src code to the container
ADD . /build
WORKDIR /build

# package our application code
RUN mvn package -P jar

RUN ls -al /build/target
RUN ls -al /build/src/main/resources

# the second stage of our build will use open jdk 11 on alpine 3.14
FROM adoptopenjdk/openjdk11:jre-11.0.9_11.1-alpine

# copy only the artifacts we need from the first stage and discard the rest
COPY --from=BUILDER /build/target/counterparty-fee-calculator*.jar /counterparty-fee-calculator.jar
COPY --from=builder /build/src/main/resources/application.yaml /application.yaml

# set the startup command to execute the jar
CMD ["java", "-jar", "/counterparty-fee-calculator.jar", "--spring.config.location=file:/application.yaml"]