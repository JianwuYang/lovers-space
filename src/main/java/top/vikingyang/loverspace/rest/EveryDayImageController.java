package top.vikingyang.loverspace.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.vikingyang.loverspace.entity.common.EveryDayImage;
import top.vikingyang.loverspace.service.common.EveryDayImageService;

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

    @GetMapping("/hello")
    public String sayHello(@AuthenticationPrincipal UserDetails userDetails){
        return "Hello " + userDetails.getUsername();
    }

}
