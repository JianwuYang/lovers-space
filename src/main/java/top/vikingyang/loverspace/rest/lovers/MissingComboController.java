package top.vikingyang.loverspace.rest.lovers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.vikingyang.loverspace.entity.common.CommonResult;
import top.vikingyang.loverspace.entity.lovers.bo.MissingComboBo;
import top.vikingyang.loverspace.entity.lovers.vo.MissingComboVo;
import top.vikingyang.loverspace.rest.common.BaseController;
import top.vikingyang.loverspace.service.lovers.MissingComboService;

@RestController
@RequestMapping("/rest/missingCombo")
public class MissingComboController extends BaseController {

    @Autowired
    private MissingComboService missingComboService;

    private static final Logger logger = LoggerFactory.getLogger(MissingComboController.class);

    /**
     * 查找今日想念数据
     * @param lambId 小羊ID
     * @return 数据
     */
    @GetMapping("/findToday")
    private CommonResult<MissingComboBo> findToday(Long lambId){
        try{
            MissingComboBo missingComboBo = missingComboService.findByLambId(lambId);
            return new CommonResult<>(missingComboBo);
        }
        catch (Exception e){
            logger.error(this.getMessage("missing_combo_fetch_error"), e);
            return new CommonResult<>(0, this.getMessage("reload_message"));
        }
    }

    /**
     * 创建今日想念数据
     * @param missingComboVo 昨日数据
     * @return 结果
     */
    @PostMapping("/createToday")
    public CommonResult<?> createToday(MissingComboVo missingComboVo){
        try{
            missingComboService.createTodayMissing(missingComboVo);
            return new CommonResult<>(this.getMessage("missing_combo_create_success"));
        }
        catch (Exception e){
            logger.error(this.getMessage("missing_combo_create_failed"), e);
            return new CommonResult<>(0, this.getMessage("reload_message"));
        }
    }
}
