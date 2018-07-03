package com.oracle.util;

public class Constant {

	//重定向
	public static final String RESPONSE_TYPE_REDIRECT = "redirect";
	
	//用户注册时,激活时间
	public static final long USER_ACTIVE_INTERVAL = 1000 * 60 * 3;
	
	//用户找回密码时,有效时间
	public static final long USER_BACK_PWD_INTERVAL = 1000 * 60 * 3;
	
	//登录用户
	public static final String LOGIN_USER = "LoginUser";
	
	//当前登录用户拥有的权限的路径
	public static final String LOGIN_USER_AUTH="LoginUser_Auth";
	
	//session  
	public static final String DELIVERY_SESSIONID="DeliverySessionId";
}
