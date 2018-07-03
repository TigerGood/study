package com.oracle.util;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;


/**
 * 工具类
 */
public class Util {
	
	//获取日志记录器
	private static Logger logger = Logger.getLogger(Util.class);
	
	/**
	 * 取application
	 */
	public static ServletContext getServletContext(){
		
		//获取request
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		
		return request.getServletContext();
	}
	
	/**
	 * 从application当中取值
	 */
	public static Object getApplicationOjbect(String key){
		
		//获取request
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		
		//获取application
		ServletContext application =  request.getServletContext();
		
		return application.getAttribute(key);
	}
	
	
	/**
	 * 往application当中放值
	 */
	public static void putApplication(String key,Object value){
		
		//获取request
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		
		//获取application
		ServletContext application =  request.getServletContext();
		
		application.setAttribute(key, value);
	}

}
