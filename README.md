# Vue.js + Spring Boot 샘플 프로젝트

## 개요
Vue.js 프론트엔드와 Spring Boot 백엔드를 Docker로 통합한 예제 프로젝트입니다. 이 프로젝트는 PostgreSQL을 데이터베이스로 사용하며, Docker를 통해 손쉽게 배포 및 실행할 수 있습니다.

## 기술 스택
- **프론트엔드**: Vue.js, Vite, Axios
- **백엔드**: Spring Boot
- **데이터베이스**: PostgreSQL 13
- **빌드 도구**: Maven, npm
- **컨테이너**: Docker, Docker Compose

## 시작하기

### 사전 요구사항
- Docker
- Docker Compose

### 설치 및 실행
```bash
# 프로젝트 클론
git clone [repository-url]

# DB 비밀번호 설정
echo "your_password" > db_password.txt

# 서비스 실행
docker-compose up --build
```

### 접속 정보
- **프론트엔드**: [http://localhost:3000](http://localhost:3000)
- **백엔드**: [http://localhost:8080](http://localhost:8080)
- **데이터베이스**: localhost:5432
- **Swagger UI**: [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

## 프로젝트 구조
```
.
├── frontend/                # Vue.js 프론트엔드
│   ├── src/
│   │   ├── components/     # Vue 컴포넌트
│   │   ├── services/       # API 서비스 모듈
│   │   └── App.vue         # 루트 컴포넌트
│   └── vite.config.js      # Vite 설정
├── backend/                # Spring Boot 백엔드
│   └── src/
│       └── main/
│           └── java/
│               └── com/example/sample_vue_spring/
│                   ├── common/        # 공통 모듈
│                   ├── domain/        # 도메인 모델
│                   ├── infrastructure/# 인프라 설정
│                   ├── service/       # 비즈니스 로직
│                   └── web/           # API 엔드포인트
└── docker-compose.yml     # Docker 설정
```

## Docker 관리

### 기본 명령어
```bash
# 서비스 시작
docker-compose up --build

# 서비스 중지
docker-compose down

# 특정 서비스만 실행
docker-compose up --build frontend
docker-compose up --build backend
```

### 캐시 및 리소스 정리
```bash
# 기본 캐시 정리
docker system prune

# 특정 서비스 재빌드
docker-compose build --no-cache [service-name]

# 전체 초기화 (데이터 삭제 주의)
docker-compose down --rmi all --volumes
```

## 개발 가이드

### 백엔드 개발
- JDK 17 사용 (eclipse-temurin:17-jdk-jammy)
- API 문서: Swagger/OpenAPI 사용
- 표준 응답 형식: `ApiResponse` 클래스 사용
- 계층형 아키텍처 준수

### 프론트엔드 개발
- Node.js LTS 버전 사용
- 핫 리로드 지원
- API 통신: Axios 인스턴스 사용
- 컴포넌트 기반 개발

### 보안 설정
- CORS: 백엔드 `WebConfig`에서 설정
- DB 인증: SCRAM-SHA-256 사용
- 환경변수: `.env` 파일 사용

## 문제 해결

### 일반적인 문제
1. CORS 오류
   - `WebConfig`에서 CORS 설정 확인
   
2. 빌드 실패
   - Docker 캐시 정리 후 재시도
   - 의존성 버전 확인

3. 볼륨 마운트 문제
   - Docker 볼륨 정리 후 재시도
   - 호스트-컨테이너 권한 확인

### 주의사항
- 운영 환경에서 볼륨 삭제 주의
- 프로덕션 배포 전 보안 설정 검토
- API 키와 비밀번호 관리 주의
