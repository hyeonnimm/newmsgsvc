package newmsgsvc.infra;

import newmsgsvc.domain.*;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;

@Component
public class StatHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<Stat>> {

    @Override
    public EntityModel<Stat> process(EntityModel<Stat> model) {
        return model;
    }
}
