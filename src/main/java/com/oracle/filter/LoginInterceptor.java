package com.oracle.filter;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import com.oracle.util.Constant;

public class LoginInterceptor implements HandlerInterceptor{
	
	//不检查的地址
	List<String> uncheckUrls;
	

	@Override
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		System.out.println("目标被调用之后,视图完成解析.................");
		
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
		System.out.println("目标被调用之后,但是视图尚未完成解析.................");
		
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object arg2) throws Exception {
		//目标被调用之前(controller 当中的方法(action)被调用之前)
		System.out.println("目标被调用之前.................");
		//当前请求和路径
		String uri=request.getRequestURI();
		uri=uri.replace(request.getContextPath(), "");
		//不检查的列表里是否包当前地址
		if(uncheckUrls.contains(uri)){
			//放目标过去
			return true;
		}
		
		//校验登状态
		/*HttpSession session = request.getSession();
		User user=(User)session.getAttribute(Constant.LOGIN_USER);
		if(user == null){
			//未登录,重定向登录
			response.sendRedirect(request.getContextPath() + "/users/login");
			return false;
		}*/
		
		return true;
	}

	//Getters and Setters
	public void setUncheckUrls(List<String> uncheckUrls) {
		this.uncheckUrls = uncheckUrls;
	}

}
