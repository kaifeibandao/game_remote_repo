package com.kf.game.bean;

import java.io.Serializable;

public class Cart implements Serializable {
	private Integer id;
	private User  user;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Cart(Integer id, User user) {
		super();
		this.id = id;
		this.user = user;
	}
	@Override
	public String toString() {
		return id+"";
	}
		
	
}
