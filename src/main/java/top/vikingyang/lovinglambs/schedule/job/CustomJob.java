package top.vikingyang.lovinglambs.schedule.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public interface CustomJob extends Job {

    void execute(JobExecutionContext var1) throws JobExecutionException;

    String getCorn();

    boolean isEnabled();
}
