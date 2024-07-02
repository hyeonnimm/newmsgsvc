package newmsgsvc.domain;

import newmsgsvc.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//<<< PoEAA / Repository
@RepositoryRestResource(collectionResourceRel = "msgLists", path = "msgLists")
public interface MsgListRepository
    extends PagingAndSortingRepository<MsgList, Long> {}
