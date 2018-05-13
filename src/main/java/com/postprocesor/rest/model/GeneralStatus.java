package com.postprocesor.rest.model;

public class GeneralStatus {
	int code;
	String message;
	String details;
	
	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public GeneralStatus(int code, String message, String details) {
		this.code = code;
		this.message = message;
		this.details = details;
	}


}
