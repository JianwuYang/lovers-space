package top.vikingyang.loverspace.service.common.impl;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import top.vikingyang.loverspace.entity.common.EveryDayImage;
import top.vikingyang.loverspace.service.BaseTest;
import top.vikingyang.loverspace.service.common.EveryDayImageService;

import static org.junit.jupiter.api.Assertions.*;

class EveryDayImageServiceImplTest extends BaseTest {

    @Autowired
    private EveryDayImageService everyDayImageService;


    @Test
    public void test(){
        EveryDayImage image = new EveryDayImage();
        image.setImageDate("20200101");
        image.setCopyright("Copyright Test");
        image.setUrl("/testUrl");
        int i = everyDayImageService.insertSelective(image);
        assertEquals(i, 1);
    }

    @Test
    public void getImageTest(){

        EveryDayImage image = everyDayImageService.downloadTodayImage();

        assertNotNull(image.getImageData());
    }
}