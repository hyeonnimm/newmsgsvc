package newmsgsvc.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;
import newmsgsvc.infra.AbstractEvent;

@Data
public class Reserved extends AbstractEvent {

    private Long id;
    private String userName;
    private String MsgContent;
    private String Status;
}
