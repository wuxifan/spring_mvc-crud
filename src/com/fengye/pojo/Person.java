package com.fengye.pojo;

public class Person {
	private String qname;
	private Integer age;

	public Integer getAge() {
		return age;
	}

	public String getQname() {
		return qname;
	}

	public void setQname(String qname) {
		this.qname = qname;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Person [name=" + qname + ", age=" + age + "]";
	}
	
}
