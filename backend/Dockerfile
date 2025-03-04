# Build stage
FROM eclipse-temurin:17-jdk-jammy AS build
WORKDIR /app

# 환경 변수 설정
ENV JAVA_OPTS="-Xmx512m -Xms256m"
ENV MAVEN_OPTS="-Dmaven.repo.local=/root/.m2/repository"

# Copy Maven wrapper and pom.xml
COPY .mvn/ .mvn
COPY mvnw pom.xml ./

# Copy source code
COPY src ./src

# Build application
RUN chmod +x ./mvnw
RUN ./mvnw clean package -DskipTests

# Run stage
FROM eclipse-temurin:17-jdk-jammy
WORKDIR /app

# Copy JAR from build stage
COPY --from=build /app/target/*.jar app.jar

# Maven wrapper and dependencies
COPY .mvn/ .mvn
COPY mvnw pom.xml ./
RUN chmod +x ./mvnw

# 개발 환경에서는 소스를 볼륨으로 마운트할 것이므로 COPY는 불필요
CMD ["./mvnw", "spring-boot:run"]

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]