
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
1. 메시지 길이가 10을 넘으면 메시지를 처리하지 않는다. compensation 시험을 위한 요구사항

비기능적 요구사항
1. 트랜잭션
    1. 매 건에 대한 과금과 통계는 반드시 집계되어야 한다
1. 성능
    1. 고객이 실시간으로 예약 건에 대한 상태를 Dashboard(프론트엔드)에서 확인할 수 있어야 한다  CQRS

# 아키텍쳐
하기와 같이 아키텍처를 수립하여 프로젝트를 착수했다.
![arch](https://github.com/hyeonnimm/newmsgsvc/assets/170282165/f50df5b1-41de-48fb-aef2-b4a5098c57ae)


# 모델링
하기와 같은 구조로 이벤트스토밍을 진행하였다.
![msa](https://github.com/hyeonnimm/newmsgsvc/assets/170282165/c81ab26e-e33d-49f3-9b6f-508061875ce7)

# 개발
1) 분산트랜잭션 - Saga

좌측과 같이 POST를 통해 reserved 이벤트를 trigger하면, 우측과 같이 kafka에 이벤트가 발행됨을 확인할 수 있다.

![saga](https://github.com/hyeonnimm/newmsgsvc/assets/170282165/6d261231-44e8-4afa-a7a3-f75ad775a747)

   
2) 보상처리 - compensation


3) 단일 진입점 - gateway

![gateway](https://github.com/hyeonnimm/newmsgsvc/assets/170282165/fa8cecc8-8adc-4268-bd5f-299afc0d932c)



4) 분산 데이터 프로젝션 - CQRS
하기 그림과 같이 Dashboard Readmodel을 설계하였다.
해당 Dashboard엔 reserved 이벤트의 발행 시에 생성되고 MsgSent,SendFailed 이벤트 발행 시 update되어, 데이터 현행화가 비동기적으로 이루어진다.

![CQRS1](https://github.com/hyeonnimm/newmsgsvc/assets/170282165/43507925-1f01-4799-91a0-f0bb4153e3a7)

하기 그림과 같이 reserved 이벤트를 발행하면, Dashboard의 데이터가 변경됨을 확인할 수 있다.
![CQRS2](https://github.com/hyeonnimm/newmsgsvc/assets/170282165/508d53f6-ceb3-417f-aae7-48aee94f31c8)


# 운영

1) 클라우드 배포 - container 운영
Amazon ECR에 이미지를 배포하였다.
![배포](https://github.com/hyeonnimm/newmsgsvc/assets/170282165/5161bd08-496f-4f9e-a1a6-af3a9551b634)

2) 컨테이너 자동확장 - HPA



3) 컨테이너로부터 환경분리 -  ConfigMap
configmap 분리를 통해 별도의 배포 없이 설정을 관리할 수 있도록 구성하였다.
![configmap](https://github.com/hyeonnimm/newmsgsvc/assets/170282165/beb61d58-7d56-4a14-97c8-0812b4299283)

4) 클라우드스토리지 활용 - PVC
PVC 생성 및 POD로의 연결을 통해 NFS 볼륨 정책을 관리하고자 했다.
하지만 POD로의 연결은 실패하였다
![pvc](https://github.com/hyeonnimm/newmsgsvc/assets/170282165/27a68d55-5726-4800-8d09-dcf305fdd11c)

6) 셀프 힐링/무정지 배포
셀프 힐링 liveness 방법론 중 가장 기본적인 Command 방법론을 적용해 보았다.
임의적으로 정책 실패를 야기하여 unhealthy한 상태를 만들어보았다.
![liveness](https://github.com/hyeonnimm/newmsgsvc/assets/170282165/f5dfd454-28c7-4f9e-9b92-9c62380adb9c)

8) 서비스 메쉬 운용 - Mesh

9) 통합 모니터링 - Loggregation
Loki stack을 구축하여 grafana 대쉬보드를 통한 모니터링을 하도록 했다.
msg 파드에 찍히는 로그이다.

![grafana](https://github.com/hyeonnimm/newmsgsvc/assets/170282165/41fe636c-6595-4197-8550-374811331f20)





















