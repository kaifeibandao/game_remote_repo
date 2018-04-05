package com.kf.game.bean;

import java.io.Serializable;

public class User implements Serializable{
	private Integer userId;
	private String name;
	
	
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public User(Integer userId, String name) {
		super();
		this.userId = userId;
		this.name = name;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public String toString() {
		return "用户id："+userId+"  用户名:"+name;
	}
	
}
