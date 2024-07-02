package newmsgsvc.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import newmsgsvc.BoundedContext1410Application;
import newmsgsvc.domain.RateIncreased;
import newmsgsvc.domain.StatIncreased;

@Entity
@Table(name = "Stat_table")
@Data
//<<< DDD / Aggregate Root
public class Stat {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String userName;

    private String rate;

    private String stat;

    private String history;

    @PostPersist
    public void onPostPersist() {
        RateIncreased rateIncreased = new RateIncreased(this);
        rateIncreased.publishAfterCommit();

        StatIncreased statIncreased = new StatIncreased(this);
        statIncreased.publishAfterCommit();
    }

    public static StatRepository repository() {
        StatRepository statRepository = BoundedContext1410Application.applicationContext.getBean(
            StatRepository.class
        );
        return statRepository;
    }

    //<<< Clean Arch / Port Method
    public static void increaseRate(SendCompleted sendCompleted) {
        //implement business logic here:

        /** Example 1:  new item 
        Stat stat = new Stat();
        repository().save(stat);

        */

        /** Example 2:  finding and process
        
        repository().findById(sendCompleted.get???()).ifPresent(stat->{
            
            stat // do something
            repository().save(stat);


         });
        */

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void increaseStat(SendFailed sendFailed) {
        //implement business logic here:

        /** Example 1:  new item 
        Stat stat = new Stat();
        repository().save(stat);

        */

        /** Example 2:  finding and process
        
        repository().findById(sendFailed.get???()).ifPresent(stat->{
            
            stat // do something
            repository().save(stat);


         });
        */

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void increaseStat(SendCompleted sendCompleted) {
        //implement business logic here:

        /** Example 1:  new item 
        Stat stat = new Stat();
        repository().save(stat);

        */

        /** Example 2:  finding and process
        
        repository().findById(sendCompleted.get???()).ifPresent(stat->{
            
            stat // do something
            repository().save(stat);


         });
        */

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void increaseStat(MsgSent msgSent) {
        //implement business logic here:

        /** Example 1:  new item 
        Stat stat = new Stat();
        repository().save(stat);

        */

        /** Example 2:  finding and process
        
        repository().findById(msgSent.get???()).ifPresent(stat->{
            
            stat // do something
            repository().save(stat);


         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
