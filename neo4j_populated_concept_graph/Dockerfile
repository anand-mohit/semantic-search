#base image
FROM java:8-jre

VOLUME /tmp

#add the local jar to docker context (jar in target folder after mvn package)
ADD ./target/gs-accessing-neo4j-data-rest-0.1.0.jar neo4j.jar

#different port for each image
EXPOSE 8080

CMD ["java", "-jar", "/neo4j.jar"]
