package newmsgsvc.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import newmsgsvc.domain.*;
import newmsgsvc.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class StatIncreased extends AbstractEvent {

    private Long id;

    public StatIncreased(Stat aggregate) {
        super(aggregate);
    }

    public StatIncreased() {
        super();
    }
}
//>>> DDD / Domain Event
