package newmsgsvc.infra;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.naming.NameParser;
import javax.naming.NameParser;
import javax.transaction.Transactional;
import newmsgsvc.config.kafka.KafkaProcessor;
import newmsgsvc.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

//<<< Clean Arch / Inbound Adaptor
@Service
@Transactional
public class PolicyHandler {

    @Autowired
    MsgReqRepository msgReqRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='MsgSent'"
    )
    public void wheneverMsgSent_UpdateStatus(@Payload MsgSent msgSent) {
        MsgSent event = msgSent;
        System.out.println(
            "\n\n##### listener UpdateStatus : " + msgSent + "\n\n"
        );

        // Sample Logic //
        MsgReq.updateStatus(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='SendFailed'"
    )
    public void wheneverSendFailed_UpdateStatus(
        @Payload SendFailed sendFailed
    ) {
        SendFailed event = sendFailed;
        System.out.println(
            "\n\n##### listener UpdateStatus : " + sendFailed + "\n\n"
        );

        // Sample Logic //
        MsgReq.updateStatus(event);
    }
}
//>>> Clean Arch / Inbound Adaptor
