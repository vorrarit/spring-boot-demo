package com.example.test.springbootdemo;

import java.util.Date;

public class ExceptionResponse {
	private Date timestamp;
	private String message;
	private String detail;

	public ExceptionResponse() {

	}

	public ExceptionResponse(Date timestamp, String message, String detail) {
		this.timestamp = timestamp;
		this.message = message;
		this.detail = detail;
	}

	/**
	 * @return the timestamp
	 */
	public Date getTimestamp() {
		return timestamp;
	}

	/**
	 * @param timestamp the timestamp to set
	 */
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return the detail
	 */
	public String getDetail() {
		return detail;
	}

	/**
	 * @param detail the detail to set
	 */
	public void setDetail(String detail) {
		this.detail = detail;
	}
}