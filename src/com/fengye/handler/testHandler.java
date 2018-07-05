package com.fengye.handler;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fengye.pojo.Student;

@Controller
public class testHandler {
	/**
	    * ֱ�ӷ����ַ���
	    * @param teamname
	    * @param request
	    * @return
	    */
	    //�����·������ʽ
	    @RequestMapping(value = "v1.0/new/{teamname}", method = RequestMethod.GET)
	    @ResponseBody public String foo4(@PathVariable String teamname, HttpServletRequest request) {

	        //����ʹ��teamname��ȡurl·���ָ�

	        //��ȡ����Ĳ���
	        String name = request.getParameter("name");
	        String age = request.getParameter("age");

	        Student student = new Student(name, age);

	        return "123456";
	    }

	    /**
	    * ֱ�ӷ��ض����Զ�ת��ΪJSON��ʽ
	    * @param teamname
	    * @param request
	    * @return
	    */
	    @RequestMapping(value = "v2.0/new/{teamname}", method = RequestMethod.GET)
	    @ResponseBody public Student foo5(@PathVariable String teamname, HttpServletRequest request) {

	        //����ʹ��teamname��ȡurl·���ָ�

	        //��ȡ����Ĳ���
	        String name = request.getParameter("name");
	        String age = request.getParameter("age");

	        Student student = new Student(name, age);

	        return student;
	    }

	    /**
	    * ֱ�ӷ���List���Զ�ת��ΪJSON��ʽ
	    * @param teamname
	    * @param request
	    * @return
	    */
	    @RequestMapping(value = "v3.0/new/{teamname}", method = RequestMethod.GET)
	    @ResponseBody 
	    public List<Student> foo6(@PathVariable String teamname, HttpServletRequest request) {

	        //����ʹ��teamname��ȡurl·���ָ�

	        //��ȡ����Ĳ���
	        String name = request.getParameter("name");
	        String age = request.getParameter("age");

	        Student student = new Student(name, age);
	        Student student1 = new Student(name + name, age + age);

	        List<Student> list = new ArrayList<Student>();
	        list.add(student);
	        list.add(student1);
	        System.out.println(list);
	        return list;
	    }
}
