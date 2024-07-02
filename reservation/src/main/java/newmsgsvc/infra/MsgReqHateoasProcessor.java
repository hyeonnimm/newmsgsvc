package newmsgsvc.infra;

import newmsgsvc.domain.*;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;

@Component
public class MsgReqHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<MsgReq>> {

    @Override
    public EntityModel<MsgReq> process(EntityModel<MsgReq> model) {
        return model;
    }
}
