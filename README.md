﻿# sample-vue-spring

## 프로젝트 설명

이 프로젝트는 Vue.js 프론트엔드와 Spring Boot 백엔드를 통합한 예제 프로젝트입니다.

## 설정 및 실행 방법

### 프론트엔드 (Vue.js)

1. `frontend` 디렉토리로 이동:
   ```sh
   cd frontend
   ```

2. Docker Compose를 사용하여 프론트엔드 서버 실행:
    ```sh
    docker-compose up --build
    ```

### 백엔드 (Spring Boot)

1. 프로젝트 루트 디렉토리에서 Spring Boot 애플리케이션 실행:
    ```sh
    ./mvnw spring-boot:run
    ```

### Docker 사용 방법

1. Docker Compose를 사용하여 전체 애플리케이션 실행:
    ```sh
    docker-compose up --build
    ```

2. Docker Compose를 사용하여 특정 서비스만 실행:
    ```sh
    docker-compose up --build frontend
    docker-compose up --build backend
    ```

3. Docker Compose를 사용하여 서비스 중지:
    ```sh
    docker-compose down
    ```

### 주요 기능

- Vue.js를 사용한 프론트엔드 개발
- Spring Boot를 사용한 백엔드 개발
- Docker를 사용한 컨테이너화된 개발 환경

### node_modules를 볼륨에 추가한 이유

- Docker 컨테이너 내에서 node_modules를 관리하여, 호스트와 컨테이너 간의 파일 시스템 차이로 인한 문제를 방지 (참고: [TOAST UI 블로그](https://ui.toast.com/weekly-pick/ko_20160823))
