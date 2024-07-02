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
    MsgListRepository msgListRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='Reserved'"
    )
    public void wheneverReserved_ReqSend(@Payload Reserved reserved) {
        Reserved event = reserved;
        System.out.println("\n\n##### listener ReqSend : " + reserved + "\n\n");

        // Sample Logic //
        MsgList.reqSend(event);
    }
}
//>>> Clean Arch / Inbound Adaptor
