package com.oracle.filter;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.oracle.listener.ApplicationListener;
import com.oracle.util.Constant;

public class AutoLoginInterceptor implements HandlerInterceptor{
	
	/*@Autowired
	UserBiz userBiz;
	
	@Autowired
	UserAuthBiz userAuthBiz;*/
	
	@Override
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object arg2) throws Exception {
		
		/*HttpSession session=request.getSession();
		User user=(User)session.getAttribute(Constant.LOGIN_USER);
		if(user != null){
			//已登录
			return true;
		}
		System.out.println("自动登录..................");
		//未登录
		//读cookie
		Cookie []cookies=request.getCookies();
		if(cookies != null){
			//遍历客户端所有的cookies
			for(Cookie c:cookies){
				if("username".equals(c.getName())){
					//取出用户名的值
					String username=c.getValue();
					//做自动登录
					User userData=userBiz.isUser(username);
					//放入到session当中
					session.setAttribute(Constant.LOGIN_USER, userData);
					
					//往session中放用户所拥有的权限
					//查询用户已拥有的权限
					//List<UserAuth> userAuthList=userAuthBiz.selectByUser(userData.getId());
					List<String> authList = userBiz.listAllAuth(userData.getId());
					//装用户已拥有的权限
					Set<String> ownSet=new HashSet<String>();
					for(UserAuth userAuth:userAuthList){
						ownSet.add(userAuth.getTabAuth().getaUrl());
					}
					Set<String> ownSet=new HashSet<String>(authList);
					
					session.setAttribute(Constant.LOGIN_USER_AUTH, ownSet);
					
					//往在线列表放入用户
					Map<String, User> onlineMap=(Map<String, User>)session.getServletContext().getAttribute(ApplicationListener.USER_ONLINE_MAP);
					onlineMap.put(session.getId(), userData);
				}
			}
		}*/
		
		return true;
	}

}
