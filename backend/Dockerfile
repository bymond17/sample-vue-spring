# Base image
FROM eclipse-temurin:17-jdk AS builder

# 작업 디렉토리 설정
WORKDIR /app

# Maven 래퍼와 pom.xml 복사
COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .

# Maven 래퍼 실행 권한 부여 (Windows에서 권한 문제 해결)
RUN chmod +x ./mvnw

# 의존성 다운로드
RUN ./mvnw dependency:go-offline -B

# 소스 코드 복사
COPY src src

# 애플리케이션 빌드
RUN ./mvnw clean package -DskipTests -B

# 실행 단계
FROM eclipse-temurin:17-jdk

# JAR 파일 복사
COPY --from=builder /app/target/*.jar app.jar

# 포트 설정
EXPOSE 8080

# 애플리케이션 실행
ENTRYPOINT ["java", "-jar", "app.jar"]