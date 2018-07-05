package com.fengye.handler;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.RequestContext;

import com.fengye.dao.DepartmentDAO;
import com.fengye.dao.EmployeeDAO;
import com.fengye.pojo.Employee;
import com.fengye.pojo.Person;

@Controller
public class EmployeHandler {
	private final String SUCCESS = "success";
	private final String INPUT = "input";

	@RequestMapping(value = "/allEmps", method = RequestMethod.GET)
	public String allEmps(Map<String, Object> map) {
		map.put("emps", EmployeeDAO.getAllEmps());
		return SUCCESS;
	}

	@RequestMapping(value = "/input/{id}", method = RequestMethod.GET)
	public String input(@PathVariable("id") Integer id, Map<String, Object> map) {
		// 获取所有的性别
		Map<Integer, Object> genders = new HashMap<Integer, Object>();
		genders.put(0, "Male");
		genders.put(1, "Female");
		map.put("genders", genders);
		Employee employee = new Employee();
		if (id != 0) {
			employee = EmployeeDAO.getEmpById(id);
		}
		map.put("abc", employee);
		// 获取所有的部门信息
		map.put("depts", DepartmentDAO.getAllDepts());
		return INPUT;
	}

	// 最后重定向到所有
	@RequestMapping(value = "/emp", method = RequestMethod.POST)
	public String add(Employee emp) {
		System.out.println("增加");
		EmployeeDAO.save(emp);
		return "redirect:/allEmps";
	}

	@RequestMapping(value = "/emp/{id}", method = RequestMethod.DELETE)
	public String delete(@PathVariable("id") Integer id) {
		EmployeeDAO.delete(id);
		return "redirect:/allEmps";
	}

	@ModelAttribute
	public void attri(Integer id, Map<String, Object> map) {
		if (id != null) {
			Employee emp = EmployeeDAO.getEmpById(id);
			map.put("employee", emp);
		}
	}

	@RequestMapping(value = "/emp", method = RequestMethod.PUT)
	public String update(Employee emp) {
		System.out.println("123333333333");
		EmployeeDAO.update(emp.getId(), emp);
		return "redirect:/allEmps";
	}

	/*
	 * 设置一个不能修改的参数 例如 name
	 */
	/*@InitBinder
	public void testInitBinder(WebDataBinder binder) {
		binder.setDisallowedFields("name");
	}*/

	@RequestMapping(value = "refresh")
	public String refresh() {
		return "index";
	}

	@RequestMapping("/testGlobal")
	public String testGlobal(HttpServletRequest request) {
		RequestContext context = new RequestContext(request);
		String message =  context.getMessage("user.name");
		System.out.println(message);
		return "success";
	}
	
/*	@RequestMapping("/testRequestBody")
	public void testRequestBody(@RequestBody List<Person> persons) {
		System.out.println(persons);
	}*/
	
	@ResponseBody
	@RequestMapping("/testRequestBody")
	public List<Person> testRequestBody1(@RequestBody List<Person> persons) {
		System.out.println(persons);
		return persons;
	}
	
	//文件上传
	@RequestMapping(value="/testFileUpload")
	public String testFileUpload(@RequestParam(value="file")MultipartFile file,@RequestParam(value="desc")String desc){
		System.out.println(desc);
		System.out.println("file name:"+file.getOriginalFilename());
		return "success";
	}
}
