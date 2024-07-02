package newmsgsvc.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import newmsgsvc.ReservationApplication;
import newmsgsvc.domain.Reserved;

@Entity
@Table(name = "MsgReq_table")
@Data
//<<< DDD / Aggregate Root
public class MsgReq {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String userName;

    private String msgContent;

    private String status;

    @PostPersist
    public void onPostPersist() {
        Reserved reserved = new Reserved(this);
        reserved.publishAfterCommit();
    }

    public static MsgReqRepository repository() {
        MsgReqRepository msgReqRepository = ReservationApplication.applicationContext.getBean(
            MsgReqRepository.class
        );
        return msgReqRepository;
    }

    //<<< Clean Arch / Port Method
    public static void updateStatus(SendCompleted sendCompleted) {
        //implement business logic here:

        /** Example 1:  new item 
        MsgReq msgReq = new MsgReq();
        repository().save(msgReq);

        */

        /** Example 2:  finding and process
        
        repository().findById(sendCompleted.get???()).ifPresent(msgReq->{
            
            msgReq // do something
            repository().save(msgReq);


         });
        */

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void updateStatus(MsgSent msgSent) {
        //implement business logic here:

        /** Example 1:  new item 
        MsgReq msgReq = new MsgReq();
        repository().save(msgReq);

        */

        /** Example 2:  finding and process
        
        repository().findById(msgSent.get???()).ifPresent(msgReq->{
            
            msgReq // do something
            repository().save(msgReq);


         });
        */

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void updateStatus(SendFailed sendFailed) {
        //implement business logic here:

        /** Example 1:  new item 
        MsgReq msgReq = new MsgReq();
        repository().save(msgReq);

        */

        /** Example 2:  finding and process
        
        repository().findById(sendFailed.get???()).ifPresent(msgReq->{
            
            msgReq // do something
            repository().save(msgReq);


         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
