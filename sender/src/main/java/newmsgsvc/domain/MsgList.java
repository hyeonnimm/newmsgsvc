package newmsgsvc.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import newmsgsvc.SenderApplication;
import newmsgsvc.domain.MsgSent;
import newmsgsvc.domain.SendFailed;

@Entity
@Table(name = "MsgList_table")
@Data
//<<< DDD / Aggregate Root
public class MsgList {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String userName;

    private String msgContent;

    private String status;

    @PostPersist
    public void onPostPersist() {}

    @PostUpdate
    public void onPostUpdate() {
        MsgSent msgSent = new MsgSent(this);
        msgSent.publishAfterCommit();

        SendFailed sendFailed = new SendFailed(this);
        sendFailed.publishAfterCommit();
    }

    public static MsgListRepository repository() {
        MsgListRepository msgListRepository = SenderApplication.applicationContext.getBean(
            MsgListRepository.class
        );
        return msgListRepository;
    }

    //<<< Clean Arch / Port Method
    public static void reqSend(Reserved reserved) {
        //implement business logic here:

        repository().findById(reserved.getMsgId()).ifPresent(msgList->{
            
            if(10 >= reserved.getMsgContent().length()){
                repository().save(msgList);

                MsgSent msgSent = new MsgSent(msgList);
                msgSent.setReservationId(reserved.getId());
                msgSent.publishAfterCommit();

            }else{
                SendFailed sendFailed  = new SendFailed(msgList);
                sendFailed.setReservationId(reserved.getId());
                sendFailed.publishAfterCommit();
            }
         
        });

    }

}
//>>> DDD / Aggregate Root
