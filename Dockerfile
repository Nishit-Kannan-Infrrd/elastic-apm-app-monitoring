FROM maven:3.8.2-jdk-11

COPY /library /opt/library

WORKDIR /opt/library

RUN mvn clean compile package -DskipTests

FROM openjdk:11.0.12-jre

ARG ARG_SERVICE_NAME
ARG ARG_APM_SERVER_URL
ARG ARG_APPLICATION_PACKAGES
ARG ARG_DATASOURCE_URL
ARG ARG_DB_USERNAME
ARG ARG_DB_PASSWORD

ENV SERVICE_NAME $ARG_SERVICE_NAME
ENV APM_SERVER_URL $ARG_APM_SERVER_URL
ENV APPLICATION_PACKAGES $ARG_APPLICATION_PACKAGES 
ENV DATASOURCE_URL $ARG_DATASOURCE_URL
ENV DB_USERNAME $ARG_DB_USERNAME
ENV DB_PASSWORD $ARG_DB_PASSWORD

WORKDIR /opt

COPY --from=0 /opt/library/target/library-0.0.1-SNAPSHOT.jar library-0.0.1-SNAPSHOT.jar
COPY ./agent/elastic-apm-agent-1.25.0.jar elastic-apm-agent-1.25.0.jar

EXPOSE 8080

# ENTRYPOINT ["echo"]

CMD ["/bin/sh", "-c", "java -javaagent:elastic-apm-agent-1.25.0.jar -Delastic.apm.service_name=${SERVICE_NAME} -Delastic.apm.server_url=${APM_SERVER_URL} -Delastic.apm.secret_token=  -Delastic.apm.application_packages=${APPLICATION_PACKAGES} -jar library-0.0.1-SNAPSHOT.jar"]