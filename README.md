# Table of contents

- [예제 - 음식배달](#---)
  - [서비스 시나리오](#서비스-시나리오)
  - [분석/설계](#분석설계)
  - [구현:](#구현-)
    - [DDD 의 적용](#ddd-의-적용)
    - [폴리글랏 퍼시스턴스](#폴리글랏-퍼시스턴스)
    - [폴리글랏 프로그래밍](#폴리글랏-프로그래밍)
    - [동기식 호출 과 Fallback 처리](#동기식-호출-과-Fallback-처리)
    - [비동기식 호출 과 Eventual Consistency](#비동기식-호출-과-Eventual-Consistency)
  - [운영](#운영)
    - [CI/CD 설정](#cicd설정)
    - [동기식 호출 / 서킷 브레이킹 / 장애격리](#동기식-호출-서킷-브레이킹-장애격리)
    - [오토스케일 아웃](#오토스케일-아웃)
    - [무정지 재배포](#무정지-재배포)
  - [신규 개발 조직의 추가](#신규-개발-조직의-추가)

# 서비스 시나리오

기능적 요구사항
1. 고객이 메시지 예약 발송을 등록한다.
1. 예약이 되면 예약 내역이 시스템에 저장된다.
1. 예약시간이 되면 착신자 리스트의 순서대로 메시지 발송이 처리된다.
1. 메시지 발송에 성공하면 해당 건에 대한 과금을 집계한다.
1. 메시지 발송에 실패하면 해당 건에 대한 과금을 집계하지 않는다.
1. 발송 결과를 수신(성공/실패)하면 해당 건에 대한 통계를 집계한다.
1. 발송 및 결과를 수신(성공/실패)하면 해당 예약에 대한 상태를 업데이트한다.
1. 고객이 처리상태를 중간중간 조회한다

비기능적 요구사항
1. 트랜잭션
    1. 매 건에 대한 과금과 통계는 반드시 집계되어야 한다
1. 성능
    1. 고객이 실시간으로 예약 건에 대한 상태를 Dashboard(프론트엔드)에서 확인할 수 있어야 한다  CQRS
    1. 배달상태가 바뀔때마다 카톡 등으로 알림을 줄 수 있어야 한다  Event driven

# 분석/설계



1) 분산트랜잭션 - Saga



   
2) 보상처리 - compensation






3) 단일 진입점 - gateway





  
4) 분산 데이터 프로젝션 - CQRS





























####################################################################################################################


## Model
www.msaez.io/#/170282165/storming/msgservice

## Before Running Services
### Make sure there is a Kafka server running
```
cd kafka
docker-compose up
```
- Check the Kafka messages:
```
cd infra
docker-compose exec -it kafka /bin/bash
cd /bin
./kafka-console-consumer --bootstrap-server localhost:9092 --topic
```

## Run the backend micro-services
See the README.md files inside the each microservices directory:

- reservation
- send
- stat
- monitoring


## Run API Gateway (Spring Gateway)
```
cd gateway
mvn spring-boot:run
```

## Test by API
- reservation
```
 http :8088/msgReqs id="id" userId="userId" msgTitle="MsgTitle" msgContent="MsgContent" reserveDt="ReserveDt" dstNum="DstNum" callbackNum="CallbackNum" reserveQt="ReserveQt" status="status" 
```
- send
```
 http :8088/msgs id="id" reservationId="ReservationId" msgTitle="MsgTitle" msgContent="MsgContent" reserveDt="ReserveDt" dstNum="DstNum" callbackNum="CallbackNum" status="status" 
```
- stat
```
 http :8088/stats id="id" userId="userId" rate="Rate" history="history" stat="stat" 
```
- monitoring
```
```


## Run the frontend
```
cd frontend
npm i
npm run serve
```

## Test by UI
Open a browser to localhost:8088

## Required Utilities

- httpie (alternative for curl / POSTMAN) and network utils
```
sudo apt-get update
sudo apt-get install net-tools
sudo apt install iputils-ping
pip install httpie
```

- kubernetes utilities (kubectl)
```
curl -LO "https://dl.k8s.io/release/$(curl -L -s https://dl.k8s.io/release/stable.txt)/bin/linux/amd64/kubectl"
sudo install -o root -g root -m 0755 kubectl /usr/local/bin/kubectl
```

- aws cli (aws)
```
curl "https://awscli.amazonaws.com/awscli-exe-linux-x86_64.zip" -o "awscliv2.zip"
unzip awscliv2.zip
sudo ./aws/install
```

- eksctl 
```
curl --silent --location "https://github.com/weaveworks/eksctl/releases/latest/download/eksctl_$(uname -s)_amd64.tar.gz" | tar xz -C /tmp
sudo mv /tmp/eksctl /usr/local/bin
```

