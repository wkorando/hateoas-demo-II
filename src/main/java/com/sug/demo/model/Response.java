package com.sug.demo.model;

import org.springframework.http.HttpStatus;

public class Response<T> {
	private HttpStatus httpStatus = HttpStatus.OK;
	private String message;
	private T responseBody;

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getResponseBody() {
		return responseBody;
	}

	public void setResponseBody(T responseBody) {
		this.responseBody = responseBody;
	}

}
