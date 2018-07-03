package com.oracle.util;

import java.util.Date;


//@Component
public class TimerTask {
	
	//启动计时器
	//@Scheduled(cron="*/5 * * * * ?")
	public void start(){
		System.out.println("计时器启动了。。。。。。。。。。。。。。。。");
		System.out.println(new Date());
	}
	
}
