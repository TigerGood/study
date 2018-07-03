package com.oracle.listener;

import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;


public class ApplicationListener implements ServletContextListener{

	//用来记录注册时随机码与用户id之间的关系
	public static final String USER_CODE_MAP = "userCodeMap";
	
	//在线用户
	public static final String USER_ONLINE_MAP = "userOnlineMap";
	
	//所有权限访问地址
	public static final String AUTH_SET = "auth_set";
	
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void contextInitialized(ServletContextEvent event) {
		
		//获取application
		ServletContext application=event.getServletContext();
		//用来记录注册时随机码与用户id之间的关系
		application.setAttribute("userCodeMap", new HashMap<String, Integer>());
		//用来记录在线用户
		application.setAttribute("userOnlineMap", new LinkedHashMap<String, Integer>());
		//放所有权限到application当中
		WebApplicationContext webApplicationContext= WebApplicationContextUtils.getWebApplicationContext(application);
		
		System.out.println("application监听器已启动...........................");
	}

}
