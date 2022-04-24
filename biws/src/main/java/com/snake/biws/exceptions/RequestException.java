package com.snake.biws.exceptions;

import java.util.Map;

import lombok.Data;

@Data
public class RequestException {

	private String message;
	private String url;
	private int status;
	private Map<String, String> validationErrors;

	public RequestException(int status, String url, String message) {
		this.status = status;
		this.url = url;
		this.message = message;
	}
}
