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


## Microservice, SOA

## Spring Cloud
