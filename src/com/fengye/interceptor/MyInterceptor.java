package com.fengye.interceptor;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class MyInterceptor implements HandlerInterceptor {

	//渲染视图之后所调用的方法
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
	}
	
	
	//调用业务方法结束之后 在渲染视图之前
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}
	
	//调用业务方法或者下一个拦截器之前需要执行的方法
	//如果返回值为true 拦截器方法执行完毕 继续执行下一个拦截或者业务方法
	//如果false 
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("走入到拦截器方法中");
		Date date = new Date();
		int hour = date.getHours();
		if(hour>=9&&hour<=19) {
			return true;
		}else {
			response.sendRedirect("error.jsp");
			return false;
		}
	}
	
}
