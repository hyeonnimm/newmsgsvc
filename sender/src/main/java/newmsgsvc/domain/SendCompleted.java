package newmsgsvc.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import newmsgsvc.domain.*;
import newmsgsvc.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class SendCompleted extends AbstractEvent {

    private Long id;
    private String userName;
    private String msgContent;
    private String status;

    public SendCompleted(MsgList aggregate) {
        super(aggregate);
    }

    public SendCompleted() {
        super();
    }
}
//>>> DDD / Domain Event
