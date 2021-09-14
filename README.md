# springCloud

## 00. Spring Cloud architecture
  <img src="https://spring.io/images/cloud-diagram-dark-b902fd07e60945a9a8930ca01f86bdf3.svg" />

## 01. 웹서비스 확장 전략
  - 스프링 클라우드란?
  - 웹서비스 확장 전략
  - 스케일업 - 스케일 아웃 = 블루그린배포
  - 서버 부하 분산을 위한 네트워크
  - DNS 실습 및 host 설명
  - DNS 매핑 및 웹 서버 연동
  - Virtual IP
  - 읽기요청 부하 분산
  - 클러스터링과 레플리카
  - 샤딩
  - 쓰기 요청 분산
  - 메세지 큐

## 02. 스프링 클라우드
  - 스프링 클라우드 소개
  - 스프링 클라우드 프로젝트 세팅

## 03. 웹 API 통합을 위한 기숳
  - API 통합 기술 소개 (zuul, spring cloud gateeway)
  - spring cloud gateway 활용

## 04. 분산시스템관리를 위한 Discovery pattern
  - zookeeper와 eureka 소개
  - eurkea 활용

## 05. 쓰기요청 분산처리를 위한 메세지 큐 활용
  - 분산환경에서 쓰기 요청을 분산처리 하려면 어떻게 해야할까?
  - RabbitMQ와 Kafka 소개
  - spring cloud amqp를 이용한 rabbitmq 연동
  - spring cloud kafka를 이용한 kafka 연동

## 06. 분산환경에서 API Client 개발
  - Ribbon과 FeignClient
  - FeignClient를 이용한 API 연동
  - FeignClient와 eurkea 연동

## 07. 장애허용시스템 구축
  - resilience4j를 활용한 circuit breaker 패턴 적용

## 08. 구글 GCP 활용
  - 구글 GCP 소개
  - 구글 GCP 예제 컴포넌트 배포
  - 구글 GCP에 Spring Cloud 관련 기능 활용

## 09. 분산환경에서 서버설정 통합관리
  - 스프링 클라우드 컨피그 소개
  - 스프링 클라우드에서 컨피그를 연동하여 설정 정보 업데이트 관리
  - 스프링 클라우드 볼트를 이용한 설정정보 보안

## 10. 분산환경에서 모니터링
  - 스프링 클라우드 어드민을 이용한 모듈별 상태 관리
  - 분산환경에서 로깅을 위한 MDC
  - 스프링 클라우드의 슬루스와 집킨을 이용한 모니터링
