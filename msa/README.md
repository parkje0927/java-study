# Spring Cloud, Microservice

## Microservice

- Antifragile
    - Auto scaling
    - Microservices
    - Chaos engineering : 불확실성에서도 안정적인 서비스를 구축해야한다.
    - Continuous deployments : 지속적인 배포

## Cloud Native Architecture

- 확장 가능한 아키텍처 => 가상 서버의 기술이 핵심
    - 시스템의 수평적 확장에 유연
    - 확장된 서버로 시스템의 부하 분산, 가용성 보장
    - 시스템 또는 서비스 애플리케이션 단위의 패키지(컨테이너 기반 패키지)
    - 모니터링
- 탄력적 아키텍처
    - 서비스 생성/통합/배포, 비즈니스 환경 변화에 대응 시간 단축 => CI/CD
    - 분할된 서비스 구조
    - 무상태 통신 프로토콜
    - 서비스의 추가와 삭제 자동으로 감지
    - 변경된 서비스 요청에 따라 사용자 요청 처리(동적 처리)
- 장애 격리(Fault isolation)
    - 특정 서비스에 오류가 발생해도 다른 서비스에 영향 주지 않음.

<br>

- Cloud Native Application
    - Microservice 로 개발된다.
    - CI/CD 로 통합되고 빌드, 배포 된다.
    - 바로 수정해서 배포하는 과정 무한 반복 -> 고객이 원하는 서비스 제공 : DevOps
    - 클라우드 환경에 배포, 사용 : Container

### CI/CD

- CI : 지속적인 통합
    - 통합 서버, 소스 관리, 빌드 도구, 테스트 도구
- CD : 지속적인 배포
- 카나리 배포 : 95% 사용자는 이전 버전 서비스, 5% 사용자는 새 버전 서비스를 사용하게 한다.
- 블루그린 배포 : 점진적으로 이동

### DevOps

- 자주 개발, 통합, 테스트, 배포하는 구조

### Container 가상화

- 적은 비용으로 탄력성 높은 서비스 구축
- 기존 하드웨어/서버 가상화보다 적은 비용
- Container Deployment
    - 공통적인 라이브러리 공유
    - 적은 리소스 사용

### Factors

- 12 Factors : 클라우드 서비스 설계 시 고려해야 할 점, 가이드라인(https://12factor.net/)
    - Base Code
    - Dependency Isolation
    - Configurations
    - Linkable Backing Services
    - Stages of Creation
    - Stateless Processes
    - Port Binding
    - Concurrency
    - Disposablity
    - Development & Production Party
    - Logs
    - Admin Processes For Eventual Processes

## Microservice, SOA

### Monolithic vs MSA

- Monolithic
    - 개발에 필요한 모든 요소를 하나의 소프트웨어 안에 포함시켜서 개발
    - 모든 업무 로직이 하나의 애플리케이션 형태로 패키지 되어 서비스
    - 애플리케이션에서 사용하는 데이터가 한 곳에 모여 참조되어 서비스 되는 형태
    - 수정 시 다시 빌드하고 패키징되어야 한다.
- Microservice
    - 어플리케이션 구성하는 서비스 분리해서 개발하고 운영하는 방식
    - 유지보수, 변경사항 적용이 쉽다.
    - 비즈니스 로직 프로세스 변경되어 새로 개발 및 배포가 필요할 때, 필요한 부분만 개발하고 다른 서비스에 영향 최소화하고 독립적인 배포가 가능하다.
    - 작은 서비스들의 여러 서비스 묶음이다.
    - 자동화된 배포 서비스
    - 서비스의 크기가 도메인의 특성을 고려해서, 독립적인 언어와 데이터베이스를 사용할 수 있다.
    - 서비스별로 최적화된 언어, 데이터베이스 사용 권장
    - 하나의 Backend 가 아니라 의미있는 구분, 서비스 구분
- Front & Back
  - Front, Back 분리
  - Frontend Team / Backend, DevOps Team

## Spring Cloud
