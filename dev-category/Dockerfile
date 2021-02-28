FROM maven:latest AS MAVEN_BUILD
LABEL Ansary MARECAR <an.marecar@gmail.com>

ADD /dev-category/category ./
RUN ls -l
RUN mvn clean -e
RUN ls -l
RUN mvn package -DskipTests -e

# the second stage of our build will use open jdk
FROM openjdk:latest
 
# copy only the artifacts we need from the first stage and discard the rest
COPY --from=MAVEN_BUILD /target/category-0.0.1-SNAPSHOT.jar /category.jar

# expose
EXPOSE 9002
# set the startup command to execute the jar
CMD ["java", "-jar", "/category.jar"]