package top.vikingyang.loverspace.schedule;

import liquibase.pro.packaged.A;
import org.quartz.*;
import org.quartz.impl.triggers.CronTriggerImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import top.vikingyang.loverspace.schedule.job.CustomJob;

import java.util.Map;

@Component
public class QuartzStartUp {

    Logger logger = LoggerFactory.getLogger(QuartzStartUp.class);

    @Autowired
    public QuartzStartUp(Scheduler scheduler, ApplicationContext context){
        Map<String, CustomJob> jobMap = context.getBeansOfType(CustomJob.class);
        jobMap.forEach((name, job) -> {
            if(job.isEnabled()){
                this.addJobAndTrigger(name, job, scheduler);
            }
        });
    }


    private void addJobAndTrigger(String name, CustomJob job, Scheduler scheduler){

        JobDetail jobDetail = JobBuilder.newJob(job.getClass())
                .withIdentity(name, name)
                .build();

        CronTrigger trigger = TriggerBuilder.newTrigger()
                .withIdentity(name, name)
                .withSchedule(CronScheduleBuilder.cronSchedule(job.getCorn()))
                .build();

        try{
            scheduler.scheduleJob(jobDetail, trigger);
        }
        catch (Exception e){
            logger.error("Job Add Error!", e);
        }
    }


}
