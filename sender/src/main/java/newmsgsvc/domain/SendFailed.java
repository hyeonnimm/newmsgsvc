package newmsgsvc.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import newmsgsvc.domain.*;
import newmsgsvc.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class SendFailed extends AbstractEvent {

    private Long id;
    private String userName;
    private String msgContent;
    private String status;
    private Long reservationId;

    public SendFailed(MsgList aggregate) {
        super(aggregate);
    }

    public SendFailed() {
        super();
    }
}
//>>> DDD / Domain Event
