package newmsgsvc.infra;

import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import newmsgsvc.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//<<< Clean Arch / Inbound Adaptor

@RestController
@RequestMapping(value="/msgReqs")
@Transactional
public class MsgReqController {

    @Autowired
    MsgReqRepository msgReqRepository;
}
//>>> Clean Arch / Inbound Adaptor
