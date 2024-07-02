package newmsgsvc.domain;

import java.util.*;
import lombok.*;
import newmsgsvc.domain.*;
import newmsgsvc.infra.AbstractEvent;

@Data
@ToString
public class SendCompleted extends AbstractEvent {

    private Long id;
    private String userName;
    private String msgContent;
    private String status;
}
