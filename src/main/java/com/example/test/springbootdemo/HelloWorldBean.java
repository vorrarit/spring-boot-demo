package com.example.test.springbootdemo;

public class HelloWorldBean {	

	private String message;

	public HelloWorldBean(String message) {
		setMessage(message);
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return this.message;
	}
}