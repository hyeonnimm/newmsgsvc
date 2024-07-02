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

        /** Example 1:  new item 
        MsgList msgList = new MsgList();
        repository().save(msgList);

        MsgSent msgSent = new MsgSent(msgList);
        msgSent.publishAfterCommit();
        SendFailed sendFailed = new SendFailed(msgList);
        sendFailed.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(reserved.get???()).ifPresent(msgList->{
            
            msgList // do something
            repository().save(msgList);

            MsgSent msgSent = new MsgSent(msgList);
            msgSent.publishAfterCommit();
            SendFailed sendFailed = new SendFailed(msgList);
            sendFailed.publishAfterCommit();

         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
