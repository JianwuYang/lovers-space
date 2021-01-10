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
import top.vikingyang.lovinglambs.entity.lovers.bo.LambBo;
import top.vikingyang.lovinglambs.rest.common.BaseController;
import top.vikingyang.lovinglambs.service.lovers.LambsService;

@RestController
@RequestMapping("/rest/lambs")
public class LambsController extends BaseController {

    @Autowired
    private LambsService lambsService;

    private static final Logger logger = LoggerFactory.getLogger(LambsController.class);


    @GetMapping("/findMyLamb")
    public CommonResult<LambBo> findMyLamb(@AuthenticationPrincipal MyUserDetails myUserDetails){
        try{
            LambBo lambBo = lambsService.findMyLamb(myUserDetails.getUser().getId());
            return new CommonResult<>(lambBo);
        }
        catch (Exception e){
            logger.error("", e);
            return new CommonResult<>(0, this.getMessage("reload_message"));
        }
    }

}
