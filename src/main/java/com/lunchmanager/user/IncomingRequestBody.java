package com.lunchmanager.user;

public class IncomingRequestBody {
	
	private User user;
	private String name;
	private String surname;
	
	public IncomingRequestBody() {}
	
	public IncomingRequestBody(User user, String name, String surname) {
		super();
		this.user=user;
		this.name=name;
		this.surname=surname;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}

}
