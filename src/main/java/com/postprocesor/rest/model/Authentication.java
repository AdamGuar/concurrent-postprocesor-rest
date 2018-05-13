package com.postprocesor.rest.model;

public class Authentication {
	
	User user;
	boolean isPasswordCorrect;
	
	
	
	public User getUser() {
		return user;
	}



	public void setUser(User user) {
		this.user = user;
	}



	public boolean isPasswordCorrect() {
		return isPasswordCorrect;
	}



	public void setPasswordCorrect(boolean isPasswordCorrect) {
		this.isPasswordCorrect = isPasswordCorrect;
	}

	

	public Authentication() {
	}

	public Authentication(User user, boolean isPasswordCorrect) {
		this.user = user;
		this.isPasswordCorrect = isPasswordCorrect;
	}
	
	
}
