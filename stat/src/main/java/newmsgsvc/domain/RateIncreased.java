package newmsgsvc.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import newmsgsvc.domain.*;
import newmsgsvc.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class RateIncreased extends AbstractEvent {

    private Long id;

    public RateIncreased(Stat aggregate) {
        super(aggregate);
    }

    public RateIncreased() {
        super();
    }
}
//>>> DDD / Domain Event
