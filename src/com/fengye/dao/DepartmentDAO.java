package com.fengye.dao;

import java.util.HashMap;
import java.util.Map;

import com.fengye.pojo.Department;

public class DepartmentDAO {
	private static Map<Integer, Department> depts;
	static {
		depts = new HashMap<Integer,Department>();
		depts.put(1,new Department(1,"SALES"));
		depts.put(2,new Department(2,"HR"));
	}
	public static Map<Integer, Department> getAllDepts() {
		return depts;
	}
	public static Department getDeptById(Integer id) {
		return depts.get(id);
	}
}
