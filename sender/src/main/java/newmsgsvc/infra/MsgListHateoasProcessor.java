package newmsgsvc.infra;

import newmsgsvc.domain.*;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;

@Component
public class MsgListHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<MsgList>> {

    @Override
    public EntityModel<MsgList> process(EntityModel<MsgList> model) {
        return model;
    }
}
