# sample-vue-spring

## 프로젝트 설명

이 프로젝트는 Vue.js 프론트엔드와 Spring Boot 백엔드를 통합한 예제 프로젝트입니다.

## 프로젝트 구조
```
.
├── frontend/               # Vue.js 프론트엔드
├── backend/               # Spring Boot 백엔드
│   └── src/main/java/com/example/sample_vue_spring/
│       ├── common/        # 공통 모듈
│       │   ├── config/    # 설정 클래스
│       │   │   ├── SwaggerConfig.java
│       │   │   └── WebConfig.java
│       │   └── exception/ # 예외 처리
│       │       └── GlobalExceptionHandler.java
│       ├── domain/        # 도메인 모델
│       │   └── entity/    # JPA 엔티티
│       │       └── BaseTimeEntity.java
│       ├── infrastructure/# 인프라스트럭처
│       │   └── database/  # DB 설정
│       │       └── DatabaseConfig.java
│       ├── service/       # 비즈니스 로직
│       │   └── DatabaseService.java
│       └── web/           # 웹 계층
│           ├── controller/# 컨트롤러
│           │   ├── HelloController.java
│           │   └── DbCheckController.java
│           └── dto/       # DTO 클래스
│               └── response/
│                   └── ApiResponse.java
├── docker-compose.yml    # Docker 컴포즈 설정
└── db_password.txt       # DB 비밀번호 파일
```

## 기술 스택
- Frontend: Vue.js
- Backend: Spring Boot 2.6.3
- Database: PostgreSQL 13
- Build Tool: Maven
- Container: Docker

## 설정 및 실행 방법

### 1. 환경 설정
```bash
# DB 비밀번호 파일 생성
echo "your_password" > db_password.txt
```

### 2. Docker 실행
```bash
# 전체 서비스 실행
docker-compose up --build

# 특정 서비스만 실행
docker-compose up --build frontend
docker-compose up --build backend

# 서비스 중지
docker-compose down
```

### 3. 접속 정보
- Frontend: http://localhost:3000
- Backend: http://localhost:8080
- Database: localhost:5432

### 4. PostgreSQL 보안 설정
- 문제: "trust" 인증 방식 사용 경고
- 해결: SCRAM-SHA-256 인증 방식으로 변경

## 주요 문제 해결 사항

### 1. CORS 설정
- 문제: 프론트엔드에서 백엔드 API 호출 시 CORS 오류
- 해결: WebConfig에서 전역 CORS 설정 적용

### 2. Docker 볼륨 설정
- 문제: 백엔드 빌드 결과물이 볼륨 마운트로 덮어씌워지는 현상
- 해결: 소스 코드 마운트 제거 및 멀티 스테이지 빌드 적용

### 3. node_modules 관리
- Docker 컨테이너 내에서 node_modules를 관리하여 호스트와 컨테이너 간의 파일 시스템 차이로 인한 문제 방지
- 볼륨을 사용하여 의존성 관리 최적화

## 최근 업데이트 내용

### 1. 백엔드 구조 개선
- 패키지 구조 최적화 (계층형 구조 도입)
  - common: 공통 모듈 (설정, 예외처리)
  - domain: 도메인 모델과 엔티티
  - infrastructure: DB 설정
  - service: 비즈니스 로직
  - web: 컨트롤러와 DTO
- Controller와 Service 계층 분리
- API 응답 형식 표준화 (ApiResponse 도입)
- 전역 예외 처리 추가
- Swagger/OpenAPI 문서화 추가

### 2. Docker 설정 개선
- 서비스 의존성 최적화 (불필요한 의존성 제거)
- JDK 이미지를 eclipse-temurin:17-jdk-jammy로 변경
- 크로스 플랫폼 호환성 강화 (Mac M1/M2 지원)

## API 문서

### Swagger UI
- 접속 주소: http://localhost:8080/swagger-ui.html
- API 그룹:
  - Database: 데이터베이스 연결 체크 API
  - Hello: Hello API

### OpenAPI 문서
- JSON 형식: http://localhost:8080/api-docs

### API 문서화 특징
- 각 API의 상세 설명 제공
- 요청/응답 형식 자동 생성
- API 테스트 기능 제공
- 그룹별 API 분류

## 개발 시 주의사항
1. JDK 버전은 eclipse-temurin:17-jdk 사용 (크로스 플랫폼 호환성)
2. 데이터베이스 접속 정보는 application.yml 확인
3. 프론트엔드 개발 시 핫 리로드 지원
4. PostgreSQL 인증 방식: SCRAM-SHA-256 사용

## 향후 개선 계획
1. 프론트엔드 컴포넌트 구조 개선
2. 백엔드 테스트 코드 작성
3. 보안 설정 강화
4. 로깅 시스템 구축
