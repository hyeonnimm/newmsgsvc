
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

# 분석/설계


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


# 분석/설계























