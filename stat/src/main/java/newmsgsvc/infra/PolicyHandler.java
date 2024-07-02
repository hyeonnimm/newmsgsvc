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
    StatRepository statRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='SendCompleted'"
    )
    public void wheneverSendCompleted_IncreaseRate(
        @Payload SendCompleted sendCompleted
    ) {
        SendCompleted event = sendCompleted;
        System.out.println(
            "\n\n##### listener IncreaseRate : " + sendCompleted + "\n\n"
        );

        // Sample Logic //
        Stat.increaseRate(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='SendFailed'"
    )
    public void wheneverSendFailed_IncreaseStat(
        @Payload SendFailed sendFailed
    ) {
        SendFailed event = sendFailed;
        System.out.println(
            "\n\n##### listener IncreaseStat : " + sendFailed + "\n\n"
        );

        // Sample Logic //
        Stat.increaseStat(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='SendCompleted'"
    )
    public void wheneverSendCompleted_IncreaseStat(
        @Payload SendCompleted sendCompleted
    ) {
        SendCompleted event = sendCompleted;
        System.out.println(
            "\n\n##### listener IncreaseStat : " + sendCompleted + "\n\n"
        );

        // Sample Logic //
        Stat.increaseStat(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='MsgSent'"
    )
    public void wheneverMsgSent_IncreaseStat(@Payload MsgSent msgSent) {
        MsgSent event = msgSent;
        System.out.println(
            "\n\n##### listener IncreaseStat : " + msgSent + "\n\n"
        );

        // Sample Logic //
        Stat.increaseStat(event);
    }
}
//>>> Clean Arch / Inbound Adaptor
