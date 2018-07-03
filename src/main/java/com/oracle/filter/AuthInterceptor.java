package com.oracle.filter;

import java.util.List;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.oracle.listener.ApplicationListener;
import com.oracle.util.Constant;

public class AuthInterceptor implements HandlerInterceptor{

	List<String> uncheckUrls; // 不检查的路径
	
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
		
		//当前访问的路径
		String nowUrl=request.getRequestURI();
		nowUrl=nowUrl.replace(request.getContextPath(), "");
	
		//检查是否是不受检的路径
		if(uncheckUrls.contains(nowUrl)){
			return true;
		}
		//查询所有受控的权限地址
		//获取application
		ServletContext application=request.getServletContext();
		Set<String> urlSet=(Set<String>)application.getAttribute(ApplicationListener.AUTH_SET);
		
		//当前访问地址是否是受控的地址
		if(urlSet.contains(nowUrl)){
			//表示受控,检查当前用户是否有此项权限
			//取当前登录用户拥有的权限(当前用户能访 问的所有地址)
			Set<String> loginUserUrlSet = (Set<String>)request.getSession().getAttribute(Constant.LOGIN_USER_AUTH);
			
			//当前访问地址是否被包含在用户能访问的地址里
			if(loginUserUrlSet.contains(nowUrl)){
				//放用户通过
				return true;
			}
		}else{
			//放用户通过
			return true;
		}
		response.sendRedirect(request.getContextPath()+"/users/noauth");
		//禁止用户通过
		return false;
	}

	//Getters and Setters
	public void setUncheckUrls(List<String> uncheckUrls) {
		this.uncheckUrls = uncheckUrls;
	}

}
