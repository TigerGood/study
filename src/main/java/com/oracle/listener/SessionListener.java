package com.oracle.listener;

import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.apache.log4j.Logger;

import com.oracle.util.Util;


public class SessionListener implements HttpSessionListener{

	//获取日志记录器
	private static Logger logger = Logger.getLogger(Util.class);
	
	@Override
	public void sessionCreated(HttpSessionEvent event) {
		System.out.println("session创建.................");
		
		HttpSession session=event.getSession();
		ServletContext application=session.getServletContext();
		
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent event) {
		System.out.println("session销毁.................");
		
		HttpSession session=event.getSession();
		String sessionID = session.getId();
		//String url =request.getContextPath()+ "/nbi/deliverysession?id=" + sessionID;
		logger.debug(new Date()+sessionID);
		
	}

}
