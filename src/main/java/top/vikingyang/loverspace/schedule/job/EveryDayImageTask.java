package top.vikingyang.loverspace.schedule.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class EveryDayImageTask implements CustomJob {

    Logger logger = LoggerFactory.getLogger(EveryDayImageTask.class);

    @Value("${schedule.everyDayImage}")
    private String corn;

    @Override
    public void execute(JobExecutionContext var1) throws JobExecutionException {
        logger.info("Hello {}", new Date());
    }

    @Override
    public String getCorn() {
        return corn;
    }
}
