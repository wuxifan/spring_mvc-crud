package com.fengye.interceptor;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class MyInterceptor implements HandlerInterceptor {

	//��Ⱦ��ͼ֮�������õķ���
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
	}
	
	
	//����ҵ�񷽷�����֮�� ����Ⱦ��ͼ֮ǰ
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}
	
	//����ҵ�񷽷�������һ��������֮ǰ��Ҫִ�еķ���
	//�������ֵΪtrue ����������ִ����� ����ִ����һ�����ػ���ҵ�񷽷�
	//���false 
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("���뵽������������");
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
