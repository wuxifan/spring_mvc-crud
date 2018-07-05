package com.fengye.dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.fengye.pojo.Department;
import com.fengye.pojo.Employee;

public class EmployeeDAO {
	private static Map<Integer, Employee> emps;
	static {
		emps = new HashMap<Integer,Employee>();
		emps.put(101, new Employee(101,"AA","AA@qq.com",0,DepartmentDAO.getDeptById(2)));
		emps.put(102, new Employee(102,"BB","BB@qq.com",1,DepartmentDAO.getDeptById(1)));
		emps.put(103, new Employee(103,"CC","CC@qq.com",0,DepartmentDAO.getDeptById(2)));
		emps.put(104, new Employee(104,"DD","DD@qq.com",1,DepartmentDAO.getDeptById(1)));
		emps.put(105, new Employee(105,"EE","EE@qq.com",0,DepartmentDAO.getDeptById(2)));
	}
	//��ȡ���е�Ա�� Map����
	//Ŀ��success.jspҳ�浱�л�ȡ����������  1.ԭ��<% %> 2.JSTL foreach һ��ʹ��2 ������jstl/core
	//��Mapת����Collection
	public static Collection<Employee> getAllEmps() {
		return emps.values();
	}
	
	public static Employee getEmpById(Integer id) {
		return emps.get(id);
	}
	
	private static Integer key = 106;
	public static void  save(Employee emp) {
		emp.setId(key);
		emp.setDept(DepartmentDAO.getDeptById(emp.getDept().getDeptId()));
		emps.put(key++, emp);
	}
	public static void delete(Integer id) {
		emps.remove(id);
	}
	public static void update(Integer id ,Employee emp) {
		emp.setDept(DepartmentDAO.getDeptById(emp.getDept().getDeptId()));
		emps.put(id, emp);
	}
}
