package top.vikingyang.lovinglambs.rest.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.vikingyang.lovinglambs.entity.common.EveryDayImage;
import top.vikingyang.lovinglambs.service.common.EveryDayImageService;

@RestController
@RequestMapping("/rest/everyDayImage")
public class EveryDayImageController {

    private final EveryDayImageService everyDayImageService;

    @Autowired
    public EveryDayImageController(EveryDayImageService everyDayImageService){
        this.everyDayImageService = everyDayImageService;
    }

    /**
     * 获取当日图片URL
     * @return 图片URL
     */
    @GetMapping("/get")
    public String getImage(){
        EveryDayImage image = everyDayImageService.findTodayRecord();
        return image.getUrl();
    }
}
