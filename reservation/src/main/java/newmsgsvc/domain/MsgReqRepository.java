package newmsgsvc.domain;

import java.util.Date;
import java.util.List;
import newmsgsvc.domain.*;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//<<< PoEAA / Repository
@RepositoryRestResource(collectionResourceRel = "msgReqs", path = "msgReqs")
public interface MsgReqRepository
    extends PagingAndSortingRepository<MsgReq, Long> {}
