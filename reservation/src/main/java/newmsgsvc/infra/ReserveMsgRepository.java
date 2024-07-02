package newmsgsvc.infra;

import java.util.List;
import newmsgsvc.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(
    collectionResourceRel = "reserveMsgs",
    path = "reserveMsgs"
)
public interface ReserveMsgRepository
    extends PagingAndSortingRepository<ReserveMsg, Long> {}
