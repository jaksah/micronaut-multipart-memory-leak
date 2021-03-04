FROM amazoncorretto:11
COPY build/libs/shadow.jar service.jar
CMD java ${JAVA_OPTS} -jar service.jar
