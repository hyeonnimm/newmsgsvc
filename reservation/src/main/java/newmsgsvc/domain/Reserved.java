package newmsgsvc.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import newmsgsvc.domain.*;
import newmsgsvc.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class Reserved extends AbstractEvent {

    private Long id;
    private String userName;
    private String msgContent;
    private String status;
    private Long msgId;

    public Reserved(MsgReq aggregate) {
        super(aggregate);
    }

    public Reserved() {
        super();
    }
}
//>>> DDD / Domain Event
