package top.vikingyang.loverspace.schedule.job;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import top.vikingyang.loverspace.entity.common.EveryDayImage;
import top.vikingyang.loverspace.entity.common.enums.EveryDayImageStatusEnum;
import top.vikingyang.loverspace.service.common.EveryDayImageService;

@Component
public class EveryDayImageTask implements CustomJob {

    Logger logger = LoggerFactory.getLogger(EveryDayImageTask.class);

    private final EveryDayImageService everyDayImageService;

    @Autowired
    public EveryDayImageTask(EveryDayImageService everyDayImageService){
        this.everyDayImageService = everyDayImageService;
    }

    @Value("${schedule.everyDayImage}")
    private String corn;

    @Override
    public void execute(JobExecutionContext var1) throws JobExecutionException {
        if(everyDayImageService.checkHasTodayImage()){
            logger.info("============已存在当日图片数据，退出===============");
            return;
        }
        logger.info("============每日图片定时任务执行===============");
        EveryDayImage image = everyDayImageService.downloadTodayImage();
        image.setStatus(EveryDayImageStatusEnum.SUCCESS);
        everyDayImageService.updateByPrimaryKey(image);
        logger.info("================每日图片定时任务执行完成=================");
    }

    @Override
    public String getCorn() {
        return corn;
    }
}
