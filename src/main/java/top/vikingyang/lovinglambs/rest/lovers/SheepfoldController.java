package top.vikingyang.lovinglambs.rest.lovers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.vikingyang.lovinglambs.config.security.MyUserDetails;
import top.vikingyang.lovinglambs.entity.common.CommonResult;
import top.vikingyang.lovinglambs.rest.common.BaseController;
import top.vikingyang.lovinglambs.service.lovers.SheepfoldService;

@RestController
@RequestMapping("/rest/sheepfold")
public class SheepfoldController extends BaseController {

    @Autowired
    private SheepfoldService sheepfoldService;

    private static final Logger logger = LoggerFactory.getLogger(SheepfoldController.class);

    @GetMapping("/createSheepfold")
    public CommonResult<?> createSheepfold(Long inviterId, @AuthenticationPrincipal MyUserDetails myUserDetails){
        try{
            sheepfoldService.createSheepfold(inviterId, myUserDetails.getUser().getId());
            return new CommonResult<>();
        }
        catch (Exception e){
            logger.error("", e);
            return new CommonResult<>(0, this.getMessage("reload_message"));
        }
    }
}
