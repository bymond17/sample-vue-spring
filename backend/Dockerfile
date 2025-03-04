# Build stage
FROM eclipse-temurin:17-jdk-jammy AS build
WORKDIR /app

# Maven 빌드 캐시를 위한 의존성 레이어
COPY .mvn/ .mvn
COPY mvnw pom.xml ./
RUN chmod +x ./mvnw && \
    ./mvnw dependency:go-offline

# 소스코드 빌드 레이어
COPY src ./src
RUN ./mvnw package -DskipTests

# Run stage (최소화된 이미지)
FROM eclipse-temurin:17-jre-jammy
WORKDIR /app

# 필요한 패키지만 설치
RUN apt-get update && \
    apt-get install -y --no-install-recommends curl && \
    rm -rf /var/lib/apt/lists/*

# JAR 파일만 복사
COPY --from=build /app/target/*.jar app.jar

# JVM 최적화 옵션
ENV JAVA_OPTS="-XX:+UseContainerSupport -XX:MaxRAMPercentage=75.0 -Djava.security.egd=file:/dev/urandom"

ENTRYPOINT exec java $JAVA_OPTS -jar app.jar