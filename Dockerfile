FROM maven:3.6.3-openjdk-17 as build
WORKDIR /app
COPY . /app
RUN mvn clean package -DskipTests

FROM openjdk:17
COPY --from=build /app/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.jar"]