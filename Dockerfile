FROM maven:3.6.3-openjdk-11 as build
WORKDIR /app
COPY . /app
RUN mvn clean package -DskipTests

FROM openjdk:11
COPY --from=build /app/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.jar"]