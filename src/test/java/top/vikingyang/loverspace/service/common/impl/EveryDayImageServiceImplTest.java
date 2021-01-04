package top.vikingyang.loverspace.service.common.impl;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import top.vikingyang.loverspace.entity.common.EveryDayImage;
import top.vikingyang.loverspace.service.BaseTest;
import top.vikingyang.loverspace.service.common.EveryDayImageService;

import static org.junit.jupiter.api.Assertions.*;

class EveryDayImageServiceImplTest extends BaseTest {

    @Autowired
    private EveryDayImageService everyDayImageService;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Test
    public void test(){
        String a = passwordEncoder.encode("admin");
    }

    @Test
    public void getImageTest(){

        EveryDayImage image = everyDayImageService.downloadTodayImage();

        assertNotNull(image.getImageData());
    }
}