package newmsgsvc.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import newmsgsvc.domain.*;
import newmsgsvc.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class MsgSent extends AbstractEvent {

    private Long id;
    private String userName;
    private String msgContent;
    private String status;

    public MsgSent(MsgList aggregate) {
        super(aggregate);
    }

    public MsgSent() {
        super();
    }
}
//>>> DDD / Domain Event
