package com.oracle.util;

import org.quartz.Job;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;


//@Component
public class Timer implements Job{

	//获取调度工厂
	//@Autowired
	SchedulerFactoryBean schedulerFactoryBean;
	
	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		// TODO Auto-generated method stub
		System.out.println("quartz计时器********************");
	}
	
	//添加计时器
	public void add(){
		
		//从SchedulerFactoryBean工厂获得调度器、
		Scheduler scheduler=schedulerFactoryBean.getScheduler();
		
		//调度任务
		JobDetail jobDetail = JobBuilder.newJob().withIdentity("conversation").build();
		
		//触发器
		Trigger trigger=TriggerBuilder.newTrigger().withIdentity("test1")
				.withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInMilliseconds(5 * 1000))
				.build();
		
		try {
			scheduler.scheduleJob(jobDetail, trigger);
		} catch (SchedulerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
