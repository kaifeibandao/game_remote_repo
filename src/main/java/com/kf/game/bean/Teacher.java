package com.kf.game.bean;

import java.io.Serializable;

public class Teacher implements Serializable {
	
	private Integer number;
	private String name;
	private Integer age;
	
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Teacher(Integer number, String name, Integer age) {
		super();
		this.number = number;
		this.name = name;
		this.age = age;
	}
	public Teacher() {
	}
	
}
